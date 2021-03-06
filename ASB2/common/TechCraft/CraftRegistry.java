package TechCraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftRegistry {

    public static void init() {
        //Creates a new itemstack with the enchangment specidied
        //ItemStack enchanted = new ItemStack(Item.pickaxeStone);
        //.addEnchantment(Enchantment.sharpness, 2);

        GameRegistry.addRecipe(new ItemStack(Item.bucketLava), new Object[] {
            "FFF",
            "FSF",
            "FBF",
            'F', ItemRegistry.ItemFireCrystalShard,
            'S', Block.stone,
            'B', Item.bucketEmpty
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockGarnetBlock), new Object[] {
            "DDD",
            "DDD",
            "DDD",
            'D', ItemRegistry.ItemGarnet
        });


        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemLinker,2), new Object[] {
            "AGA",
            "PAP",
            "RZR",
            'A', ItemRegistry.ItemAirCrystalShard,
            'G', ItemRegistry.ItemGarnet,
            'R', Item.redstone,
            'Z', ItemRegistry.ItemZycrantianIngot,
            'P', Item.enderPearl
        });       

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemTechnoMagicReader), new Object[] {
            "RZC",
            "ZSZ",
            "SZR",
            'R', Item.redstone, 
            'S', Item.stick,
            'C', ItemRegistry.ItemEnergyCrystalShard, 
            'Z', ItemRegistry.ItemZycrantianIngot
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemTeleportModule, 2), new Object[] {
            " Z ",
            "ZEZ",
            "DZD",
            'D', Item.diamond, 
            'E', ItemRegistry.ItemEnergyCrystalShard,
            'Z', ItemRegistry.ItemZycrantianIngot
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemTeleporter, 2), new Object[] {
            "TNT",
            "GRG", 
            "DPD",
            'R', Item.redstone,
            'D', Item.diamond,
            'N', ItemRegistry.ItemGarnet,
            'G', Item.ingotGold,
            'P', Item.enderPearl,
            'T', ItemRegistry.ItemTeleportModule
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemBasicDestructionCatalyst), new Object[] {
            "PBS",
            "TET", 
            "DPD",
            'P', ItemRegistry.ItemZycrantianPickaxe,
            'P', ItemRegistry.ItemZycrantianShovel,
            'T', Block.tnt,
            'E', ItemRegistry.ItemEnergyCrystalShard,
            'D', Item.diamond,
            'B', Block.blockDiamond
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockSpeedyRoad, 8), new Object[] {
            "MMM",
            "QZQ",
            "QQQ",
            'M', BlockRegistry.BlockMagiciansBuildingBlocks,
            'Q', Block.blockNetherQuartz,
            'Z', ItemRegistry.ItemZycrantianIngot
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockPersonalBlock, 8, 0), new Object[] {
            "QGQ",
            "GZG",
            "QGQ",
            'G', Block.glass,
            'Q', Block.blockNetherQuartz,
            'Z', ItemRegistry.ItemZycrantianIngot
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockPersonalBlock, 8, 1), new Object[] {
            "QGQ",
            "GZG",
            "QGQ",
            'G', Block.stone,
            'Q', Block.blockNetherQuartz,
            'Z', ItemRegistry.ItemZycrantianIngot
        });

        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ItemTeleporter),new ItemStack(ItemRegistry.ItemTeleporter));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ItemLinker),new ItemStack(ItemRegistry.ItemLinker));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ItemGarnet,9),new ItemStack(BlockRegistry.BlockGarnetBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.seeds),new ItemStack(Item.wheat));
    }

    public static void placeHolderRecipes() {
        
    }

    public static void craftPower() {

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemEnergyBlob), new Object[] {
            "ERE",
            "RGR", 
            "EZE",
            'E', ItemRegistry.ItemEnergyCrystalShard,
            'R', Item.redstone,
            'Z', ItemRegistry.ItemZycrantianIngot,
            'G', Item.ingotGold
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemRealityDifferentiationDrive, 4), new Object[] { 
            "BZB",
            "PDP",
            "BZB",
            'B', ItemRegistry.ItemEnergyBlob,
            'Z', ItemRegistry.ItemZycrantianIngot,
            'D', Item.diamond,
            'P', Item.enderPearl
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockMagiciansBuildingBlocks ,4), new Object[] {
            "CSC", 
            "SES",
            "CSC", 
            'C', ItemRegistry.ItemEnergyCrystalShard,
            'S', Block.stoneBrick,
            'E', ItemRegistry.ItemEnergyBlob
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCEnergySphere), new Object[] {
            "BRB",
            "ZMZ",
            "BRB",
            'B', ItemRegistry.ItemEnergyBlob,
            'R', ItemRegistry.ItemRealityDifferentiationDrive, 
            'Z', ItemRegistry.ItemZycrantianIngot,
            'M', BlockRegistry.BlockMagiciansBuildingBlocks
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCFurnace), new Object[] { 
            "ZZZ",
            "ZMZ",
            "FSF",
            'Z', ItemRegistry.ItemZycrantianIngot, 
            'F', ItemRegistry.ItemFireCrystalShard, 
            'M', Block.furnaceIdle  ,
            'S', BlockRegistry.BlockTCEnergySphere
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCChargeBench), new Object[] {
            "AAA",
            "ESE",
            "MRM",
            'A', ItemRegistry.ItemAirCrystalShard,
            'E', ItemRegistry.ItemEnergyCrystalShard,
            'R', Item.redstone,
            'M', BlockRegistry.BlockMagiciansBuildingBlocks,
            'S', BlockRegistry.BlockTCEnergySphere
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockGenorator), new Object[] { 
            "FFF",
            "CMZ",
            "FEF", 
            'F', ItemRegistry.ItemFireCrystalShard,
            'C', Item.coal,
            'E', ItemRegistry.ItemEnergyBlob, 
            'M', BlockRegistry.BlockMagiciansBuildingBlocks,
            'Z', ItemRegistry.ItemEnergyCrystalShard
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemTechMultiTool), new Object[] { 
            "ZEZ",
            "ERE",
            "BZB", 
            'Z', ItemRegistry.ItemZycrantianIngot,
            'E', ItemRegistry.ItemEnergyCrystalShard, 
            'R', ItemRegistry.ItemRealityDifferentiationDrive, 
            'B', ItemRegistry.ItemEnergyBlob
        });

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCTeleporter), new Object[] {
            "PIP",
            "BDB",
            "ISI",
            'I', Item.ingotIron, 
            'D', Item.diamond,
            'P', ItemRegistry.ItemTeleportModule,
            'S', BlockRegistry.BlockTCEnergySphere,
            'M', BlockRegistry.BlockMagiciansBuildingBlocks
        });
        
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockTCInfuser), new Object[] {
            "EIE",
            "GCG",
            "ISI",
            
            'E', ItemRegistry.ItemEnergyCrystalShard,
            'I', Item.ingotIron, 
            'C', Block.workbench,
            'G', Block.glass,
            'S', BlockRegistry.BlockTCEnergySphere
        });
    }

    public static void craftTool_Armor() {

        //Tools
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetSword), new Object[] {
            " D ",
            " D ",
            " S ",
            'D', ItemRegistry.ItemGarnet, 
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetShovel), new Object[] { 
            " D ",
            " S ",
            " S ",
            'D', ItemRegistry.ItemGarnet,
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetAxe), new Object[] {
            " DD",
            " SD", 
            " S ", 
            'D', ItemRegistry.ItemGarnet, 
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetAxe), new Object[] { 
            "DD ",
            "DS ",
            " S ",
            'D', ItemRegistry.ItemGarnet,
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetHoe), new Object[] {
            "DD ",
            " S ",
            " S ",
            'D', ItemRegistry.ItemGarnet,
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetHoe), new Object[] {
            " DD",
            " S ",
            " S ",
            'D', ItemRegistry.ItemGarnet,
            'S', Item.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemGarnetPickaxe), new Object[] {
            "DDD",
            " S ",
            " S ",
            'D',ItemRegistry.ItemGarnet, 
            'S', Item.stick
        });

        //Zycrantian

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianShovel),
                new Object[] {
            " D ",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe), new Object[] { 
            " DD",
            " ED",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe),
                new Object[] {
            "DD ",
            "DE ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe), new Object[] {
            "DD ",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,'E',
            ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe), new Object[] {
            " DD",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianPickaxe), new Object[] {
            "DDD",
            " E ",
            " S ",
            'D',ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E',ItemRegistry.ItemEnergyCrystalShard
        });

        //Armor
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe), new Object[] {
            " DD",
            " ED",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianAxe), new Object[] {
            "DD ",
            "DE ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe), new Object[] {
            "DD ",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHoe),
                new Object[] {
            " DD",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianHelmet), new Object[] {
            "DDD",
            "DED",
            "  ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianChestPlate), new Object[] {
            "D D",
            "DED",
            "DDD",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,'E',
            ItemRegistry.ItemEnergyCrystalShard });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianPants), new Object[] {
            "DDD",
            "DED",
            "D D",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianSword), new Object[] {
            "EDE",
            "EDE",
            "ESE",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard 
        });

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ItemZycrantianShovel), new Object[] {
            " D ",
            " E ",
            " S ",
            'D', ItemRegistry.ItemZycrantianIngot,
            'S', Item.stick,
            'E', ItemRegistry.ItemEnergyCrystalShard
        });
    }

    public static void craftSmelting() {

        GameRegistry.addSmelting(BlockRegistry.BlockZycrantianOre.blockID,
                new ItemStack(ItemRegistry.ItemZycrantianIngot), 5.0F);

        GameRegistry.addSmelting(Item.axeWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalAxe), 1.F);

        GameRegistry.addSmelting(Item.pickaxeWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalPickaxe), 1.F);

        GameRegistry.addSmelting(Item.shovelWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalShovel), 1.F);

        GameRegistry.addSmelting(Item.swordWood.itemID, new ItemStack(
                ItemRegistry.ItemCharcoalSword), 1.F);
    }

    public static void teiredCrafting() {

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.BlockItemExtractor), new Object[] {
            "GIG",
            "IMI",
            "ARA",
            'G', Block.glass,
            'I', Item.ingotIron,
            'M', BlockRegistry.BlockMagiciansBuildingBlocks,
            'A', ItemRegistry.ItemAirCrystalShard,
            'R', Item.redstone
        });
    }

}
