package TechCraft.blocks.technogery.tcFarms.BasicFarm;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;

public class TileBasicFarm extends TechCraftTile implements IPowerSink, IInventory, ISidedInventory {    

    int powerStored;
    int powerMax = 100;

    ItemStack[] tileItemStack;

    public TileBasicFarm(){
        tileItemStack = new ItemStack[14];
    }


    public void updateEntity() {

        super.updateEntity();
        this.managePowerAll(this, powerInput(),false);

        if(manageGround()) {
            
            //harvest();
            plant();
        }
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    public boolean manageGround(){
        int count = 0;

        if(worldObj.getBlockId(xCoord+1, yCoord-1, zCoord) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord-1, yCoord-1, zCoord) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord+1, yCoord-1, zCoord+1) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord-1, yCoord-1, zCoord+1) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord-1, yCoord-1, zCoord-1) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord, yCoord-1, zCoord-1) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord, yCoord-1, zCoord+1) == Block.tilledField.blockID){
            count++;
        }
        if(worldObj.getBlockId(xCoord+1, yCoord-1, zCoord-1) == Block.tilledField.blockID){
            count++;
        }
        return count == 8;

    }

    public void harvest(){

        int internalX = xCoord;
        int internalY = yCoord;
        int internalZ = zCoord;
        @SuppressWarnings("unused")
        Block block = Block.blocksList[worldObj.getBlockId(internalX, internalY, internalZ)];

        internalX = xCoord+1;
        internalY = yCoord+1;
        internalZ = zCoord;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }

        internalX = xCoord-1;
        internalY = yCoord+1;
        internalZ = zCoord;
        if(worldObj.getBlockId(internalX, internalY, internalZ)  == 0){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }

        internalX = xCoord+1;
        internalY = yCoord+1;
        internalZ = zCoord+1;
        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }
        if(worldObj.getBlockId(xCoord-1, yCoord+1, zCoord+1) != Block.tilledField.blockID){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }
        if(worldObj.getBlockId(xCoord-1, yCoord+1, zCoord-1) != Block.tilledField.blockID){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }
        if(worldObj.getBlockId(xCoord, yCoord+1, zCoord-1) != Block.tilledField.blockID){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }
        if(worldObj.getBlockId(xCoord, yCoord+1, zCoord+1) != Block.tilledField.blockID){
            worldObj.destroyBlock(internalX, internalY, internalZ, true);
        }
        if(worldObj.getBlockId(xCoord+1, yCoord+1, zCoord-1) != Block.tilledField.blockID){

        }
    }

    @SuppressWarnings("unused")
    public void plant(){

        int internalX = xCoord;
        int internalY = yCoord;
        int internalZ = zCoord;
        Block block = Block.blocksList[worldObj.getBlockId(internalX, internalY, internalZ)];

        internalX = xCoord+1;
        internalY = yCoord;
        internalZ = zCoord;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord-1;
        internalY = yCoord;
        internalZ = zCoord;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord+1;
        internalY = yCoord;
        internalZ = zCoord+1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord-1;
        internalY = yCoord;
        internalZ = zCoord+1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord-1;
        internalY = yCoord;
        internalZ = zCoord-1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord;
        internalY = yCoord;
        internalZ = zCoord-1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord;
        internalY = yCoord;
        internalZ = zCoord+1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

        internalX = xCoord+1;
        internalY = yCoord;
        internalZ = zCoord-1;

        if(worldObj.getBlockId(internalX, internalY, internalZ) == 0){
            worldObj.setBlock(internalX, internalY, internalZ, Block.potato.blockID);
        }

    }

    @Override
    public String getName() {

        return "Basic TechCraft Farm";
    }

    @Override
    public boolean gainPower(int PowerGained, ForgeDirection direction) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            this.powerStored= powerStored + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        if(powerStored > PowerUsed) {

            powerStored = powerStored - PowerUsed;
            return true;
        }
        return false;
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
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);
        powerStored = par1NBTTagCompound.getInteger("powerStored");

        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");

        tileItemStack = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < tileItemStack.length)
            {
                tileItemStack[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("powerStored", powerStored);

        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < tileItemStack.length; i++)
        {
            if (tileItemStack[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                tileItemStack[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    @Override
    public int getSizeInventory() {
        return tileItemStack.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return tileItemStack[slot];
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
        tileItemStack[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }               
    }

    @Override
    public String getInvName() {

        return "Tile Basic Farm";
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

        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int side) {
        // TODO Auto-generated method stub
        return false;
    }
}
