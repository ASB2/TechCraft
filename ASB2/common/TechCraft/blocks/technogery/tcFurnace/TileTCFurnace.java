package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;

public class TileTCFurnace extends TechCraftTile implements IInventory, ISidedInventory, IPowerMisc {

    int powerForProcess = 50;

    private ItemStack[] tileItemStacks;

    boolean isBurning = false;

    public TileTCFurnace() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
        tileItemStacks = new ItemStack[2];
    }

    public void updateEntity() {

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            if(this.getPowerProvider().getPowerStored() > 0) {

                if(!isBurning)
                    isBurning = true;

                if(!(this.getBlockMetadata() == 2)) {

                    worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 2, 3);
                }
            }

            if(this.getPowerProvider().getPowerStored() == 0) {

                isBurning = false;
                if(!(this.getBlockMetadata() == 1))
                    worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);

            }

            if(this.isBurning && this.canSmelt() && this.getPowerProvider().canUsePower(powerForProcess)) {            

                if( this.getPowerProvider().usePower(powerForProcess, ForgeDirection.UNKNOWN)) {
                    this.smeltItem();    
                }

            }
        }
    }

    public void smeltItem() {

        if (this.canSmelt()) {

            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.tileItemStacks[0]);

            if (this.tileItemStacks[1] == null) {

                this.tileItemStacks[1] = itemstack.copy();
            }
            else if (this.tileItemStacks[1].isItemEqual(itemstack)) {

                tileItemStacks[1].stackSize += itemstack.stackSize;
            }

            --this.tileItemStacks[0].stackSize;

            if (this.tileItemStacks[0].stackSize <= 0) {

                this.tileItemStacks[0] = null;
            }
        }
    }

    private boolean canSmelt() {

        if (this.tileItemStacks[0] == null) {

            return false;
        }
        else {

            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.tileItemStacks[0]);
            if (itemstack == null) return false;
            if (this.tileItemStacks[1] == null) return true;
            if (!this.tileItemStacks[1].isItemEqual(itemstack)) return false;
            int result = tileItemStacks[1].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);

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
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        tileItemStacks[slot] = itemStack;
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
    public String getName() {

        return "Speedy Furnace";
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return new int[]{0,1};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        
        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(itemStack);

        if(slot == 0) {

            if(itemstack != null) {

                if(this.tileItemStacks[0] == null || this.tileItemStacks[0].equals(itemStack)) {                    

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        
        if(slot != 0) {

            if(this.tileItemStacks[slot] != null) {
                return true;
            }
        }
        return false;
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
    public boolean isStackValidForSlot(int slot, ItemStack itemStack) {

        if(slot == 0) {

            if(tileItemStacks[0] == null && itemStack != null) {

                return true;
            }

            else if(this.tileItemStacks[0].equals(itemStack)) {

                return true;
            }
        }
        return false;
    }
}
