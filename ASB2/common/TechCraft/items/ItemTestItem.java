package TechCraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.utils.IBlockCycle;
import TechCraft.utils.UtilBlock;
import TechCraft.utils.UtilDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import TechCraft.blocks.*;

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

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!player.isSneaking()) {

            player.capabilities.setFlySpeed(1);
            player.capabilities.setPlayerWalkSpeed(1);
        }
        else {

            player.capabilities.setFlySpeed(0.05F);
            player.capabilities.setPlayerWalkSpeed(0.1F);
        }


        return itemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if(tile != null) {
            if(tile instanceof TechCraftTile) {
                
                ((TechCraftTile)tile).toggleDirection();
                return true;
            }
        }
        UtilBlock.cycle3DBlock(player, world, x, y, z, UtilDirection.translateNumberToDirection(side), 1, 100, this);
        return true;        
    }

    @Override
    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side) {

        if(world.blockExists(x, y, z))
            world.setBlockToAir(x, y, z); return true;
    }
}
