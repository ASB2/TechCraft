package TechCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.TechCraft;

public class TechCraftBlocks extends Block{

    public TechCraftBlocks(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setCreativeTab(TechCraft.tabTechno);
        setHardness(3.5f);
        setResistance(1.0F);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:GearBlock");
    }

}
