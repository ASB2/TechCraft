package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.TCPowerProvider;
import TechCraft.utils.UtilPower;

public class TileGenorator extends TechCraftTile implements IInventory, ISidedInventory, IPowerMisc {

    private int powerStored = 0;
    private int powerMax = 1000;
    private int currentFuelID = 0;
    private int fuelBurnTime = 0;

    boolean isBurning = false;

    private ItemStack[] tileItemStacks;

    public TileGenorator() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW);
        tileItemStacks = new ItemStack[10];
    }

    int ticks = 0;

    public void updateEntity() {

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
            ticks++;        

            if(!(powerStored == powerMax)) {

                if(fuelBurnTime > 0) {

                    if(!isBurning)
                        isBurning = true;

                    fuelBurnTime--;

                    if(!(this.getBlockMetadata() == 2)) {

                        worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 2, 3);
                    }
                }

                if(fuelBurnTime == 0) {            

                    isBurning = false;
                    currentFuelID = 0;

                    if(!(this.getBlockMetadata() == 1))
                        worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);


                    if(TileEntityFurnace.getItemBurnTime(tileItemStacks[9]) > 0) {

                        fuelBurnTime = TileEntityFurnace.getItemBurnTime(tileItemStacks[9]);             
                        currentFuelID = tileItemStacks[9].itemID;                            
                        decrStackSize(9,1);
                    }
                }


                if(fuelBurnTime > 0) {

                    if(ticks >= UtilPower.TICKSTOPOWER) {

                        ticks = 0;
                        this.getPowerProvider().gainPower(1, ForgeDirection.UNKNOWN);
                    }
                }
            }
            moveSlots();
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

                        tileItemStacks[9] = tileItemStacks[i].copy();
                        tileItemStacks[i] = null;
                    }

                    else if(tileItemStacks[9].stackSize > 1) {

                        if(tileItemStacks[i].isItemEqual((tileItemStacks[9]))) {

                            tileItemStacks[9].stackSize = tileItemStacks[9].stackSize +1 ;
                            decrStackSize(i,1);
                        }
                    }
                }
            }
        }
    }

    public int getBurnTimeScaled(int scale){        

        int internal = this.fuelBurnTime * scale / 100;
        if(internal > scale){
            internal = scale;
        }
        return internal;

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
    public boolean isStackValidForSlot(int slot, ItemStack itemstack) {

        return TileEntityFurnace.isItemFuel(itemstack);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {

        return new int[]{0,1,2,3,4,5,6,7,8,9};
    }


    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {

        if(TileEntityFurnace.isItemFuel(itemstack)) {

            return true;
        }
        return true;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

}
