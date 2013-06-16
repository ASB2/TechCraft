package TechCraft.blocks.technogery.tcEnergyConstructor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.utils.Utilities;
import TechCraft.power.IPowerSink;

public class TileTCEnergyConstructor extends TechCraftTile implements IPowerSink, IInventory{

    int powerStored;
    int powerMax = 1000;

    boolean targetFuelSet = false;
    ItemStack targetFuel;

    ItemStack[] tileItemStacks;

    public TileTCEnergyConstructor() {

        tileItemStacks = new ItemStack[5];
    }

    public void updateEntity() {
        this.managePowerAll(this, powerInput(), false);
        super.updateEntity();

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
            this.moveSlots();

            if(tileItemStacks[0] != null) {

                if(!targetFuelSet){

                    targetFuel = tileItemStacks[0];
                    targetFuelSet = true;
                }

                if(targetFuel != null && targetFuelSet) {

                    this.formItem(); 
                }

            }
            else {

                targetFuelSet = false;
            }
        }
    }    

    public void formItem() {

        if(TileEntityFurnace.isItemFuel(targetFuel)) {

            if(TileEntityFurnace.getItemBurnTime(targetFuel) > 0) {

                if(this.getPowerStored() >= TileEntityFurnace.getItemBurnTime(targetFuel) / Utilities.TICKSTOPOWER) {

                    if(this.usePower(TileEntityFurnace.getItemBurnTime(targetFuel)/ Utilities.TICKSTOPOWER, ForgeDirection.UNKNOWN)) {

                        if(tileItemStacks[1] == null) {

                            tileItemStacks[1] = targetFuel;
                            tileItemStacks[1].stackSize = 1;
                            return;
                        }
                        int stacksAdded  = tileItemStacks[1].stackSize;

                        if(tileItemStacks[1] == targetFuel) {

                            if(stacksAdded + 1 <= this.getInventoryStackLimit()) {                            

                                tileItemStacks[1].stackSize = stacksAdded + 1;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveSlots() {

        if(tileItemStacks[1] != null) {

            for(int i = 2; i < tileItemStacks.length; i++) {

                if(tileItemStacks[i] == null) {

                    tileItemStacks[i] = tileItemStacks[1];
                    tileItemStacks[1] = null;
                    return;
                }

                else  {

                    if(tileItemStacks[1] != null) {

                        int stackSize = tileItemStacks[i].stackSize;

                        if(tileItemStacks[1].getItem() == (tileItemStacks[i]).getItem()) {

                            if(stackSize + tileItemStacks[1].stackSize <= this.getInventoryStackLimit()) {

                                tileItemStacks[i] = tileItemStacks[1];
                                tileItemStacks[i].stackSize = stackSize + tileItemStacks[1].stackSize;
                                tileItemStacks[1] = null;
                                return;
                            }

                            else {

                                // tileItemStacks[i] = tileItemStacks[1];
                                //tileItemStacks[i].stackSize = (tileItemStacks[1].stackSize + this.getInventoryStackLimit()) - stackSize;
                                // tileItemStacks[1].stackSize = (stackSize + tileItemStacks[1].stackSize) - this.getInventoryStackLimit();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean recievePower() {

        return true;
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
    public String getName() {

        return "TC energy Constructor";
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {        
        super.readFromNBT(nbtTagCompound);

        this.powerStored = nbtTagCompound.getInteger("powerStored");

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
    public boolean gainPower(int PowerGained, ForgeDirection direction) {

        if(this.getPowerMax() - this.getPowerStored() >= PowerGained) {

            this.powerStored = this.getPowerStored() + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        if(this.getPowerStored() >= PowerUsed) {

            powerStored = this.getPowerStored() - PowerUsed;
            return true;
        }
        return false;
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

        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {

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
    public boolean isStackValidForSlot(int slot, ItemStack itemstack) {

        if(TileEntityFurnace.getItemBurnTime(itemstack) > 0) {

            return true;
        }
        return false;
    }
}
