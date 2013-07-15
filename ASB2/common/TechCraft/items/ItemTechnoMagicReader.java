package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitNetwork;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.*;

public class ItemTechnoMagicReader extends TechCraftItems{

    public ItemTechnoMagicReader(int par1) {
        super(par1);
        setMaxStackSize(1);

    }

    public boolean onItemUseFirst(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10){

        if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

            IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

            if(player.isSneaking())
                mTile.getPowerProvider().gainPower(10, UtilDirection.translateNumberToDirection(side));
            
            player.sendChatToPlayer(mTile.getName()+" has "+mTile.getPowerProvider().getPowerStored()+" out of "+mTile.getPowerProvider().getPowerMax() + " TCU Stored");
        }

        if(world.getBlockTileEntity(x,y,z) instanceof TechCraftTile){

            TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);

            player.sendChatToPlayer(mTile.getName()+ " is at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
            player.sendChatToPlayer(mTile.getName()+ " has metadata: " + world.getBlockMetadata(x, y, z));
            player.sendChatToPlayer(mTile.getName()+ " State: " + mTile.getPowerProvider().getCurrentState()); 
        }    
        else {
            player.sendChatToPlayer("Block has metadata " + world.getBlockMetadata(x, y, z));
            player.sendChatToPlayer("Block metadata equates to forge direction " + UtilDirection.translateDirectionToString( UtilDirection.translateNumberToDirection(world.getBlockMetadata(x, y, z))));
        }


        if(world.getBlockTileEntity(x,y,z) instanceof IConduitNetwork){

            IConduitNetwork mTile = (IConduitNetwork) world.getBlockTileEntity(x, y, z);

            if(mTile.getNetwork() != null) {

                player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getConductorSize() + " conductors");
                player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getItemInterfaceSize() + " item interfaces");
                player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getTcuInterfaceSize() + " tcu interfaces");
                player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getLiquidInterfaceSize() + " liquid interfaces");
            }
            else {

                player.sendChatToPlayer("Object has no network");
            }
        }    

        if(world.getBlockTileEntity(x,y,z) instanceof TechCraftTile) {

            TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);
            mTile.toggleDirection();
            player.sendChatToPlayer(mTile.getName()+ " is now at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
        }

        player.sendChatToPlayer("--------");
        return true;        

    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
