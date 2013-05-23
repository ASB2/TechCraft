package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockGarnetOre extends TechCraftBlocks {

	public BlockGarnetOre(int par1, Material par3Material) {
		super(par1, par3Material);
	}
	@Override
    public void registerIcons(IconRegister par1IconRegister) {
             this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockGarnetOre");
    }


	public int idDropped(int par1, Random par2Random, int par3) {
	    
        return ItemRegistry.ItemGarnet.itemID;
    }
}
