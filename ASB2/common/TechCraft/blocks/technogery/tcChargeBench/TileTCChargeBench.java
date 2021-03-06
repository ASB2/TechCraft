package TechCraft.blocks.technogery.tcChargeBench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerItems;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;

public class TileTCChargeBench extends TechCraftTile implements IPowerMisc, IInventory {

    int powerToMove = 1;

    ItemStack[] tileItemStacks;

    public TileTCChargeBench() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
        tileItemStacks = new ItemStack[6];
    }

    public void updateEntity() {

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            addEnergyToSlot();
            removeEnergySlot();
        }
    }

    public void addEnergyToSlot() {        

        if(this.getPowerProvider().getPowerStored() > 0) {
            
            if(tileItemStacks[0] != null) {

                if(tileItemStacks[0].getItem() != null && tileItemStacks[0].getItem() instanceof IPowerItems) {

                    IPowerItems tcItem = (IPowerItems) tileItemStacks[0].getItem();

                    if(tcItem.canGainPower(powerToMove, tileItemStacks[0]) && this.getPowerProvider().canUsePower(powerToMove)) {

                        tcItem.gainPower(powerToMove, tileItemStacks[0]);
                        this.getPowerProvider().usePower(powerToMove, ForgeDirection.UNKNOWN);
                    }
                }
            }

            if(tileItemStacks[1] != null) {

                if(tileItemStacks[1].getItem() != null && tileItemStacks[1].getItem() instanceof IPowerItems) {

                    IPowerItems tcItem = (IPowerItems) tileItemStacks[1].getItem();

                    if(tcItem.canGainPower(powerToMove, tileItemStacks[1]) && this.getPowerProvider().canUsePower(powerToMove)) {

                        tcItem.gainPower(powerToMove, tileItemStacks[1]);
                        this.getPowerProvider().usePower(powerToMove, ForgeDirection.UNKNOWN);
                    }
                }
            }

            if(tileItemStacks[2] != null) {

                if(tileItemStacks[2].getItem() != null && tileItemStacks[2].getItem() instanceof IPowerItems) {

                    IPowerItems tcItem = (IPowerItems) tileItemStacks[2].getItem();

                    if(tcItem.canGainPower(powerToMove, tileItemStacks[2]) && this.getPowerProvider().canUsePower(powerToMove)) {

                        tcItem.gainPower(powerToMove, tileItemStacks[2]);
                        this.getPowerProvider().usePower(powerToMove, ForgeDirection.UNKNOWN);
                    }
                }
            }
        }
    }

    public void removeEnergySlot() {

        if(tileItemStacks[3] != null) {

            if(tileItemStacks[3].getItem() != null && tileItemStacks[3].getItem() instanceof IPowerItems) {

                IPowerItems tcItem = (IPowerItems) tileItemStacks[3].getItem();

                if(tcItem.canUsePower(powerToMove, tileItemStacks[3]) && this.getPowerProvider().canGainPower(powerToMove)){

                    this.getPowerProvider().gainPower(powerToMove, ForgeDirection.UNKNOWN);                    
                    tcItem.usePower(powerToMove, tileItemStacks[3]);
                }
            }
        }

        if(tileItemStacks[4] != null) {

            if(tileItemStacks[4].getItem() != null && tileItemStacks[4].getItem() instanceof IPowerItems) {

                IPowerItems tcItem = (IPowerItems) tileItemStacks[4].getItem();

                if(tcItem.canUsePower(powerToMove, tileItemStacks[4]) && this.getPowerProvider().canGainPower(powerToMove)){

                    tcItem.usePower(powerToMove, tileItemStacks[4]);
                    this.getPowerProvider().gainPower(powerToMove, ForgeDirection.UNKNOWN);                        
                }
            }
        }

        if(tileItemStacks[5] != null) {

            if(tileItemStacks[5].getItem() != null && tileItemStacks[5].getItem() instanceof IPowerItems) {

                IPowerItems tcItem = (IPowerItems) tileItemStacks[5].getItem();

                if(tcItem.canUsePower(powerToMove, tileItemStacks[5]) && this.getPowerProvider().canGainPower(powerToMove)){

                    tcItem.usePower(powerToMove, tileItemStacks[5]);
                    this.getPowerProvider().gainPower(powerToMove, ForgeDirection.UNKNOWN);
                }
            }
        }
    }

    @Override
    public String getName() {

        return "TC Charge Bench";
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
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return true;
    }
}
