package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;
import TechCraft.power.PowerProvider;
import TechCraft.utils.UtilInventory;

public class TileTCInfuser extends TechCraftTile implements IPowerSink, IInventory{

    int powerStored;
    int powerMax = 100;

    ItemStack[] tileItemStacks;

    ItemStack[] craftingSlots;

    public TileTCInfuser() {

        this.powerProvider = new PowerProvider(this, 1000, 1, 1, false, true);
        tileItemStacks = new ItemStack[11];
    }

    public void updateEntity() {
        ticks++;

        super.managePowerAll(this, false);
        super.updateEntity();

        this.craftItem();
    }

    public void craftItem() {

        if(InfuserRecipeList.getInstance().isValidRecipe(getCraftingSlots())) {

            ItemStack outPut = InfuserRecipeList.getInstance().getRecipeClass(getCraftingSlots()).getOutput();
            int cost = InfuserRecipeList.getInstance().getRecipeClass(getCraftingSlots()).getPowerCost();
                    
                    if(this.getPowerProvider().usePower(cost, ForgeDirection.UNKNOWN)) {

                        if(this.getOutputSlot() == null) {

                            if(this.decreaseCraftingSlots()) {

                                this.setInventorySlotContents(10, outPut);
                                return;
                            }
                        }

                        if(this.getOutputSlot().stackSize < this.getInventoryStackLimit()) {

                            if(this.decreaseCraftingSlots()) {

                                ItemStack temp = tileItemStacks[10];
                                
                                temp.stackSize = temp.stackSize + outPut.stackSize;

                                if(temp.stackSize <= this.getInventoryStackLimit()) {

                                    this.setInventorySlotContents(10, temp);
                                    return;
                                }
                            }
                        }
                    }
        }
    }

    public ItemStack[] getCraftingSlots() {

        return new ItemStack[] {
                tileItemStacks[1], tileItemStacks[2],tileItemStacks[3],
                tileItemStacks[4],tileItemStacks[5],tileItemStacks[6],
                tileItemStacks[7],tileItemStacks[8],tileItemStacks[9]
        };
    }

    public ItemStack getOutputSlot() {

        return tileItemStacks[10];
    }

    public boolean decreaseCraftingSlots() {

        int sucessful = 0;

        for(int i = 1; i <= 9; i++) {

            if(UtilInventory.decreaseSlotContents(this, i, 1))
                sucessful++;
        }
        return sucessful == 9;
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
    public String getName() {

        return "Energy Infuser";
    }

    public int getPowerStored(){

        return powerStored;        
    }

    public int getPowerMax(){

        return powerMax;
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
