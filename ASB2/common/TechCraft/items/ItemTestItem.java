package TechCraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.IBlockCycle;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilPlayers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTestItem extends TechCraftItems implements IBlockCycle {

    public ItemTestItem(int par1) {
        super(par1);

    }

    int mode = 1;

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    int length = 5;

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityplayer)
    {
        if(!entityplayer.isSneaking()){
            double[] coords = UtilPlayers.getPlayerCursorCoords(world, entityplayer);
            entityplayer.setPosition(coords[0], coords[1] + 1, coords[2]);
        }


        return itemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        int power = 10;
        boolean addPower = false;

        //UtilBlock.cycle3DBlock(player, world, x, y, z, UtilDirection.translateNumberToDirection(side), 20, 100, this);

        if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

            IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

            if(addPower) {

                if(!player.isSneaking()) {

                    mTile.getPowerProvider().gainPower(power, UtilDirection.translateNumberToDirection(side));
                    player.sendChatToPlayer("Applied "+power+" Power");

                }
                else {   
                    mTile.getPowerProvider().usePower(power, UtilDirection.translateNumberToDirection(side));
                    player.sendChatToPlayer("Drew "+power+" Power");
                }
            }
        }
        return true;        
    }

    @Override
    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side) {

        if(world.blockExists(x, y, z)) 
            world.setBlockToAir(x, y, z); return true;

    }
}
