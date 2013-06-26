package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockPowerConduitExporting extends TechCraftContainers{

    TilePowerConduitExporting tile;
    
    public BlockPowerConduitExporting(int par1, Material par2Material) {
        super(par1, par2Material);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        
        tile = new TilePowerConduitExporting();
        return tile;
    }
    
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
    }

    /**
     * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}