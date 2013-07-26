package TechCraft.blocks.technogery.tcEnergyConstructor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;
import TechCraft.utils.UtilPower;

public class TileTCEnergyConstructor extends TechCraftTile implements IPowerMisc, IInventory{

    boolean targetFuelSet = false;
    ItemStack targetFuel;

    ItemStack[] tileItemStacks;

    public TileTCEnergyConstructor() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
        
        tileItemStacks = new ItemStack[5];
    }

    public void updateEntity() {
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

                if(this.getPowerProvider().getPowerStored() >= TileEntityFurnace.getItemBurnTime(targetFuel) / UtilPower.TICKSTOPOWER) {

                    if(this.getPowerProvider().usePower(TileEntityFurnace.getItemBurnTime(targetFuel)/ UtilPower.TICKSTOPOWER, ForgeDirection.UNKNOWN)) {

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
    public String getName() {

        return "TC energy Constructor";
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
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {

        if(TileEntityFurnace.getItemBurnTime(itemstack) > 0) {

            return true;
        }
        return false;
    }
}
