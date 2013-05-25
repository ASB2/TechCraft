package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;

public class ItemTechnoMagicReader extends TechCraftItems{

    public ItemTechnoMagicReader(int par1) {
        super(par1);
        setMaxStackSize(1);

    }

    public boolean onItemUseFirst(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){

        if(!player.isSneaking()) {
            if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

                IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

                player.sendChatToPlayer(mTile.getName()+" has "+mTile.getPowerStored()+" out of "+mTile.getPowerMax() + " Technogry Stored");

            }

            if(world.getBlockTileEntity(x,y,z) instanceof TechCraftTile){

                TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);

                player.sendChatToPlayer(mTile.getName()+ " is at orientation: " + mTile.translateDirectionToString());
                player.sendChatToPlayer(mTile.getName()+ " has metadata "+world.getBlockMetadata(x, y, z));
            }        
        }
        
        else {
            
            if(world.getBlockTileEntity(x,y,z) instanceof TechCraftTile) {
                TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);
                mTile.toggleDirection();
                player.sendChatToPlayer(mTile.getName()+ " is now at orientation: " + mTile.translateDirectionToString());
            }
        }
        return true;        
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
