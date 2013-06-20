package TechCraft.blocks.conduitInterface.items;

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
import TechCraft.conduit.EnumInterfaceType;
import TechCraft.conduit.IConduitConductor;
import TechCraft.conduit.IConduitInterfaceItem;
import TechCraft.items.ItemLinker;

public class TileItemConduitInterface extends TechCraftTile implements IInventory, IConduitInterfaceItem {

    private ItemStack[] tileItemStack;

    ConduitNetwork network;

    public TileItemConduitInterface() {
        super();

        tileItemStack = new ItemStack[22];
    }

    public void updateEntity() {

        ticks++;

        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            if(ticks >= 200) {

                this.moveFromAjacentInventory(ForgeDirection.DOWN);
                this.moveFromAjacentInventory(ForgeDirection.UP);
                this.moveFromAjacentInventory(ForgeDirection.NORTH);
                this.moveFromAjacentInventory(ForgeDirection.SOUTH);
                this.moveFromAjacentInventory(ForgeDirection.WEST);
                this.moveFromAjacentInventory(ForgeDirection.EAST);

                if(this.importingToNetwork()) {

                    //this.moveItemsToInventory();
                }
                else {

                    //this.moveSlotToInventory();
                }
            }
        }
    }

    /**
     * Moves items from ajacent inventories
     */
    public void moveSlotToInventory() {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(getOrientation(), this)[0], TechCraftTile.translateDirectionToCoords(getOrientation(), this)[1], TechCraftTile.translateDirectionToCoords(getOrientation(), this)[2]);

        if(tile != null) {

            if(tile instanceof IInventory && !(tile instanceof ISidedInventory) && !(tile instanceof IConduitInterfaceItem)) {

                IInventory tileI = (IInventory)tile;

                if(tileI != null) {

                    if(tileI.getInventoryStackLimit() > 0 && tileI.getSizeInventory() > 0) {

                        for(int i = 0; i < tileItemStack.length; i++) {

                            if(tileItemStack[i] != null) {

                                if(i != 0) {

                                    for(int z = 0; z < tileI.getSizeInventory(); z++) {

                                        if(tileI.getStackInSlot(z) != null) {

                                            if(tileI.isStackValidForSlot(z, tileItemStack[i])) {

                                                if(tileI.getStackInSlot(z).stackSize <= tileI.getInventoryStackLimit() && tileI.getStackInSlot(z).stackSize <= tileI.getStackInSlot(z).getItem().getItemStackLimit()) {

                                                    int size = tileI.getStackInSlot(z).stackSize;

                                                    if(size != tileI.getStackInSlot(z).getItem().getItemStackLimit() && size <= tileI.getInventoryStackLimit()) {

                                                        if(this.tileItemStack[i] != null) {  

                                                            if(size + tileItemStack[i].stackSize <= tileI.getInventoryStackLimit()) {

                                                                if(size + tileItemStack[i].stackSize <= tileI.getStackInSlot(z).getItem().getItemStackLimit()) {

                                                                    ItemStack internalStack = tileItemStack[i].copy();

                                                                    internalStack.stackSize = size + tileItemStack[i].stackSize;

                                                                    tileI.setInventorySlotContents(z,internalStack);
                                                                    tileItemStack[i] = null;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                        }

                                        else {
                                            tileI.setInventorySlotContents(z, tileItemStack[i]);
                                            tileItemStack[i] = null;
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }            

            if(tile instanceof ISidedInventory) {

                ISidedInventory tileS = (ISidedInventory)tile;

                if(tileS.getAccessibleSlotsFromSide(TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(getOrientation()))).length > 0) {

                    int side = TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(getOrientation()));

                    if(tileS != null) {

                        for(int i = 0; i < tileItemStack.length; i++) {

                            if(tileItemStack[i] != null) {

                                int[] slots = tileS.getAccessibleSlotsFromSide(side);

                                for(int z = 0; z < slots.length; z++) {

                                    int slotS = slots[z];

                                    if(tileS.canInsertItem(slotS, tileItemStack[i], side)) {

                                        if(tileS.getStackInSlot(slotS) != null) {

                                            if(tileItemStack[i].stackSize + tileS.getStackInSlot(slotS).stackSize <= tileS.getInventoryStackLimit()) {

                                                if(this.tileItemStack[i] != null) {  

                                                    if(tileS.getStackInSlot(slotS).stackSize + tileItemStack[i].stackSize <= tileS.getInventoryStackLimit()) {

                                                        if(tileS.getStackInSlot(slotS).stackSize + tileItemStack[i].stackSize <= tileS.getInventoryStackLimit()) {

                                                            ItemStack internalStack = tileS.getStackInSlot(slotS);
                                                            internalStack.stackSize = tileS.getStackInSlot(slotS).stackSize + tileItemStack[i].stackSize;

                                                            tileS.setInventorySlotContents(slotS, internalStack);
                                                            tileItemStack[i] = null;
                                                        }
                                                    }
                                                }                                                
                                            }
                                        }
                                        else {
                                            tileS.setInventorySlotContents(slotS, tileItemStack[i]);
                                            tileItemStack[i] = null;
                                        }
                                    }
                                }
                            }
                        }                        
                    } 
                }
            }

            if(tile instanceof IConduitInterfaceItem && tile instanceof IInventory) {

                IConduitInterfaceItem tileC = (IConduitInterfaceItem)tile;
                IInventory tileI = (IInventory)tile;

                if(tileI.getInventoryStackLimit() > 0 && tileI.getSizeInventory() > 0) {

                    for(int z = 0; z < tileItemStack.length; z++) {

                        if(z != 0 && z != 1) {

                            if(tileItemStack[z] != null) {

                                for(int m = 0; m < tileI.getSizeInventory(); m++) {

                                    if(tileItemStack[z] != null) {

                                        tileItemStack[z] = tileC.moveItemToInventory(tileItemStack[z], m, tileItemStack[z].stackSize);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

/**
 * Moves an item from the epecified direction into the tile
 * @param ForgeDirection
 */
public void moveFromAjacentInventory(ForgeDirection direction) {

    if(direction == this.getOrientation()) {

        TileEntity tile = TechCraftTile.translateDirectionToTile(this, worldObj, direction);

        if(tile != null) {

            if(tile instanceof IInventory && !(tile instanceof ISidedInventory) && !(tile instanceof IConduitInterfaceItem)) {

                IInventory tileI = (IInventory)tile;

                for(int i = 0; i < tileI.getSizeInventory(); i++) {

                    if(tileI.getStackInSlot(i) != null) {

                        for(int z = 0; z < tileItemStack.length; z++) {

                            if(tileI.getStackInSlot(i) != null) {

                                tileI.setInventorySlotContents(i, this.moveItemToInventory(tileI.getStackInSlot(i), z, tileI.getStackInSlot(i).stackSize));
                            }
                        }
                    }
                }
            }
        }

        if(tile instanceof ISidedInventory && !(tile instanceof IConduitInterfaceItem)) {

            ISidedInventory tileS = (ISidedInventory)tile;

            for(int i = 0; i < tileS.getAccessibleSlotsFromSide(TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(direction))).length; i++) {

                int side = TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(direction));
                int slot = tileS.getAccessibleSlotsFromSide(TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(direction)))[i];

                if(tileS.getStackInSlot(slot) != null) {

                    for(int z = 0; z < tileItemStack.length; z++) {

                        if(tileS.getStackInSlot(slot) != null) {

                            if(tileS.canExtractItem(slot, tileS.getStackInSlot(slot), side)) {

                                tileS.setInventorySlotContents(i, this.moveItemToInventory(tileS.getStackInSlot(slot), z, tileS.getStackInSlot(slot).stackSize));
                            }

                        }
                    }
                }
            }
        }

        if(tile instanceof IConduitInterfaceItem && tile instanceof IInventory) {

            IInventory tileI = (IInventory)tile;
            IConduitInterfaceItem tileS = (IConduitInterfaceItem)tile;

            for(int i = 0; i < tileI.getSizeInventory(); i++) {

                if(tileI.getStackInSlot(i) != null) {

                    for(int z = 0; z < tileItemStack.length; z++) {

                        if(tileI.getStackInSlot(i) != null) {

                            tileItemStack[z] = this.moveItemToInventory(tileI.getStackInSlot(i), z, tileI.getStackInSlot(i).stackSize);
                            tileI.setInventorySlotContents(i, tileS.takeItemFromInventory(tileI.getStackInSlot(i), i, tileI.getStackInSlot(i).stackSize));
                        }
                    }
                }
            }
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
public EnumInterfaceType getInterfaceType() {

    return EnumInterfaceType.ITEM;
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

    if(TechCraftTile.translateDirectionToTile(this, worldObj, this.getOrientation()) instanceof IConduitConductor) {

        return true;
    }
    return false;
}

@Override
public ItemStack moveItemToInventory(ItemStack itemStack, int slot, int amount) {

    if(slot != 0 && slot != 1) {

        if(tileItemStack[slot] == null) {

            tileItemStack[slot] = itemStack;

            return null;
        }

        else if(tileItemStack[slot].equals(itemStack)) {

            if(tileItemStack[slot].stackSize + itemStack.stackSize <= this.getInventoryStackLimit() && tileItemStack[slot].stackSize + itemStack.stackSize <= tileItemStack[slot].getItem().getItemStackLimit()) {

                tileItemStack[slot].stackSize = tileItemStack[slot].stackSize + itemStack.stackSize;

                itemStack = null;

                return null;
            }
        }
    }
    return itemStack;
}

@Override
public ItemStack takeItemFromInventory(ItemStack itemStack, int slot, int amount) {

    if(slot != 0 && slot != 1) {

        if(tileItemStack[slot] == null) {

            return itemStack    ;
        }

        else if(tileItemStack[slot].stackSize >= amount) {

            if(tileItemStack[slot].stackSize - amount >= 0) {

                tileItemStack[slot].stackSize = tileItemStack[slot].stackSize - amount;

                return tileItemStack[slot]; 
            }

            return itemStack;
        }
    }
    return itemStack;
}

@Override
public IInventory getAccessibleInventoryByDirection(ForgeDirection direction) {

    if(direction == this.getOrientation()) {

        if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IInventory) {

            return (IInventory) TechCraftTile.translateDirectionToTile(this, worldObj, direction);
        }
    }
    return null;
}
}
