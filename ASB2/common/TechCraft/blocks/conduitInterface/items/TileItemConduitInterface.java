package TechCraft.blocks.conduitInterface.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.tcConduits.TileTCConduit;
import TechCraft.conduit.ConduitInterfaceType;
import TechCraft.conduit.ConduitNetwork;
import TechCraft.conduit.IConduitInterface;
import TechCraft.items.ItemLinker;

public class TileItemConduitInterface extends TechCraftTile implements IInventory, IConduitInterface {

    private ItemStack[] tileItemStack;

    ConduitNetwork network;

    public TileItemConduitInterface() {
        super();

        tileItemStack = new ItemStack[22];
    }

    public void updateEntity() {

        this.moveInventory();
    }

    public void moveInventory() {

        if(this.getNetwork() != null) {

            if(this.getNetwork().getConductorSize() != 0) {

            }
        }
    }

    @Override
    public String getName() {

        return "Item Conduit Interface";
    }

    @Override
    public ConduitNetwork getNetwork() {

        return network;
    }

    @Override
    public void overrideNetwork(ConduitNetwork network) {

        this.network = network;        
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

        return "Item Reciever";
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
    public ConduitInterfaceType getInterfaceType() {

        return ConduitInterfaceType.ITEM;
    }

    @Override
    public boolean renderByDirection(ForgeDirection direction) {

        return true;
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
    public boolean importingToNetwork() {

        if(TechCraftTile.translateDirectionToTile(this, worldObj, this.getOrientation()) instanceof TileTCConduit) {

            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveItemToInventory(ItemStack itemStack, int slot, int amount) {

        if(slot != 0 && slot != 1) {

            if(tileItemStack[slot] == null) {

                return true;
            }

            else if(tileItemStack[slot].equals(itemStack)) {

                if(tileItemStack[slot].stackSize + itemStack.stackSize <= this.getInventoryStackLimit()) {

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean moveItemToInventory(ItemStack itemStack, int slot, int amount) {

        if(slot != 0 && slot != 1) {

            if(tileItemStack[slot] == null) {

                tileItemStack[slot] = itemStack;
                return true;
            }

            else if(tileItemStack[slot].equals(itemStack)) {

                if(tileItemStack[slot].stackSize + itemStack.stackSize <= this.getInventoryStackLimit()) {

                    tileItemStack[slot].stackSize = tileItemStack[slot].stackSize + itemStack.stackSize;
                    itemStack = null;

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canTakeItemFromInventory(ItemStack itemStack, int slot, int amount) {

        if(slot != 0 && slot != 1) {

            if(tileItemStack[slot] == null) {

                return false;
            }

            else if(tileItemStack[slot].stackSize >= amount)
                return true;
        }
        return false;
    }

    @Override
    public boolean takeItemFromInventory(ItemStack itemStack, int slot, int amount) {

        if(slot != 0 && slot != 1) {

            if(tileItemStack[slot] == null) {

                return false;
            }

            else if(tileItemStack[slot].stackSize >= amount) {

                if(tileItemStack[slot].stackSize - amount >= 0) {

                    tileItemStack[slot].stackSize = tileItemStack[slot].stackSize - amount;
                    return true; 
                }
                return false;
            }
        }
        return false;
    }
}
