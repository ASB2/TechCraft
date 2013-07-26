package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.IWrenchable;
import TechCraft.modes.ModeBase;
import TechCraft.*;
import TechCraft.utils.*;

public class ItemTCMultiTool extends TechCraftItems implements IItemInventory {

    public ItemTCMultiTool(int par1) {
        super(par1);
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechMultiTool");

    }

    public ItemStack onItemRightClick(ItemStack itemStack, World par2World, EntityPlayer par3EntityPlayer) {

        if(!par3EntityPlayer.isSneaking()){

            ModeBase.getMode(UtilItemStack.getNBTTagInt(itemStack, "mode")).onRightClick(itemStack, par2World, par3EntityPlayer);
        }

        else{

            ModeBase.getMode(UtilItemStack.getNBTTagInt(itemStack, "mode")).onShiftRightClick(itemStack, par2World, par3EntityPlayer);
        }
        return itemStack;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz)
    {

        if(world.getBlockTileEntity(x,y,z) != null) {

            if(world.getBlockTileEntity(x,y,z) instanceof IWrenchable) {

                IWrenchable tile = (IWrenchable)world.getBlockTileEntity(x,y,z);

                if(player.isSneaking()) {

                    tile.breakBlock(world, player, itemStack, x, y, z, side);
                }
                else {
                    tile.triggerBlock(world, player, itemStack, x, y, z, side);
                }
            }
        }
        return true;
    }

    @Override
    public int getSizeInventory(ItemStack itemStack) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(ItemStack itemStack, int slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean decreaseStackSize(ItemStack itemStack, int slot, int amount) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setStackInSlot(ItemStack itemStack, int slot) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getName(ItemStack itemStack) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isStackValidForSlot(ItemStack itemStack, int slot) {
        // TODO Auto-generated method stub
        return false;
    }
}
