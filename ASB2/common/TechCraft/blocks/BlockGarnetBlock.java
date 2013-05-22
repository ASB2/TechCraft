package TechCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockGarnetBlock extends TechCraftBlocks {

    public BlockGarnetBlock(int par1, Material par2Material){
        super(par1, par2Material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockGarnetBlock");
    }
}
