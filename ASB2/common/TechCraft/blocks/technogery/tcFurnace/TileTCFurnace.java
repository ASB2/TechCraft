package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;

public class TileTCFurnace extends TechCraftTile implements IInventory,ISidedInventory,IPowerSink{

    int powerStored = 0;
    int powerMax = 100;

    int powerForProcess = 10;

    private ItemStack[] tileItemStacks;

    boolean isBurning = false;

    ItemStack currentItem;

    private static final int[] sidedSlotSides = new int[] {0};
    private static final int[] sidedSlotBottom = new int[] {1};
    private static final int[] sidedSlotTop = new int[] {0};

    public TileTCFurnace(){

        tileItemStacks = new ItemStack[2];
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    public void updateEntity() {        
        super.managePowerAll(this, powerInput(),false);

        if(this.getPowerStored() > 0){
            isBurning = true;
        }

        if(this.getPowerStored() == 0){
            isBurning = false;
        }

        if (this.isBurning && this.canSmelt() && this.getPowerStored() >= this.powerForProcess) {            
            this.smeltItem();    
            this.usePower(powerForProcess);
        }

    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.tileItemStacks[0]);

            if (this.tileItemStacks[1] == null)
            {
                this.tileItemStacks[1] = itemstack.copy();
            }
            else if (this.tileItemStacks[1].isItemEqual(itemstack))
            {
                tileItemStacks[1].stackSize += itemstack.stackSize;
            }

            --this.tileItemStacks[0].stackSize;

            if (this.tileItemStacks[0].stackSize <= 0)
            {
                this.tileItemStacks[0] = null;
            }
        }
    }

    private boolean canSmelt()
    {
        if (this.tileItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.tileItemStacks[0]);
            if (itemstack == null) return false;
            if (this.tileItemStacks[1] == null) return true;
            if (!this.tileItemStacks[1].isItemEqual(itemstack)) return false;
            int result = tileItemStacks[1].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public int getPowerScaled(int scale) {

        int internal = (int)this.powerStored * scale / (int)powerMax;
        if(internal > scale){
            internal = scale;
        }
        return internal;
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);

        powerStored = par1NBTTagCompound.getInteger("powerStored");
        isBurning = par1NBTTagCompound.getBoolean("isBurning");

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
        par1NBTTagCompound.setBoolean("isBurning", isBurning);

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
    public void setInventorySlotContents(int slot, ItemStack stack) {
        tileItemStacks[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }               
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
    public boolean isUseableByPlayer(EntityPlayer player) {

        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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
    public boolean usePower(int PowerUsed) {

        if(this.powerStored>=PowerUsed) {

            this.powerStored = powerStored - PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            this.powerStored = powerStored + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public String getName() {

        return "TC Furnace";
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? sidedSlotBottom : (par1 == 1 /*Top:Side*/ ? sidedSlotTop : sidedSlotSides);
    }

    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isStackValidForSlot(par1, par2ItemStack);
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
    }

    @Override
    public String getInvName() {

        return this.getName();
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
    public void openChest() {
        // TODO Auto-generated method stub

    }
    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? TileEntityFurnace.isItemFuel(par2ItemStack) : true);
    }
}
