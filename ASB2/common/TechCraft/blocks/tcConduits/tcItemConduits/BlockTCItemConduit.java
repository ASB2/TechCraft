package TechCraft.blocks.tcConduits.tcItemConduits;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockTCItemConduit extends TechCraftContainers {

    public BlockTCItemConduit(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileTCItemConduit();
    }
}