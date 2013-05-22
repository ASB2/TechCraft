package TechCraft.blocks.technogery.tcChargeBench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import TechCraft.power.IPowerItems;
import TechCraft.power.IPowerSink;
import TechCraft.power.TechCraftTile;

public class TileTCChargeBench extends TechCraftTile implements IPowerSink, IInventory{

    int powerStored;
    int powerMax = 1000;
    int powerToMove = 5;

    ItemStack[] tileItemStacks;

    public TileTCChargeBench(){
        tileItemStacks = new ItemStack[6];
    }
    public void updateEntity() {
        super.managePowerAll(this,getOutputMin(),false);
        addEnergyToSlot();
    }    

    public void addEnergyToSlot() {
        
        
        if(tileItemStacks[0] != null){

            if(tileItemStacks[0].getItem() != null && tileItemStacks[0].getItem() instanceof IPowerItems) {

                IPowerItems tcItem = (IPowerItems) tileItemStacks[0].getItem();

                if(tcItem.getPowerMax(tileItemStacks[0]) - tcItem.getPowerStored(tileItemStacks[0]) >= powerToMove && this.getPowerStored() >= powerToMove){

                    tcItem.gainPower(powerToMove, tileItemStacks[0]);
                    this.usePower(powerToMove);
                }
            }
        }
    }

    public void removeEnergySlot(){

    }

    @Override
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    @Override
    public String getName() {

        return "TC Charge Bench";
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
    public int getOutputMax() {

        return 5;
    }

    @Override
    public int getOutputMin() {

        return 1;
    }

    @Override
    public void gainPower(int PowerGained) {

        if(this.getPowerMax() - this.getPowerStored() >= PowerGained) {

            this.powerStored = this.getPowerStored() + PowerGained;
        }
    }

    @Override
    public void usePower(int PowerUsed) {
        
        if(this.getPowerStored() >= PowerUsed) {

            powerStored = this.getPowerStored() - PowerUsed;
        }
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
