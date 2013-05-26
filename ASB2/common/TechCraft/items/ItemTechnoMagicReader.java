package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.*;
import TechCraft.power.*;

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

            if(world.getBlockTileEntity(x,y,z) instanceof IPowerConductor){

                IPowerConductor mTile = (IPowerConductor) world.getBlockTileEntity(x, y, z);
                if(mTile.getNetwork() != null){
                    player.sendChatToPlayer(mTile.getName()+ " network start is at x " + mTile.getNetwork().tileCore.xCoord + " y "+ mTile.getNetwork().tileCore.yCoord+" z "+ mTile.getNetwork().tileCore.zCoord);
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getConductors().size() + " conductors");
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getExporting().size() + " exporting");
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getImporting().size() + " importing");
                    player.sendChatToPlayer(mTile.getName()+ " power network is " + mTile.getNetwork().getAge() + " ticks old");
                    player.sendChatToPlayer("Power Network has " + mTile.getNetwork().getBuffer() +" technogery stored in it's buffer");
                }
                else {
                    player.sendChatToPlayer(mTile.getName()+" has no network");
                }
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
