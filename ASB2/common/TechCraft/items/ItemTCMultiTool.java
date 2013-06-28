package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.IWrenchable;
import TechCraft.modes.ModeBase;

public class ItemTCMultiTool extends TechCraftItems {

    public ItemTCMultiTool(int par1) {
        super(par1);

    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechMultiTool");

    }

    int mode = 3;

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {   
        if(!par2World.isRemote){
            if(!par3EntityPlayer.isSneaking()){

                ModeBase.getMode(mode).onRightClick(par1ItemStack, par2World, par3EntityPlayer);
            }

            else{

                ModeBase.getMode(mode).onShiftRightClick(par1ItemStack, par2World, par3EntityPlayer);
            }  
        }

        return par1ItemStack;
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

}