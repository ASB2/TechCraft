package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.items.ItemTeleporter;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;

public class TileTCTeleporter extends TechCraftTile implements IPowerMisc, IInventory {

    int powerForProcess = 50;

    ItemStack[] tileItemStacks;

    ItemTeleporter teleporter;
    boolean teleporterSet = false;
    boolean coordsSet = false;

    double x;
    double y;
    double z;
    int dimentionID = 0;    
    
    public TileTCTeleporter() {        

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
        tileItemStacks = new ItemStack[1];
    }

    public void updateEntity() {

            if(tileItemStacks[0] == null) {
                teleporterSet = false;
                coordsSet = false;
                teleporter = null;
            }

            if(!teleporterSet && tileItemStacks[0] != null) {

                if(tileItemStacks[0].getItem() instanceof ItemTeleporter) {

                    teleporter = (ItemTeleporter) tileItemStacks[0].getItem();
                    teleporterSet = true;
                }
            }

            if(teleporterSet && teleporter != null && !coordsSet) {

                if(teleporter.isCoodsSet(tileItemStacks[0])) {

                    x = teleporter.getXCoord(tileItemStacks[0]);
                    y = teleporter.getYCoord(tileItemStacks[0]);
                    z = teleporter.getZCoord(tileItemStacks[0]);
                    dimentionID = (int)teleporter.getDimentionIDCoord(tileItemStacks[0]);   

                    y = y + 1;

                    coordsSet = true;
                }
            }
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            if(teleporterSet && coordsSet && this.getPowerProvider().getPowerStored() >= powerForProcess) {

                if(teleporter != null) {

                    if(entity instanceof EntityPlayerMP) {

                        if(this.getPowerProvider().usePower(powerForProcess, ForgeDirection.UNKNOWN)) {

                            EntityPlayerMP player = (EntityPlayerMP) entity;     

                            for(int i = 0; i < 2; i++) {

                                if (player.dimension != this.dimentionID) {

                                    player.travelToDimension(this.dimentionID);
                                }

                                else {

                                    player.setPositionAndUpdate(this.x, this.y, this.z);
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {        
        super.readFromNBT(nbtTagCompound);

        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items");
        tileItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < tileItemStacks.length)
            {
                tileItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < tileItemStacks.length; i++)
        {
            if (tileItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                tileItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbtTagCompound.setTag("Items", nbttaglist);
    }

    @Override
    public String getName() {

        return "TC Teleporter";
    }

    @Override
    public int getSizeInventory() {

        return tileItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return tileItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            }

            else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {

        ItemStack itemStack = getStackInSlot(slot);

        if (itemStack != null) {
            setInventorySlotContents(slot, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        tileItemStacks[slot] = itemStack;
    }

    @Override
    public String getInvName() {

        return getName();
    }

    @Override
    public boolean isInvNameLocalized() {

        return true;
    }

    @Override
    public int getInventoryStackLimit() {

        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void openChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return true;
    }
}
