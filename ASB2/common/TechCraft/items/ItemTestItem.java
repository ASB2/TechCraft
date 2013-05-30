package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.power.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTestItem extends TechCraftItems {

    public ItemTestItem(int par1) {
        super(par1);
        
    }
    int mode = 0;

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    public boolean onItemUseFirst(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        int power = 10;
        if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

            IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

            if(!player.isSneaking()){

                mTile.gainPower(power);
                player.sendChatToPlayer("Applied "+power+" Power");

            }
            else{
                mTile.usePower(power);
                player.sendChatToPlayer("Drew "+power+" Power");
            }


        }

        return true;        
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTestItem");

    }

    public void addPower(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
        
        int power = 10;
        
        if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc) {
            

            IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

            if(!player.isSneaking()) {

                mTile.gainPower(power);
                player.sendChatToPlayer("Applied "+power+" Power");

            }
            else {
                mTile.usePower(power);
                player.sendChatToPlayer("Drew "+power+" Power");
            }
        }
    }

}
