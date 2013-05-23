package TechCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockZycrantianOre extends TechCraftBlocks {

    public BlockZycrantianOre(int par1, Material par3Material) {
        super(par1, par3Material);
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockZycrantianOre");
    }

}