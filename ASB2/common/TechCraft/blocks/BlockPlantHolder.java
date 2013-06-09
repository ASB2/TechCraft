package TechCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlantHolder extends TechCraftContainers {

    public BlockPlantHolder(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TilePlantHolder();
    }

}
