package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockWaterCrystalOre extends TechCraftBlocks {


	public BlockWaterCrystalOre(int par1, Material par3Material) {
		super(par1, par3Material);
	}
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
             this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockWaterCrystalOre");
    }

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemRegistry.ItemWaterCrystalShard.itemID;
    }
	public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(5) + 1;
    }
}
