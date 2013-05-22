package TechCraft.blocks.technogery.tcFurnace;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTCFurnace extends TechCraftContainers{
    
    public static final int META_ISACTIVE = 0x00000008;
    public static final int MASK_DIR = 0x00000007;
    public static final int META_DIR_NORTH = 0x00000001;
    public static final int META_DIR_SOUTH = 0x00000002;
    public static final int META_DIR_EAST = 0x00000003;
    public static final int META_DIR_WEST = 0x00000000;

    private Icon frontLit;
    private Icon frontUnlit;
    private Icon top;
    @SuppressWarnings("unused")
    private Icon side;
    @SuppressWarnings("unused")
    private Icon bottom;

    boolean isBurning = true;
    
    public BlockTCFurnace(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        return ((world.getBlockMetadata(x, y, z) >> 3) == 0 ? 0 : 15); 
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        frontLit = par1IconRegister.registerIcon("TechCraft:BlockTCFurnace"); 
        frontUnlit = par1IconRegister.registerIcon("TechCraft:BlockTCFurnaceON"); 
        top = par1IconRegister.registerIcon("TechCraft:BlockGenoratorTop");     
        side = par1IconRegister.registerIcon("TechCraft:BlockGenoratorSide");
        bottom = par1IconRegister.registerIcon("TechCraft:BlockMagiciansBuildingBlock");
    }


    @Override
    public Icon getIcon(int side, int metadata) {

        int facing = (metadata & MASK_DIR);

        return (side == getSideFromFacing(facing) ? (isBurning ? frontLit : frontUnlit) : top);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random prng)
    {
        TileTCFurnace tileEntity = (TileTCFurnace)world.getBlockTileEntity(x, y, z);
        int metadata = world.getBlockMetadata(x, y, z);

        if(tileEntity.isBurning){


            int facing = metadata & MASK_DIR;

            double yMod = (0.3 * prng.nextDouble());
            double xMod = -0.02;
            double zMod = (0.75 - (0.5 * prng.nextDouble()));
            double temp = 0.0;

            switch(facing)
            {
                case META_DIR_EAST:
                    xMod += 1.04;
                    break;

                case META_DIR_NORTH:
                    temp = xMod;
                    xMod = zMod;
                    zMod = temp;
                    break;

                case META_DIR_SOUTH:
                    temp = xMod;
                    xMod = zMod;
                    zMod = temp + 1.04;
                    break;

                default:
                    break;
            }

            world.spawnParticle("smoke", x + xMod, y + yMod, z + zMod, 0, 0, 0);
            world.spawnParticle("flame", x + xMod, y + yMod, z + zMod, 0, 0, 0);
        }
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;
        
        player.openGui(TechCraft.instance, 2, world, x, y, z);
        return true;
    }
    
    private static int getSideFromFacing(int facing)
    {
        switch(facing)
        {
            case META_DIR_WEST:
                return 4;

            case META_DIR_EAST:
                return 5;

            case META_DIR_NORTH:
                return 2;

            case META_DIR_SOUTH:
                return 3;

            default:
                return 4;
        }
    }
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        super.breakBlock(world, x, y, z, par5, par6);
        
        Random prng = new Random();
        TileTCFurnace tileEntity = (TileTCFurnace)world.getBlockTileEntity(x, y, z);
        
        if(tileEntity == null)
            return;

        for(int slot = 0; slot < tileEntity.getSizeInventory(); slot++)
        {
            ItemStack item = tileEntity.getStackInSlot(slot);

            if(item != null && item.stackSize > 0)
            {
                float rx = prng.nextFloat() * 0.8f + 0.1f;
                float ry = prng.nextFloat() * 0.8f + 0.1f;
                float rz = prng.nextFloat() * 0.8f + 0.1f;

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, item.copy());
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new TileTCFurnace();
    }

}
