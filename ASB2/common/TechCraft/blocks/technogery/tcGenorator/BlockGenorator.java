package TechCraft.blocks.technogery.tcGenorator;

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
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGenorator extends TechCraftContainers{

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

    public BlockGenorator(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        player.openGui(TechCraft.instance, 1, world, x, y, z);

        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        frontLit = par1IconRegister.registerIcon("TechCraft:BlockGenoratorON"); 
        frontUnlit = par1IconRegister.registerIcon("TechCraft:BlockGenoratorOFF"); 
        top = par1IconRegister.registerIcon("TechCraft:BlockGenoratorTop");     
        side = par1IconRegister.registerIcon("TechCraft:BlockGenoratorSide");
        bottom = par1IconRegister.registerIcon("TechCraft:BlockMagiciansBuildingBlock");
    }


    @Override
    public Icon getIcon(int side, int metadata) {

        int facing = (metadata & MASK_DIR);

        return (side == getSideFromFacing(facing) ? (isBurning ? frontLit : frontUnlit) : top);
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
        int metadata = 0;
        int facing = META_DIR_WEST;

        int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4f / 360f) + 0.5) & 3;
        if(dir == 0)
            facing = META_DIR_NORTH;
        if(dir == 1)
            facing = META_DIR_EAST;
        if(dir == 2)
            facing = META_DIR_SOUTH;
        if(dir == 3)
            facing = META_DIR_WEST;

        metadata |= facing;
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        this.dropItems(par1World, par6, par6, par6);
    }

    private void dropItems(World world, int x, int y, int z)
    {
        Random prng = new Random();

        TileGenorator tileEntity = (TileGenorator)world.getBlockTileEntity(x, y, z);
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
    public void randomDisplayTick(World world, int x, int y, int z, Random prng)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if(isBurning){


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
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new TileGenorator();
    }
}
