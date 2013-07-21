package TechCraft.blocks.technogery.tcEnergySender;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftContainers;

public class BlockEnergySender extends TechCraftContainers {

    public BlockEnergySender(int par1, Material par2Material) {
        super(par1, par2Material);
        setLightValue(.5F);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileEnergySender();
    }
    
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
        
        TileEntity tile = world.getBlockTileEntity(x,y,z);
        
        if(tile != null) {
            
            if(tile instanceof TileEnergySender) {
                
                if(((TileEnergySender)tile).getOrientation() == side) {
                    
                    return true;
                }
            }
        }
        return false;
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
