package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class TechCraftFlower extends TechCraftBlocks {

    public TechCraftFlower(int par1, Material par2Material) {
        super(par1, par2Material);

        setHardness(0f);
        setResistance(0F);
        this.setTickRandomly(true);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    @ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event) {

        this.managGrowth(event.world, event.X, event.Y, event.Z, new Random());
    }
    
    public void managGrowth(World world, int x, int y, int z, Random random) {

    }

    public void growTree(World world , int x, int y, int z) {

    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
}
