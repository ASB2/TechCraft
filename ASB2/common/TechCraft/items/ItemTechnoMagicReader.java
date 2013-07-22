package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitNetwork;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.UtilDirection;

public class ItemTechnoMagicReader extends TechCraftItems{

    public ItemTechnoMagicReader(int par1) {
        super(par1);
        setMaxStackSize(1);

    }

    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10){

        TileEntity tile = world.getBlockTileEntity(x,y,z);

        if(tile != null) {

            if(tile instanceof IPowerMisc) {

                IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

                if(mTile.getPowerProvider() != null) {

                    if(player.isSneaking())
                        mTile.getPowerProvider().gainPower(10, UtilDirection.translateNumberToDirection(side));

                    player.sendChatToPlayer(mTile.getName()+" has "+mTile.getPowerProvider().getPowerStored()+" out of "+mTile.getPowerProvider().getPowerMax() + " TCU Stored");
                    player.sendChatToPlayer(mTile.getName()+ " State: " + mTile.getPowerProvider().getCurrentState()); 
                    player.sendChatToPlayer(mTile.getName()+ " is at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
                }
            }

            if(tile instanceof TechCraftTile) {

                TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);

                if(player.isSneaking()) {
                    mTile.toggleDirection();
                    player.sendChatToPlayer(mTile.getName()+ " is now at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
                }    
            }

            if(tile instanceof IConduitNetwork) {

                IConduitNetwork mTile = (IConduitNetwork)tile;

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
            
            if(tile instanceof IInventory) {
                
                IInventory mTile = (IInventory)tile;
                
                player.sendChatToPlayer("Inventory name is: " + mTile.getInvName());
                player.sendChatToPlayer("Size of inventory is: " + mTile.getSizeInventory());
                player.sendChatToPlayer("Inventory stack limit is: " + mTile.getInventoryStackLimit());
            }
        }
        player.sendChatToPlayer("Block" + " has metadata: " + world.getBlockMetadata(x, y, z));
        player.sendChatToPlayer("--------");
        return true;        

    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
