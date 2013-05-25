package TechCraft.blocks.tcRunes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.runes.IRuneItem;
import TechCraft.runes.*;

public class TileBasicRune extends TechCraftTile implements IInventory{

    private ItemStack[] tileItemStack;
    RuneBase runeInSlot;
    private boolean runeSet = false;

    public TileBasicRune() {
        super();
        tileItemStack = new ItemStack[1];
    }

    public void updateEntity() {

        if(runeSet) {

            if(tileItemStack[0] == null) {
                
                runeInSlot = null;
                runeSet = false; 
            }
        }

        if(!runeSet) {

            if(tileItemStack[0] != null) {

                if(tileItemStack[0].getItem() instanceof IRuneItem) {

                    IRuneItem runeCore = (IRuneItem) tileItemStack[0].getItem();
                    runeInSlot = runeCore.getRune();
                    runeSet = true;
                }
            }
        }


    }

    public void onEntityEnterBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {
        if(runeSet && runeInSlot != null) {

            runeInSlot.onEntityEnterBlock(par1World, par2, par3, par4, par5Entity);
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

        return "Tile Basic Rune";
    }

    @Override
    public boolean isInvNameLocalized() {

        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
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
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {

        return true;
    }
}
