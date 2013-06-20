package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import TechCraft.blocks.*;

public class BlockCrystallineTreeSapling extends TechCraftBlocks implements IPlantable {

    public BlockCrystallineTreeSapling(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setTickRandomly(true);
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        
    }
}
