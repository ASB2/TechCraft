package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import TechCraft.blocks.TechCraftTile;

public class TileGenorator extends TechCraftTile implements IInventory,ISidedInventory {

    private int powerStored = 0;
    private int powerMax = 1000;
    private int currentFuelID = 0;
    private int fuelBurnTime = 0;

    boolean isBurning = false;

    private ItemStack[] tileItemStacks;

    public TileGenorator() {
        tileItemStacks = new ItemStack[10];
    }


    public void updateEntity() {
        super.managePowerAll(this,powerOutput(),true);

        if(!(powerStored == powerMax)){

            manageBurning();
        }

        moveSlots();

        if(fuelBurnTime > 0) {

            this.gainPower(1);
        }
    }

    public void manageBurning() {

        if(fuelBurnTime > 0) {

            isBurning = true;
            fuelBurnTime--;
        }

        if(fuelBurnTime == 0 && TileEntityFurnace.getItemBurnTime(tileItemStacks[9]) != 0) {            

            fuelBurnTime = TileEntityFurnace.getItemBurnTime(tileItemStacks[9]);
            currentFuelID = tileItemStacks[9].itemID;            
            decrStackSize(9,1);
        }  
    }

    public void moveSlots() {
        //If there is no item in the slot or the number of items in the slot is less than the name number of items for the slot
        if(tileItemStacks[9] == null || tileItemStacks[9].stackSize < this.getInventoryStackLimit()) {

            //Loop for all the slots
            for(int i = 0; i < 9; i++) {

                //If there is something in the slot move
                if(tileItemStacks[i] != null) {

                    //if that item is equal to the burning slot or the b urning slot if equal to null
                    if(tileItemStacks[9] == null) {

                        if(tileItemStacks[i].stackSize > 1) {

                            tileItemStacks[9] = tileItemStacks[i].copy();

                            tileItemStacks[9].stackSize = tileItemStacks[i].stackSize - tileItemStacks[i].stackSize - 1;
                            decrStackSize(i,1);
                        }

                        if(tileItemStacks[i].stackSize == 1) {
                            tileItemStacks[9] = tileItemStacks[i].copy();
                            decrStackSize(i,1);
                        }

                        if(tileItemStacks[9].stackSize > 1) {

                            if(tileItemStacks[i]==(tileItemStacks[9])) {

                                tileItemStacks[9].stackSize = tileItemStacks[9].stackSize +1 ;
                                decrStackSize(i,1);
                            }
                        }
                    }


                }
            }
        }
    }

    @Override
    public boolean outputPower() {

        return true;
    }
    
    public int getBurnTimeScaled(int scale){        

        int internal = this.fuelBurnTime * scale / 100;
        if(internal > scale){
            internal = scale;
        }
        return internal;

    }

    public int getMagicScaled(int scale) {

        int internal = (int)this.powerStored * scale / (int)powerMax;
        if(internal > scale){
            internal = scale;
        }
        return internal;
    }

    public int getOutput(){
        return 5;
    }

    public int getPowerStored() {
        return powerStored;
    }

    public int getPowerMax() {
        return powerMax;
    }
    
    @Override
    public boolean usePower(int PowerUsed) {

        if(this.powerStored>=PowerUsed) {
            
            this.powerStored= powerStored-PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {

        if(powerMax -powerStored >= PowerGained) {
            
            powerStored = powerStored + PowerGained;
            return true;
        }
        return false;
    }
    
    public String getName(){

        return "TechCraft Genorator";
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);
        powerStored = par1NBTTagCompound.getInteger("powerStored");
        currentFuelID = par1NBTTagCompound.getInteger("currentFuelID");

        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");

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

    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("powerStored", powerStored);
        par1NBTTagCompound.setInteger("currentFuelID", currentFuelID);
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

        par1NBTTagCompound.setTag("Items", nbttaglist);
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
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        tileItemStacks[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }               
    }

    @Override
    public String getInvName() {

        return "TC Genortor";
    }

    @Override
    public boolean isInvNameLocalized() {

        return true;
    }

    @Override
    public int getInventoryStackLimit() {

        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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
        return TileEntityFurnace.isItemFuel(itemstack);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

}
