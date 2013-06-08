package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.blocks.technogery.power_Conduit.*;

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
            
            
            if(world.getBlockTileEntity(x,y,z) instanceof TilePowerConduitMoving){

                TilePowerConduitMoving mTile = (TilePowerConduitMoving) world.getBlockTileEntity(x, y, z);

                if(mTile.getNetwork() != null) {

                    // player.sendChatToPlayer(mTile.getName()+ " network start is at x " + mTile.getNetwork().tileCore.xCoord + " y "+ mTile.getNetwork().tileCore.yCoord+" z "+ mTile.getNetwork().tileCore.zCoord);
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getConductorSize() + " conductors");
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getSinkSize() + " power sinks");
                    player.sendChatToPlayer(mTile.getName()+ " power network has " + mTile.getNetwork().getSourceSize() + " power sources");
                    player.sendChatToPlayer(mTile.getName()+ " power network is " + mTile.getNetwork().getAge() + " ticks old");
                    //player.sendChatToPlayer("Power Network has " + mTile.getNetwork().getBuffer() +" technogery stored in it's buffer");
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
        player.sendChatToPlayer("--------");
        return true;        
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
