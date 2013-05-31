package TechCraft.blocks.technogery;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;
public class BlockTestBlock extends TechCraftContainers{

    public BlockTestBlock(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(!world.isRemote){
            
            
        }
        return false;
    }   

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:BlockTestBlock");
    }
    
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileTestBlock();
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
