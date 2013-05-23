package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockEarthCrystalOre extends TechCraftBlocks {

    public BlockEarthCrystalOre(int id, Material material) {
        super(id, material);

    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {

        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockEarthCrystalOre");
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemRegistry.ItemEarthCrystalShard.itemID;
    }

    public int quantityDropped(Random par1Random) {

        return par1Random.nextInt(5) + 1;
    }


}
