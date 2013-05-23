package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockAirCrystalOre extends TechCraftBlocks {

    public BlockAirCrystalOre(int par1, Material par3Material) {
        super(par1, par3Material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockAirCrystalOre");
    }

    public int idDropped(int par1, Random par2Random, int par3){

        return ItemRegistry.ItemAirCrystalShard.itemID;
    }

    public int quantityDropped(Random par1Random){

        return par1Random.nextInt(5) + 1;
    }
}
