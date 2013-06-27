package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import TechCraft.blocks.TechCraftBlocks;
import TechCraft.*;

public class BlockCrystallineTreeLeaves extends TechCraftBlocks {

    public BlockCrystallineTreeLeaves(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public int idDropped(int par1, Random rand, int par3) {
        
        int randNumb = rand.nextInt(50) + 1;

        if(randNumb == 25) {

            return BlockRegistry.BlockCrystallineTreeSapling.blockID;
        }    
        return ItemRegistry.ItemCrystillineShard.itemID;
    }
}
