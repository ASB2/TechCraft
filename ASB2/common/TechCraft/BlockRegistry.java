package TechCraft;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import TechCraft.blocks.BlockAirCrystalOre;
import TechCraft.blocks.BlockBurningFlower;
import TechCraft.blocks.BlockEarthCrystalOre;
import TechCraft.blocks.BlockEnergyCrystalOre;
import TechCraft.blocks.BlockFalseBlock;
import TechCraft.blocks.BlockFireCrystalOre;
import TechCraft.blocks.BlockFreezingFlower;
import TechCraft.blocks.BlockGarnetBlock;
import TechCraft.blocks.BlockGarnetOre;
import TechCraft.blocks.BlockSpeedyRoad;
import TechCraft.blocks.BlockWaterCrystalOre;
import TechCraft.blocks.BlockZycrantianOre;
import TechCraft.blocks.TechCraftBlocks;
import TechCraft.blocks.TechCraftContainers;
import TechCraft.blocks.TechCraftFlower;
import TechCraft.blocks.plants.crystallineTree.BlockCrystallineTreeLeaves;
import TechCraft.blocks.plants.crystallineTree.BlockCrystallineTreeLog;
import TechCraft.blocks.plants.crystallineTree.BlockCrystallineTreeSapling;
import TechCraft.blocks.tcConduits.tcItemConduits.BlockTCItemConduit;
import TechCraft.blocks.tcItemExtractor.BlockItemExtractor;
import TechCraft.blocks.tcPersonalBlocks.BlockPersonalBlock;
import TechCraft.blocks.tcPersonalBlocks.PersonalBlockPlacer;
import TechCraft.blocks.technogery.BlockMagiciansBuildingBlocks;
import TechCraft.blocks.technogery.BlockMultiBlockCore;
import TechCraft.blocks.technogery.BlockTestBlock;
import TechCraft.blocks.technogery.tcChargeBench.BlockTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.BlockTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFurnace.BlockTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.BlockGenorator;
import TechCraft.blocks.technogery.tcInfuser.BlockTCInfuser;
import TechCraft.blocks.technogery.tcSphere.BlockTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.BlockTCTeleporter;
import TechCraft.blocks.technogery.tcWirelessEnergyManger.BlockWirelessEnergyManager;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {

    public static TechCraftBlocks BlockAirCrystalOre;
    public static TechCraftBlocks BlockEarthCrystalOre;
    public static TechCraftBlocks BlockFireCrystalOre;
    public static TechCraftBlocks BlockWaterCrystalOre;

    public static TechCraftFlower BlockFreezingFlower;
    public static TechCraftFlower BlockBurningFlower;

    public static TechCraftBlocks BlockFalseBlock;
    public static TechCraftBlocks BlockEnergyCrystalOre;
    public static TechCraftBlocks BlockZycrantianOre;
    public static TechCraftBlocks BlockGarnetOre;
    public static TechCraftBlocks BlockGarnetBlock;

    public static TechCraftContainers BlockTestBlock;
    public static TechCraftContainers BlockTCEnergySphere;
    
    public static TechCraftContainers BlockTCItemConduit;
    
    public static TechCraftContainers BlockMagiciansBuildingBlocks;
    
    public static TechCraftContainers BlockGenorator;
    public static TechCraftContainers BlockMultiBlockCore;
    public static TechCraftContainers BlockTCFurnace;
    public static TechCraftContainers BlockTCChargeBench; 
    
    public static TechCraftContainers BlockTCInfuser;
    public static TechCraftContainers BlockTCTeleporter;
    public static TechCraftContainers BlockTCEnergyConstructor;  
    public static TechCraftContainers BlockItemExtractor;
    
    public static TechCraftBlocks BlockSpeedyRoad;
    
    public static TechCraftContainers BlockPersonalBlock;
    public static TechCraftContainers BlockWirelessEnergyManager;
    
    public static TechCraftBlocks BlockCrystallineTreeSapling;
    public static TechCraftBlocks BlockCrystallineTreeLog;
    public static TechCraftBlocks BlockCrystallineTreeLeaves;
    
    private static int id = 500;
    
    public static void init(Configuration config) {
        
        BlockAirCrystalOre = new BlockAirCrystalOre(config.getBlock("BlockAirCrystalOre", BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockAirCrystalOre.setUnlocalizedName("ASB2_BlockAirCrystalOre");
        GameRegistry.registerBlock(BlockAirCrystalOre, TehCraftItemBlock.class,"ASB2_BlockAirCrystalOre");
        LanguageRegistry.addName(BlockAirCrystalOre, "Air Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockAirCrystalOre, "pickaxe", 1);

        BlockEarthCrystalOre = new BlockEarthCrystalOre(config.getBlock("BlockEarthCrystalOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockEarthCrystalOre.setUnlocalizedName("ASB2_BlockEarthCrystalOre");
        GameRegistry.registerBlock(BlockEarthCrystalOre, TehCraftItemBlock.class,"ASB2_BlockEarthCrystalOre");
        LanguageRegistry.addName(BlockEarthCrystalOre, "Earth Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEarthCrystalOre, "pickaxe", 1);

        BlockFireCrystalOre = new BlockFireCrystalOre(config.getBlock("BlockFireCrystalOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockFireCrystalOre.setUnlocalizedName("ASB2_BlockFireCrystalOre");
        GameRegistry.registerBlock(BlockFireCrystalOre, TehCraftItemBlock.class, "ASB2_BlockFireCrystalOre");
        LanguageRegistry.addName(BlockFireCrystalOre, "Fire Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockFireCrystalOre, "pickaxe", 1);

        BlockWaterCrystalOre = new BlockWaterCrystalOre(config.getBlock("BlockWaterCrystalOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockWaterCrystalOre.setUnlocalizedName("ASB2_BlockWaterCrystalOre");
        GameRegistry.registerBlock(BlockWaterCrystalOre, TehCraftItemBlock.class, "ASB2_BlockWaterCrystalOre");
        LanguageRegistry.addName(BlockWaterCrystalOre, "Water Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockWaterCrystalOre, "pickaxe", 1);

        BlockFreezingFlower = new BlockFreezingFlower(config.getBlock("BlockFreezingFlower",  BlockRegistry.getNextBaseID()).getInt(), Material.plants);
        BlockFreezingFlower.setUnlocalizedName("ASB2_BlockFreezingFlower");
        GameRegistry.registerBlock(BlockFreezingFlower, TehCraftItemBlock.class, "ASB2_BlockFreezingFlower");
        LanguageRegistry.addName(BlockFreezingFlower, "Freezing Flower");
        MinecraftForge.setBlockHarvestLevel(BlockFreezingFlower, "fist", 0);

        BlockBurningFlower = new BlockBurningFlower(config.getBlock("BlockBurningFlower",  BlockRegistry.getNextBaseID()).getInt(), Material.plants);
        BlockBurningFlower.setUnlocalizedName("ASB2_BlockBurningFlower");
        GameRegistry.registerBlock(BlockBurningFlower, TehCraftItemBlock.class, "ASB2_BlockBurningFlower");
        LanguageRegistry.addName(BlockBurningFlower, "Burning Flower");
        MinecraftForge.setBlockHarvestLevel(BlockBurningFlower, "fist", 0);

        BlockFalseBlock = new BlockFalseBlock(config.getBlock("BlockFalseBlock",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockFalseBlock.setUnlocalizedName("ASB2_BlockFalseBlock");
        GameRegistry.registerBlock(BlockFalseBlock, TehCraftItemBlock.class, "ASB2_BlockFalseBlock");
        LanguageRegistry.addName(BlockFalseBlock, "False Stone");
        MinecraftForge.setBlockHarvestLevel(BlockFalseBlock, "pickaxe", 1);

        BlockEnergyCrystalOre = new BlockEnergyCrystalOre(config.getBlock("BlockEnergyCrystalOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockEnergyCrystalOre.setUnlocalizedName("ASB2_BlockEmptyCrystalOre");
        GameRegistry.registerBlock(BlockEnergyCrystalOre, TehCraftItemBlock.class, "ASB2_BlockEmptyCrystalOre");
        LanguageRegistry.addName(BlockEnergyCrystalOre, "Energy Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEnergyCrystalOre, "pickaxe", 1);

        BlockZycrantianOre = new BlockZycrantianOre(config.getBlock("BlockZycrantianOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockZycrantianOre.setUnlocalizedName("ASB2_BlockZycrantianOre");
        GameRegistry.registerBlock(BlockZycrantianOre, TehCraftItemBlock.class, "ASB2_BlockZycrantianOre");
        LanguageRegistry.addName(BlockZycrantianOre, "Zycrantain Ore");
        MinecraftForge.setBlockHarvestLevel(BlockZycrantianOre, "pickaxe", 2);

        BlockGarnetOre = new BlockGarnetOre(config.getBlock("BlockGarnetOre",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockGarnetOre.setUnlocalizedName("ASB2_BlockGarnetOre");
        GameRegistry.registerBlock(BlockGarnetOre, TehCraftItemBlock.class, "ASB2_BlockGarnetOre");
        LanguageRegistry.addName(BlockGarnetOre, "Garnet Ore");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetOre, "pickaxe", 2);

        BlockGarnetBlock = new BlockGarnetBlock(config.getBlock("BlockGarnetBlock",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockGarnetBlock.setUnlocalizedName("ASB2_BlockGarnetBlock");
        GameRegistry.registerBlock(BlockGarnetBlock, TehCraftItemBlock.class, "ASB2_BlockGarnetBlock");
        LanguageRegistry.addName(BlockGarnetBlock, "Garnet Block");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetBlock, "pickaxe", 2);

        BlockTestBlock = new BlockTestBlock(config.getBlock("BlockTestBlock",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTestBlock.setUnlocalizedName("ASB2_BlockTestBlock");
        GameRegistry.registerBlock(BlockTestBlock, TehCraftItemBlock.class, "ASB2_BlockTestBlock");
        LanguageRegistry.addName(BlockTestBlock, "Test Block");
        MinecraftForge.setBlockHarvestLevel(BlockTestBlock, "pickaxe", 2);

        BlockItemExtractor = new BlockItemExtractor(config.getBlock("BlockItemExtractor",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockItemExtractor.setUnlocalizedName("ASB2_BlockItemExtractor");
        GameRegistry.registerBlock(BlockItemExtractor, TehCraftItemBlock.class, "ASB2_BlockItemExtractor");
        LanguageRegistry.addName(BlockItemExtractor, "Item Extractor");
        MinecraftForge.setBlockHarvestLevel(BlockItemExtractor, "pickaxe", 2);
    
        BlockSpeedyRoad = new BlockSpeedyRoad(config.getBlock("BlockSpeedyRoad",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockSpeedyRoad.setUnlocalizedName("ASB2_BlockSpeedyRoad");
        GameRegistry.registerBlock(BlockSpeedyRoad, TehCraftItemBlock.class, "ASB2_BlockSpeedyRoad");
        LanguageRegistry.addName(BlockSpeedyRoad, "Speedy Road");
        MinecraftForge.setBlockHarvestLevel(BlockSpeedyRoad, "pickaxe", 2);
        
        BlockPersonalBlock = new BlockPersonalBlock(config.getBlock("BlockPersonalBlock",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockPersonalBlock.setUnlocalizedName("ASB2_BlockPersonalBlock");
        GameRegistry.registerBlock(BlockPersonalBlock, PersonalBlockPlacer.class, "ASB2_BlockPersonalBlock");
        LanguageRegistry.addName(new ItemStack(BlockPersonalBlock, 1, 0), "Personal Glass");
        LanguageRegistry.addName(new ItemStack(BlockPersonalBlock, 1, 1), "Personal Stone");
        MinecraftForge.setBlockHarvestLevel(BlockPersonalBlock, "pickaxe", 2);
        
        BlockMagiciansBuildingBlocks = new BlockMagiciansBuildingBlocks(config.getBlock("BlockEnergizedBuildingBlocks",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockMagiciansBuildingBlocks.setUnlocalizedName("ASB2_BlockMagiciansBuildingBlocks");
        GameRegistry.registerBlock(BlockMagiciansBuildingBlocks, TehCraftItemBlock.class, "ASB2_BlockMagiciansBuildingBlocks");
        LanguageRegistry.addName(BlockMagiciansBuildingBlocks, "Energized Building Block");
        MinecraftForge.setBlockHarvestLevel(BlockMagiciansBuildingBlocks, "pickaxe", 2);

        BlockTCEnergySphere = new BlockTCEnergySphere(config.getBlock("BlockTCEnergySphere",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCEnergySphere.setUnlocalizedName("ASB2_BlockTCEnergySphere");
        GameRegistry.registerBlock(BlockTCEnergySphere, TehCraftItemBlock.class, "ASB2_BlockTCEnergySphere");
        LanguageRegistry.addName(BlockTCEnergySphere, "Energy Sphere");
        MinecraftForge.setBlockHarvestLevel(BlockTCEnergySphere, "pickaxe", 2);

        BlockTCItemConduit = new BlockTCItemConduit(config.getBlock("BlockTCItemConduit",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCItemConduit.setUnlocalizedName("ASB2_BlockTCItemConduit");
        GameRegistry.registerBlock(BlockTCItemConduit, TehCraftItemBlock.class, "ASB2_BlockTCItemConduitt");
        LanguageRegistry.addName(BlockTCItemConduit, "Item Conduit");
        MinecraftForge.setBlockHarvestLevel(BlockTCItemConduit, "pickaxe", 2);
        
        BlockGenorator = new BlockGenorator(config.getBlock("BlockGenorator",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockGenorator.setUnlocalizedName("ASB2_BlockGenorator");
        GameRegistry.registerBlock(BlockGenorator, TehCraftItemBlock.class, "ASB2_BlockGenorator");
        LanguageRegistry.addName(BlockGenorator, "Genorator");
        MinecraftForge.setBlockHarvestLevel(BlockGenorator, "pickaxe", 2);

        BlockMultiBlockCore = new BlockMultiBlockCore(config.getBlock("BlockMultiBlockCore",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockMultiBlockCore.setUnlocalizedName("ASB2_BlockMultiBlockCore");
        GameRegistry.registerBlock(BlockMultiBlockCore, TehCraftItemBlock.class, "ASB2_BlockMultiBlockCore");
        LanguageRegistry.addName(BlockMultiBlockCore, "Multi-Block Core");
        MinecraftForge.setBlockHarvestLevel(BlockMultiBlockCore, "pickaxe", 2);

        BlockTCFurnace = new BlockTCFurnace(config.getBlock("BlockTCFurnace",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCFurnace.setUnlocalizedName("ASB2_BlockTCFurnace");
        GameRegistry.registerBlock(BlockTCFurnace, TehCraftItemBlock.class, "ASB2_BlockTCFurnace");
        LanguageRegistry.addName(BlockTCFurnace, "Speedy Furnace");
        MinecraftForge.setBlockHarvestLevel(BlockTCFurnace, "pickaxe", 2);

        BlockTCChargeBench = new BlockTCChargeBench(config.getBlock("BlockTCChargeBench",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCChargeBench.setUnlocalizedName("ASB2_BlockTCChargeBench");
        GameRegistry.registerBlock(BlockTCChargeBench, TehCraftItemBlock.class, "ASB2_BlockTCChargeBench");
        LanguageRegistry.addName(BlockTCChargeBench, "Charge Bench");
        MinecraftForge.setBlockHarvestLevel(BlockTCChargeBench, "pickaxe", 2);
        
        BlockTCInfuser = new BlockTCInfuser(config.getBlock("BlockTCInfuser",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCInfuser.setUnlocalizedName("ASB2_BlockTCInfuser");
        GameRegistry.registerBlock(BlockTCInfuser, TehCraftItemBlock.class, "ASB2_BlockTCInfuser");
        LanguageRegistry.addName(BlockTCInfuser, "Energy Infuser");
        MinecraftForge.setBlockHarvestLevel(BlockTCInfuser, "pickaxe", 2);
        
        BlockTCTeleporter = new BlockTCTeleporter(config.getBlock("BlockTCTeleporter",  BlockRegistry.getNextBaseID()).getInt(),Material.rock);
        BlockTCTeleporter.setUnlocalizedName("ASB2_BlockTCTeleporter");
        GameRegistry.registerBlock(BlockTCTeleporter, TehCraftItemBlock.class, "ASB2_BlockTCTeleporter");
        LanguageRegistry.addName(BlockTCTeleporter, "Teleporter Base");
        MinecraftForge.setBlockHarvestLevel(BlockTCTeleporter, "pickaxe", 2);
        
        BlockTCEnergyConstructor = new BlockTCEnergyConstructor(config.getBlock("BlockTCEnergyConstructor",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockTCEnergyConstructor.setUnlocalizedName("ASB2_BlockTCEnergyConstructor");
        GameRegistry.registerBlock(BlockTCEnergyConstructor, TehCraftItemBlock.class, "ASB2_BlockTCEnergyConstructor");
        LanguageRegistry.addName(BlockTCEnergyConstructor, "Energy Constructor");
        MinecraftForge.setBlockHarvestLevel(BlockTCEnergyConstructor, "pickaxe", 2);
        
        BlockWirelessEnergyManager = new BlockWirelessEnergyManager(config.getBlock("BlockWirelessEnergyManager",  BlockRegistry.getNextBaseID()).getInt(), Material.rock);
        BlockWirelessEnergyManager.setUnlocalizedName("ASB2_BlockWirelessEnergyManager");
        GameRegistry.registerBlock(BlockWirelessEnergyManager, TehCraftItemBlock.class, "ASB2_BlockWirelessEnergyManager");
        LanguageRegistry.addName(BlockWirelessEnergyManager, "Wireless Energy Manager");
        MinecraftForge.setBlockHarvestLevel(BlockWirelessEnergyManager, "pickaxe", 2);
    
        BlockCrystallineTreeSapling = new BlockCrystallineTreeSapling(config.getBlock("BlockCrystallineTreeSapling",  BlockRegistry.getNextBaseID()).getInt(), Material.plants);
        BlockCrystallineTreeSapling.setUnlocalizedName("ASB2_BlockCrystallineTreeSapling");
        GameRegistry.registerBlock(BlockCrystallineTreeSapling, TehCraftItemBlock.class, "ASB2_BlockCrystallineTreeSapling");
        LanguageRegistry.addName(BlockCrystallineTreeSapling, "Crystiline Sapling");
        MinecraftForge.setBlockHarvestLevel(BlockCrystallineTreeSapling, "pickaxe", 2);

        BlockCrystallineTreeLog = new BlockCrystallineTreeLog(config.getBlock("BlockCrystallineTreeLog",  BlockRegistry.getNextBaseID()).getInt(), Material.wood);
        BlockCrystallineTreeLog.setUnlocalizedName("ASB2_BlockCrystallineTreeLog");
        GameRegistry.registerBlock(BlockCrystallineTreeLog, TehCraftItemBlock.class, "ASB2_BlockCrystallineTreeLog");
        LanguageRegistry.addName(BlockCrystallineTreeLog, "Crystiline Logs");
        MinecraftForge.setBlockHarvestLevel(BlockCrystallineTreeLog, "pickaxe", 2);
        
        BlockCrystallineTreeLeaves = new BlockCrystallineTreeLeaves(config.getBlock("BlockCrystallineTreeLeaves",  BlockRegistry.getNextBaseID()).getInt(), Material.plants);
        BlockCrystallineTreeLeaves.setUnlocalizedName("ASB2_BlockCrystallineTreeLeaves");
        GameRegistry.registerBlock(BlockCrystallineTreeLeaves, TehCraftItemBlock.class, "ASB2_BlockCrystallineTreeLeaves");
        LanguageRegistry.addName(BlockCrystallineTreeLeaves, "Crystiline Leaves");
        MinecraftForge.setBlockHarvestLevel(BlockCrystallineTreeLeaves, "pickaxe", 2);        
    }

    public static int getNextBaseID() {        
                
        return id++;
    }
}
