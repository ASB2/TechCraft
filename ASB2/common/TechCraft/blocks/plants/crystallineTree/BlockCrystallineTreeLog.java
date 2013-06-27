package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import TechCraft.ItemRegistry;
import TechCraft.blocks.TechCraftBlocks;

public class BlockCrystallineTreeLog extends TechCraftBlocks {

    public BlockCrystallineTreeLog(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public int idDropped(int par1, Random rand, int par3) {

        int randNumb = rand.nextInt(50) + 1;

        if(randNumb == 25) {

            return ItemRegistry.ItemCrystillineShard.itemID;
        }    
        return this.blockID;
    }
}
