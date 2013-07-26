package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitNetwork;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.UtilDirection;

public class ItemTechnoMagicReader extends TechCraftItems {

    public ItemTechnoMagicReader(int par1) {
        super(par1);
        setMaxStackSize(1);
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10){

        TileEntity tile = world.getBlockTileEntity(x,y,z);

        if(tile != null) {

            if(tile instanceof IPowerMisc) {

                IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

                if(mTile.getPowerProvider() != null) {

                    if(player.isSneaking())
                        mTile.getPowerProvider().gainPower(10, UtilDirection.translateNumberToDirection(side));

                    TechCraft.proxy.sendChatToPlayer(player, mTile.getName()+" has "+mTile.getPowerProvider().getPowerStored()+" out of "+mTile.getPowerProvider().getPowerMax() + " TCU Stored");
                    TechCraft.proxy.sendChatToPlayer(player, mTile.getName()+ " State: " + mTile.getPowerProvider().getCurrentState()); 
                    TechCraft.proxy.sendChatToPlayer(player, mTile.getName()+ " is at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
                }
            }

            if(tile instanceof TechCraftTile) {

                TechCraftTile mTile = (TechCraftTile) world.getBlockTileEntity(x, y, z);

                if(player.isSneaking()) {
                    mTile.toggleDirection();
                    TechCraft.proxy.sendChatToPlayer(player, mTile.getName()+ " is now at orientation: " + UtilDirection.translateDirectionToString(mTile.getOrientation()));
                }    
            }

            if(tile instanceof IConduitNetwork) {

                IConduitNetwork mTile = (IConduitNetwork)tile;

                if(mTile.getNetwork() != null) {

                    TechCraft.proxy.sendChatToPlayer(player, "Conduit Network has " + mTile.getNetwork().getConductorSize() + " conductors");
                    TechCraft.proxy.sendChatToPlayer(player, "Conduit Network has " + mTile.getNetwork().getItemInterfaceSize() + " item interfaces");
                    TechCraft.proxy.sendChatToPlayer(player, "Conduit Network has " + mTile.getNetwork().getTcuInterfaceSize() + " tcu interfaces");
                    TechCraft.proxy.sendChatToPlayer(player, "Conduit Network has " + mTile.getNetwork().getLiquidInterfaceSize() + " liquid interfaces");
                }
                else {

                    TechCraft.proxy.sendChatToPlayer(player, "Object has no network");
                }
            }
            
            if(tile instanceof IInventory) {
                
                IInventory mTile = (IInventory)tile;
                
                TechCraft.proxy.sendChatToPlayer(player, "Inventory name is: " + mTile.getInvName());
                TechCraft.proxy.sendChatToPlayer(player, "Size of inventory is: " + mTile.getSizeInventory());
                TechCraft.proxy.sendChatToPlayer(player, "Inventory stack limit is: " + mTile.getInventoryStackLimit());
            }
        }
        TechCraft.proxy.sendChatToPlayer(player, "Block" + " has metadata: " + world.getBlockMetadata(x, y, z));
        TechCraft.proxy.sendChatToPlayer(player, "--------");
        return true;        

    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechnoMagicReader");
    }

}
