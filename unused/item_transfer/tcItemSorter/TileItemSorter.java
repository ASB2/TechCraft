package TechCraft.blocks.item_transfer.tcItemSorter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import TechCraft.blocks.TechCraftTile;
import TechCraft.items.ItemLinker;

public class TileItemSorter extends TechCraftTile implements IInventory{

    private ItemStack[] tileItemStack;

    boolean linkerSet = false;

    int x;
    int y;
    int z;
    int dimentionID = 0;

    public TileItemSorter() {

        tileItemStack = new ItemStack[10];
    }

    public void updateEntity() {

        if(!linkerSet) {

            if(tileItemStack[0] != null) {

                if(tileItemStack[0].getItem() instanceof ItemLinker) {

                    if(((ItemLinker)tileItemStack[0].getItem()).isCoodsSet(tileItemStack[0])) {

                        x = (int) ((ItemLinker)tileItemStack[0].getItem()).getXCoord(tileItemStack[0]);
                        y = (int) ((ItemLinker)tileItemStack[0].getItem()).getYCoord(tileItemStack[0]);
                        z = (int) ((ItemLinker)tileItemStack[0].getItem()).getZCoord(tileItemStack[0]);
                        dimentionID = ((ItemLinker)tileItemStack[0].getItem()).getDimentionIDCoord(tileItemStack[0]);
                        linkerSet = true;
                    }
                }
            }
        }

        if(linkerSet) {

            if(tileItemStack[0] == null) {

                linkerSet = false;
            }
        }

        if(linkerSet && worldObj.getBlockTileEntity(x, y, z) != null) {

            if(!(worldObj.getBlockPowerInput(x, y, z) > 0)) {

                if(worldObj.blockExists(x, y, z)) {
                    
                    //moveSlotToInventory();                    
                }
            }
        }
    }

    /*public void moveSlotToInventory() {

        //FMLServerHandler.instance().getServer().getConfigurationManager();
        
        TileEntity tile = worldObj.getBlockTileEntity(x, y, z);

        if(tile instanceof TileItemReciever) {

            TileItemReciever tileI = (TileItemReciever)tile;

            if(tileI.getInventoryStackLimit() > 0 && tileI.getSizeInventory() > 0) {

                for(int i = 0; i < tileItemStack.length; i++) {

                    if(tileItemStack[i] != null) {

                        if(i != 0) {

                            for(int z = 0; z < tileI.getSizeInventory(); z++) {

                                if(z != 0) {
                                    if(tileI.getStackInSlot(z) != null) {

                                        if(tileI.isStackValidForSlot(z, tileItemStack[i])) {

                                            if(tileI.getStackInSlot(z).stackSize <= tileI.getInventoryStackLimit() && tileI.getStackInSlot(z).stackSize <= tileI.getStackInSlot(z).getItem().getItemStackLimit()) {

                                                int size = tileI.getStackInSlot(z).stackSize;

                                                if(size != tileI.getStackInSlot(z).getItem().getItemStackLimit()) {

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

    }*/

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
}
