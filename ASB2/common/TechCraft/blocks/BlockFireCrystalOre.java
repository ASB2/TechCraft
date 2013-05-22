package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockFireCrystalOre extends TechCraftBlocks {

    public BlockFireCrystalOre(int par1, int par2, Material par3Material) {
        super(par1, Material.rock);
    }

    public void registerIcons(IconRegister par1IconRegister) {

        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockFireCrystalOre");
    }


    public int idDropped(int par1, Random par2Random, int par3) {

        return ItemRegistry.ItemFireCrystalShard.itemID;
    }

    public int quantityDropped(Random par1Random) {
        return par1Random.nextInt(5) + 1;
    }
}
