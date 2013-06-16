package TechCraft.blocks.tcPersonalBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockPersonalGlass extends BlockPersonalBlock {

    public BlockPersonalGlass(int par1, Material par2Material) {
        super(par1, par2Material);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister) {
        
        blockIcon = iconRegister.registerIcon("TechCraft:BlockPersonalGlass");
    }
    
    @Override
    public boolean isOpaqueCube() {
        
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        
        return false;
    }

}
