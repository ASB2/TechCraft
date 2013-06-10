package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitInterface;
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

                player.sendChatToPlayer(mTile.getName()+" has "+mTile.getPowerStored()+" out of "+mTile.getPowerMax() + " TCU Stored");

            }

            if(world.getBlockTileEntity(x,y,z) instanceof TechCraftTile){

                TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);

                player.sendChatToPlayer(mTile.getName()+ " is at orientation: " + mTile.translateDirectionToString());
                player.sendChatToPlayer(mTile.getName()+ " has metadata: "+world.getBlockMetadata(x, y, z));
                player.sendChatToPlayer(mTile.getName()+ " output power: "+mTile.outputPower());
                player.sendChatToPlayer(mTile.getName()+ " recieve power: "+mTile.recievePower());
            }    
            else {
                player.sendChatToPlayer("Block has metadata " + world.getBlockMetadata(x, y, z));
            }


            if(world.getBlockTileEntity(x,y,z) instanceof IConduitInterface){

                IConduitInterface mTile = (IConduitInterface) world.getBlockTileEntity(x, y, z);

                if(mTile.getNetwork() != null) {

                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getConductorSize() + " conductors");
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getItemInterfaceSize() + " item interfaces");
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getTcuInterfaceSize() + " tcu interfaces");
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getLiquidInterfaceSize() + " liquid interfaces");
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getBcInterfaceSize() + " buildcraft interfaces");
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getIc2InterfaceSize() + " ic2 interfaces");
                    
                    player.sendChatToPlayer("Conduit Network has " + mTile.getNetwork().getAge() + " ticks old");
                }
                else {
                    
                    player.sendChatToPlayer("Object has no network");
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
        player.sendChatToPlayer("--------");
        return true;        
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
