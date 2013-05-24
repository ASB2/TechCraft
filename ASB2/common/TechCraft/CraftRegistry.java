package TechCraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftRegistry {

    public static void init() {

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockGarnetBlock),
                new Object[] { "DDD", "DDD", "DDD", 'D',
            ItemRegistry.ItemGarnet });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.seeds),new ItemStack(Item.wheat));

        GameRegistry.addSmelting(BlockRegistry.BlockZycrantianOre.blockID,
                new ItemStack(ItemRegistry.ItemZycrantianIngot), 5.0F);
        
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockBasicRune),
                new Object[] { "FRF", "DED", "FRF", 'F', BlockRegistry.BlockFalseBlock, 'R', Item.redstone ,'E', ItemRegistry.ItemEnergyCrystalShard , 'D', Item.diamond});

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCChargeBench),
                new Object[] { "EGE", "MEM", "GOG", 'G', Block.glass, 'E', ItemRegistry.ItemEnergyCrystalShard, 'M', BlockRegistry.BlockMagiciansBuildingBlocks, 'O', ItemRegistry.ItemEnergyBlob});
      
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockMagiciansBuildingBlocks ,4),
                new Object[] { "CSC", "SES", "CSC", 'C', ItemRegistry.ItemEnergyCrystalShard, 'S', Block.stoneBrick, 'E', ItemRegistry.ItemEnergyBlob});
        
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCFurnace),
                new Object[] { "GGG", "FMF", "BEB", 'G', Block.glass, 'F', ItemRegistry.ItemFireCrystalShard, 'E', ItemRegistry.ItemEnergyBlob, 'M', BlockRegistry.BlockMagiciansBuildingBlocks, 'B', Block.brick});
        
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockGenorator),
                new Object[] { "FFF", "CMZ", "FEF", 'F', ItemRegistry.ItemFireCrystalShard, 'C', Item.coal, 'E', ItemRegistry.ItemEnergyBlob, 'M', BlockRegistry.BlockMagiciansBuildingBlocks, 'Z', ItemRegistry.ItemEnergyCrystalShard});
        
        //GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockGenorator),
        //        new Object[] { "FFF", "CMF", "FEF", 'F', ItemRegistry.ItemFireCrystalShard, 'C', Item.coal, 'E', ItemRegistry.ItemEnergyBlob, 'M', BlockRegistry.BlockMagiciansBuildingBlocks});
        
        
        //Tools
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetSword),
                new Object[] { " D ", " D ", " S ", 'D',
            ItemRegistry.ItemGarnet, 'S', Item.stick });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianShovel),
                new Object[] { " D ", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe),
                new Object[] { " DD", " ED", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe),
                new Object[] { "DD ", "DE ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe),
                new Object[] { "DD ", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe),
                new Object[] { " DD", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianPickaxe),
                new Object[] { "DDD", " E ", " S ", 'D',ItemRegistry.ItemZycrantianIngot, 'S', Item.stick, 'E',ItemRegistry.ItemEnergyCrystalShard});

        //Armor
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe),
                new Object[] { " DD", " ED", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe),
                new Object[] { "DD ", "DE ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe),
                new Object[] { "DD ", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe),
                new Object[] { " DD", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHelmet),
                new Object[] { "DDD", "DED", "  ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianChestPlate),
                new Object[] { "D D", "DED", "DDD", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianPants),
                new Object[] { "DDD", "DED", "D D", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianSword),
                new Object[] { "EDE", "EDE", "ESE", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });
        
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianShovel),
                new Object[] { " D ", " E ", " S ", 'D', ItemRegistry.ItemZycrantianIngot, 'S', Item.stick,'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addSmelting(Item.axeWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalAxe), 1.F);
        
        GameRegistry.addSmelting(Item.pickaxeWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalPickaxe), 1.F);
        
        GameRegistry.addSmelting(Item.shovelWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalShovel), 1.F);
        
        GameRegistry.addSmelting(Item.swordWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalSword), 1.F);
        
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockMagicConduitMoving),
                new Object[] { "GEG", "CRC", "GEG", 'G', Block.glass, 'R', Item.redstone,'C', Block.cobblestone,'E', ItemRegistry.ItemEnergyCrystalShard});

        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.BlockMagicConduitImporting),new ItemStack(BlockRegistry.BlockMagicConduitMoving));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.BlockMagicConduitExporting),new ItemStack(BlockRegistry.BlockMagicConduitImporting));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.BlockMagicConduitMoving),new ItemStack(BlockRegistry.BlockMagicConduitExporting));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ItemTeleporter),new ItemStack(ItemRegistry.ItemTeleporter));
    }

}
