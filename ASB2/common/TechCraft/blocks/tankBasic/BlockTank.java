package TechCraft.blocks.tankBasic;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockTank extends TechCraftContainers{

    protected BlockTank(int par1, Material par2Material) {
        super(par1, par2Material);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new TileTank();
    }

}
