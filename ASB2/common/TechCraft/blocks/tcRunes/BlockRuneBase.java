package TechCraft.blocks.tcRunes;

import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public abstract class BlockRuneBase extends TechCraftContainers{

    public BlockRuneBase(int par1, Material par2Material) {
        super(par1, par2Material);
        setTickRandomly(true);
    }


    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }
    
    public boolean canCreatureSpawn() {
        return false;
    }

    public boolean renderAsNormalBlock() {

        return false;
    }

    public boolean isOpaqueCube() {

        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
    }
}
