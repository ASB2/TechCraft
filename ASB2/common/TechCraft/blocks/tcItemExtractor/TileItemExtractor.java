package TechCraft.blocks.tcItemExtractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.ConduitNetwork;
import TechCraft.items.ItemLinker;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilInventory;

public class TileItemExtractor extends TechCraftTile implements IInventory {

    private ItemStack[] tileItemStack;

    ConduitNetwork network;

    public TileItemExtractor() {

        tileItemStack = new ItemStack[8];
    }

    public void updateEntity() {

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            ticks++;
            if(ticks >= 20) {

                this.moveFromAjacentInventory(ForgeDirection.DOWN);
                this.moveFromAjacentInventory(ForgeDirection.UP);
                this.moveFromAjacentInventory(ForgeDirection.NORTH);
                this.moveFromAjacentInventory(ForgeDirection.SOUTH);
                this.moveFromAjacentInventory(ForgeDirection.WEST);
                this.moveFromAjacentInventory(ForgeDirection.EAST);

            }
        }
    }
    /**
     * Moves an item from the specified direction into the tile
     * @param ForgeDirection
     */
    public void moveFromAjacentInventory(ForgeDirection direction) {

        if(direction == this.getOrientation()) {

            TileEntity tile = UtilDirection.translateDirectionToTile(this, worldObj, direction);

            if(tile != null) {

                if(tile instanceof IInventory && !(tile instanceof ISidedInventory)) {

                    IInventory tileI = (IInventory)tile;

                    UtilInventory.moveAllInventorySlots(tileI, this);
                }

                if(tile instanceof ISidedInventory) {

                    ISidedInventory tileS = (ISidedInventory)tile;

                    UtilInventory.moveFromAllISidedSlots(tileS, UtilDirection.translateDirectionToNumber(UtilDirection.translateDirectionToOpposite(direction)), this);
                }
            }
        }
        else if(direction == UtilDirection.translateDirectionToOpposite(this.getOrientation())) {
         
            TileEntity tile = UtilDirection.translateDirectionToTile(this, worldObj, direction);

            if(tile != null) {

                if(tile instanceof IInventory && !(tile instanceof ISidedInventory)) {

                    IInventory tileI = (IInventory)tile;

                    UtilInventory.moveAllInventorySlots(this, tileI);
                }

                if(tile instanceof ISidedInventory) {

                    ISidedInventory tileS = (ISidedInventory)tile;

                    UtilInventory.moveToAllISidedSlots(tileS, UtilDirection.translateDirectionToNumber(UtilDirection.translateDirectionToOpposite(direction)), this);
                }
            }
        }
    }

    @Override
    public String getName() {

        return "Item Conduit Interface";
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
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        tileItemStack[slot] = itemStack;
    }

    @Override
    public String getInvName() {

        return "Item Extractor";
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

        if(slot == 0 && itemStack.getItem() instanceof ItemLinker) {

            return true;
        }

        else if(slot > 0) {

            return true;
        }

        return false;
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
}
