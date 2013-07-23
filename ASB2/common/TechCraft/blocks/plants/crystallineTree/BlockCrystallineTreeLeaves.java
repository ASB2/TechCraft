package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import TechCraft.blocks.TechCraftBlocks;
import TechCraft.*;

public class BlockCrystallineTreeLeaves extends TechCraftBlocks {

    public BlockCrystallineTreeLeaves(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setHardness(1F);
    }

    public int idDropped(int par1, Random rand, int par3) {
        
        int randNumb = rand.nextInt(100) + 1;

        if(randNumb > 25 && randNumb < 50 ) {

            return ItemRegistry.ItemCrystillineShard.itemID;
        } 
        if(randNumb == 50) {

            return BlockRegistry.BlockCrystallineTreeSapling.blockID;
        } 
        return 0;
    }
}
