package TechCraft.blocks.tcDeepStorageCell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import TechCraft.blocks.TechCraftTile;
import TechCraft.circuits.ISimpleDataCircuit;

public class TileDeepStorageCell extends TechCraftTile implements ISidedInventory{

    private ItemStack[] tileItemStack;
    ISimpleDataCircuit circuit;
    boolean circuitSet = false;

    public TileDeepStorageCell() {

        tileItemStack = new ItemStack[3];
    }

    public void updateEntity() {
        ticks++;

        if(tileItemStack[0] != null) {

            if(tileItemStack[0].getItem() instanceof ISimpleDataCircuit && !circuitSet) {

                circuit = (ISimpleDataCircuit)tileItemStack[0].getItem();   
                circuitSet = true;
            }
        }
        else {

            circuit = null;
            circuitSet = false;
        }

        if(ticks >= 20) {
            moveItemStackToCircuit();
            moveItemFromCircuit();
            ticks = 0;
        }
    }

    public void moveItemStackToCircuit() {

        if(circuitSet) {

            for(int i = 0; i < tileItemStack.length; i++) {

                if(i != 0 && i != 2) {

                    if(tileItemStack[i] != null) {

                        if(!tileItemStack[i].isItemDamaged() && !tileItemStack[i].hasTagCompound() && !tileItemStack[i].getHasSubtypes() && !tileItemStack[i].isItemEnchanted() && !(tileItemStack[i].getItemDamage() > 0)) {

                            if(circuit.getType(tileItemStack[0]) == tileItemStack[i].itemID || (circuit.getType(tileItemStack[0]) == 0 && circuit.getStoredData(tileItemStack[0]) == 0)) {

                                if(circuit.getType(tileItemStack[0]) == 0) 
                                    circuit.setType(tileItemStack[0], tileItemStack[i].itemID);

                                if(circuit.getMaximumData(tileItemStack[0]) > circuit.getStoredData(tileItemStack[0])) {

                                    if(circuit.setStoredData(tileItemStack[0], circuit.getStoredData(tileItemStack[0]) + 1, true)) {

                                        if(this.tileItemStack[i].stackSize == 1) {

                                            this.tileItemStack[i] = null;
                                        }
                                        else {

                                            this.decrStackSize(i, 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveItemFromCircuit() {

        if(circuitSet) {

            if(circuit.getStoredData(tileItemStack[0]) > 0) {

                if(circuit.getType(tileItemStack[0]) != 0) {

                    if(this.tileItemStack[2] == null) {

                        if(circuit.getStoredData(tileItemStack[0]) >= this.getInventoryStackLimit()) {

                            if(circuit.setStoredData(tileItemStack[0], this.getInventoryStackLimit(), false)) {

                                tileItemStack[2] = new ItemStack(circuit.getType(tileItemStack[0]), this.getInventoryStackLimit() , 0);
                            }
                        }

                        else {

                            if(circuit.setStoredData(tileItemStack[0], 0, false)) {

                                tileItemStack[2] = new ItemStack(circuit.getType(tileItemStack[0]), circuit.getStoredData(tileItemStack[0]),0);
                            }
                        }
                    }

                    else if (circuit.getType(tileItemStack[0]) == tileItemStack[2].itemID) {

                        if((tileItemStack[2].stackSize + 1 <= this.getInventoryStackLimit())) {

                            if(circuit.setStoredData(tileItemStack[0], circuit.getStoredData(tileItemStack[0]) - 1, false)) {

                                ItemStack stack = tileItemStack[2];
                                stack.stackSize = stack.stackSize + 1;
                                tileItemStack[2] = stack;
                            }
                        }
                    }
                }
            }         
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);

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
            } 
            else {

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

        return "Deep Storage Cell";
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
    public boolean isStackValidForSlot(int slot, ItemStack itemStack) {

        if(slot == 0 && itemStack.getItem() instanceof ISimpleDataCircuit) {
            return true;
        }

        else if(slot > 0) {

            return true;
        }

        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {

        return new int[]{1,2};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {

        if(slot == 0) {

            if(itemstack.getItem() instanceof ISimpleDataCircuit) {

                return true;
            }
        }
        else if(this.tileItemStack[slot] == null){

            return true;
        }

        else if(tileItemStack[slot].stackSize + itemstack.stackSize <= this.getInventoryStackLimit()) {

            return true;
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side) {

        if(tileItemStack[slot] != null) {

            return true;
        }
        return false;
    }
}
