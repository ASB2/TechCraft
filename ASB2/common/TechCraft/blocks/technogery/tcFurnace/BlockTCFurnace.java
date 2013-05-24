package TechCraft.blocks.technogery.tcFurnace;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;
import TechCraft.blocks.TechCraftTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTCFurnace extends TechCraftContainers {

    private ForgeDirection direction;
    private TileTCFurnace tile;

    private Icon frontLit;
    private Icon frontUnlit;
    private Icon top;
    private Icon blockSide;
    private Icon blockBottom;

    public BlockTCFurnace(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;

        player.openGui(TechCraft.instance, 2, world, x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        frontLit = par1IconRegister.registerIcon("TechCraft:BlockTCFurnaceON"); 
        frontUnlit = par1IconRegister.registerIcon("TechCraft:BlockTCFurnace"); 
        top = par1IconRegister.registerIcon("TechCraft:BlockGenoratorTop");     
        blockSide = par1IconRegister.registerIcon("TechCraft:BlockGenoratorSide");
        blockBottom = par1IconRegister.registerIcon("TechCraft:BlockMagiciansBuildingBlocks");
    }


    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
        super.onBlockPlacedBy(world, x, y, z,entity, itemStack);

        if(tile != null && tile instanceof TechCraftTile) {

            tile.setOrientation(tile.getBlockMetadata());            
            direction = tile.getOrientation();
        }
    }

    @Override
    public Icon getIcon(int side, int metadata) {

        if(metadata == side){
            if(tile != null && tile.isBurning){
                return frontLit;
            }
            else{
                return frontUnlit;
            }
        }

        else{
            switch(side){
                case 0: return blockBottom;
                case 1: return top;
                case 2:return blockSide;
                case 3:return blockSide;
                case 4:return blockSide;
                case 5:return blockSide;
            }

        }
        return blockBottom;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random prng)
    {
        if(tile != null && tile.isBurning) {

            double yMod = (0.3 * prng.nextDouble());
            double xMod = -0.02;
            double zMod = (0.75 - (0.5 * prng.nextDouble()));
            double temp = 0.0;
            
            if(direction != null) {
                switch(direction)
                {
                    case EAST: {
                        xMod += 1.04;
                        break;
                    }

                    case NORTH: {
                        temp = xMod;
                        xMod = zMod;
                        zMod = temp;
                        break;
                    }

                    case SOUTH: {
                        temp = xMod;
                        xMod = zMod;
                        zMod = temp + 1.04;
                        break;
                    }

                    default:
                        break;
                }
            }
            world.spawnParticle("smoke", x + xMod, y + yMod, z + zMod, 0, 0, 0);
            world.spawnParticle("flame", x + xMod, y + yMod, z + zMod, 0, 0, 0);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        tile = new TileTCFurnace();
        return tile;
    }

}
