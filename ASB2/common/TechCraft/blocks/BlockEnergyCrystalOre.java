package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import TechCraft.ItemRegistry;

public class BlockEnergyCrystalOre extends TechCraftBlocks {


    public BlockEnergyCrystalOre(int par1, int par2, Material par3Material) {
        super(par1, Material.rock);
        this.setTickRandomly(true);
        setHardness(3F);
        setResistance(1.0F);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {

        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockEnergyCrystalOre");
    }

    public int idDropped(int par1, Random par2Random, int par3) {

        return ItemRegistry.ItemEnergyCrystalShard.itemID;
    }

    public int quantityDropped(Random par1Random) {

        return par1Random.nextInt(5) + 1;
    }

}
