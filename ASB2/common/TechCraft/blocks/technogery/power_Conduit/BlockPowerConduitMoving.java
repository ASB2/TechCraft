package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockPowerConduitMoving extends TechCraftContainers {

    TilePowerConduitMoving tile;

    public BlockPowerConduitMoving(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {

        if(tile != null) {
            
            if(tile.getNetwork() != null) {
                
                tile.getNetwork().addConductorsAround(tile);
                tile.getNetwork().addSinkAround(tile);
                tile.getNetwork().addSourceAround(tile);
            }
        }
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {

        if(tile != null) {

            tile.getNetwork().removeConductor(((TilePowerConduitMoving)tile));
        }

        super.onBlockDestroyedByPlayer(world, x, y, z, metaData);
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

        tile = new TilePowerConduitMoving();        
        return tile;
    }
}