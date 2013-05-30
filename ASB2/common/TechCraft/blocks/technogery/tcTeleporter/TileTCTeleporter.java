package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.items.ItemTeleporter;
import TechCraft.power.IPowerSink;
import TechCraft.power.PowerNetwork;

public class TileTCTeleporter extends TechCraftTile implements IPowerSink, IInventory{

    int powerStored;
    int powerMax = 100;
    
    int powerForProcess = 50;
    
    ItemStack[] tileItemStacks;

    ItemTeleporter teleporter;
    boolean teleporterSet = false;
    boolean coordsSet = false;

    double x;
    double y;
    double z;

    public TileTCTeleporter() {        
        tileItemStacks = new ItemStack[1];
        
    }

    public void updateEntity() {
        
        super.managePowerAll(this, powerInput(), false);
        super.updateEntity();
        
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

                x = (int)teleporter.getXCoord(tileItemStacks[0]);
                y = (int)teleporter.getYCoord(tileItemStacks[0]);
                z = (int)teleporter.getZCoord(tileItemStacks[0]);

                x = x +=.5;
                y = y + 1;
                z = z +.5;

                coordsSet = true;
            }
        }
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {

        if(teleporterSet && teleporter != null && coordsSet && this.getPowerStored() >= powerForProcess) {

            if(entity instanceof EntityLiving) {

                if(this.usePower(powerForProcess)) {

                    EntityLiving pEntity = (EntityLiving) entity;                
                    pEntity.setPositionAndUpdate(this.x,this.y,this.z);
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {        
        super.readFromNBT(nbtTagCompound);
        powerStored = nbtTagCompound.getInteger("powerStored");

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

        nbtTagCompound.setInteger("powerStored", powerStored);

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
    public boolean gainPower(int PowerGained) {

        if(this.getPowerMax() - this.getPowerStored() >= PowerGained) {

            this.powerStored = this.getPowerStored() + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public boolean usePower(int PowerUsed) {

        if(this.getPowerStored() >= PowerUsed) {

            powerStored = this.getPowerStored() - PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    @Override
    public String getName() {

        return "TC Teleporter";
    }

    public int getPowerStored(){

        return powerStored;        
    }

    public int getPowerMax(){

        return powerMax;
    }

    @Override
    public PowerNetwork getNetwork() {

        return network;
    }

    @Override
    public void overrideNetwork(PowerNetwork network) {

        this.network = network;        
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

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
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
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return true;
    }
}
