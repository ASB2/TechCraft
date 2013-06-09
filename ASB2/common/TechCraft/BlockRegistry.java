package TechCraft;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
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
import TechCraft.blocks.BlockWaterCrystalOre;
import TechCraft.blocks.BlockZycrantianOre;
import TechCraft.blocks.TechCraftBlocks;
import TechCraft.blocks.TechCraftContainers;
import TechCraft.blocks.item_transfer.item_SenderReciever.BlockItemReciever;
import TechCraft.blocks.item_transfer.item_SenderReciever.BlockItemSender;
import TechCraft.blocks.tanks.BlockTCTank;
import TechCraft.blocks.tcRunes.BlockBasicRune;
import TechCraft.blocks.tcRunes.BlockRuneBase;
import TechCraft.blocks.tcToolManager.BlockToolManager;
import TechCraft.blocks.technogery.BlockMagiciansBuildingBlocks;
import TechCraft.blocks.technogery.BlockMultiBlockCore;
import TechCraft.blocks.technogery.BlockTechnogryFocus;
import TechCraft.blocks.technogery.BlockTestBlock;
import TechCraft.blocks.technogery.farms.BasicFarm.BlockBasicFarm;
import TechCraft.blocks.technogery.power_Conduit.BlockPowerConduitExporting;
import TechCraft.blocks.technogery.power_Conduit.BlockPowerConduitImporting;
import TechCraft.blocks.technogery.power_Conduit.BlockPowerConduitMoving;
import TechCraft.blocks.technogery.tcChargeBench.BlockTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.BlockTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFurnace.BlockTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.BlockGenorator;
import TechCraft.blocks.technogery.tcGrinder.BlockTCGrinder;
import TechCraft.blocks.technogery.tcInfuser.BlockTCInfuser;
import TechCraft.blocks.technogery.tcSphere.BlockTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.BlockTCTeleporter;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {

    public static TechCraftBlocks BlockAirCrystalOre;
    public static TechCraftBlocks BlockEarthCrystalOre;
    public static TechCraftBlocks BlockFireCrystalOre;
    public static TechCraftBlocks BlockWaterCrystalOre;

    public static BlockFlower BlockFreezingFlower;
    public static BlockFlower BlockBurningFlower;

    public static TechCraftBlocks BlockFalseBlock;
    public static TechCraftBlocks BlockEnergyCrystalOre;
    public static TechCraftBlocks BlockZycrantianOre;
    public static TechCraftBlocks BlockGarnetOre;
    public static TechCraftBlocks BlockGarnetBlock;

    public static TechCraftContainers BlockTestBlock;
    public static TechCraftContainers BlockTCEnergySphere;

    public static TechCraftContainers BlockPowerConduitExporting;
    public static TechCraftContainers BlockPowerConduitImporting;
    public static TechCraftContainers BlockPowerConduitMoving;

    public static TechCraftContainers BlockTechnogryFocus;
    public static TechCraftContainers BlockMagiciansBuildingBlocks;

    public static TechCraftContainers BlockBasicFarm;
    public static TechCraftContainers BlockGenorator;
    public static TechCraftContainers BlockMultiBlockCore;
    public static TechCraftContainers BlockTCFurnace;
    public static TechCraftContainers BlockTCChargeBench;    

    public static BlockRuneBase BlockBasicRune;
    
    public static TechCraftContainers BlockTCInfuser;
    public static TechCraftContainers BlockTCTeleporter;    
    public static TechCraftContainers BlockTCTank;
    public static TechCraftContainers BlockTCGrinder;
    
    public static TechCraftContainers BlockItemReciever;
    public static TechCraftContainers BlockItemSender;
    public static TechCraftContainers BlockToolManager;
    public static TechCraftContainers BlockTCEnergyConstructor;
    

    public static void init(Configuration config) {

        BlockAirCrystalOre = new BlockAirCrystalOre(config.getBlock("BlockAirCrystalOre", 500).getInt(), Material.rock);
        BlockAirCrystalOre.setUnlocalizedName("ASB2_BlockAirCrystalOre");
        GameRegistry.registerBlock(BlockAirCrystalOre, "ASB2_BlockAirCrystalOre");
        LanguageRegistry.addName(BlockAirCrystalOre, "Air Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockAirCrystalOre, "pickaxe", 1);

        BlockEarthCrystalOre = new BlockEarthCrystalOre(config.getBlock("BlockEarthCrystalOre", 501).getInt(), Material.rock);
        BlockEarthCrystalOre.setUnlocalizedName("ASB2_BlockEarthCrystalOre");
        GameRegistry.registerBlock(BlockEarthCrystalOre, "ASB2_BlockEarthCrystalOre");
        LanguageRegistry.addName(BlockEarthCrystalOre, "Earth Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEarthCrystalOre, "pickaxe", 1);

        BlockFireCrystalOre = new BlockFireCrystalOre(config.getBlock("BlockFireCrystalOre", 502).getInt(), Material.rock);
        BlockFireCrystalOre.setUnlocalizedName("ASB2_BlockFireCrystalOre");
        GameRegistry.registerBlock(BlockFireCrystalOre, "ASB2_BlockFireCrystalOre");
        LanguageRegistry.addName(BlockFireCrystalOre, "Fire Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockFireCrystalOre, "pickaxe", 1);

        BlockWaterCrystalOre = new BlockWaterCrystalOre(config.getBlock("BlockWaterCrystalOre", 503).getInt(), Material.rock);
        BlockWaterCrystalOre.setUnlocalizedName("ASB2_BlockWaterCrystalOre");
        GameRegistry.registerBlock(BlockWaterCrystalOre, "ASB2_BlockWaterCrystalOre");
        LanguageRegistry.addName(BlockWaterCrystalOre, "Water Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockWaterCrystalOre, "pickaxe", 1);

        BlockFreezingFlower = new BlockFreezingFlower(config.getBlock("BlockFreezingFlower", 504).getInt(), Material.plants);
        BlockFreezingFlower.setUnlocalizedName("ASB2_BlockFreezingFlower");
        GameRegistry.registerBlock(BlockFreezingFlower, "ASB2_BlockFreezingFlower");
        LanguageRegistry.addName(BlockFreezingFlower, "Freezing Flower");
        MinecraftForge.setBlockHarvestLevel(BlockFreezingFlower, "fist", 0);

        BlockBurningFlower = new BlockBurningFlower(config.getBlock("BlockBurningFlower", 505).getInt(), Material.plants);
        BlockBurningFlower.setUnlocalizedName("ASB2_BlockBurningFlower");
        GameRegistry.registerBlock(BlockBurningFlower, "ASB2_BlockBurningFlower");
        LanguageRegistry.addName(BlockBurningFlower, "Burning Flower");
        MinecraftForge.setBlockHarvestLevel(BlockBurningFlower, "fist", 0);

        BlockFalseBlock = new BlockFalseBlock(config.getBlock("BlockFalseBlock", 506).getInt(), Material.rock);
        BlockFalseBlock.setUnlocalizedName("ASB2_BlockFalseBlock");
        GameRegistry.registerBlock(BlockFalseBlock, "ASB2_BlockFalseBlock");
        LanguageRegistry.addName(BlockFalseBlock, "False Stone");
        MinecraftForge.setBlockHarvestLevel(BlockFalseBlock, "pickaxe", 1);

        BlockEnergyCrystalOre = new BlockEnergyCrystalOre(config.getBlock("BlockEnergyCrystalOre", 507).getInt(), Material.rock);
        BlockEnergyCrystalOre.setUnlocalizedName("ASB2_BlockEmptyCrystalOre");
        GameRegistry.registerBlock(BlockEnergyCrystalOre, "ASB2_BlockEmptyCrystalOre");
        LanguageRegistry.addName(BlockEnergyCrystalOre, "Energy Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEnergyCrystalOre, "pickaxe", 1);

        BlockZycrantianOre = new BlockZycrantianOre(config.getBlock("BlockZycrantianOre", 508).getInt(), Material.rock);
        BlockZycrantianOre.setUnlocalizedName("ASB2_BlockZycrantianOre");
        GameRegistry.registerBlock(BlockZycrantianOre, "ASB2_BlockZycrantianOre");
        LanguageRegistry.addName(BlockZycrantianOre, "Zycrantain Ore");
        MinecraftForge.setBlockHarvestLevel(BlockZycrantianOre, "pickaxe", 2);

        BlockGarnetOre = new BlockGarnetOre(config.getBlock("BlockGarnetOre", 509).getInt(), Material.rock);
        BlockGarnetOre.setUnlocalizedName("ASB2_BlockGarnetOre");
        GameRegistry.registerBlock(BlockGarnetOre, "ASB2_BlockGarnetOre");
        LanguageRegistry.addName(BlockGarnetOre, "Garnet Ore");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetOre, "pickaxe", 2);

        BlockGarnetBlock = new BlockGarnetBlock(config.getBlock("BlockGarnetBlock", 510).getInt(),Material.rock);
        BlockGarnetBlock.setUnlocalizedName("ASB2_BlockGarnetBlock");
        GameRegistry.registerBlock(BlockGarnetBlock, "ASB2_BlockGarnetBlock");
        LanguageRegistry.addName(BlockGarnetBlock, "Garnet Block");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetBlock, "pickaxe", 2);

        BlockTestBlock = new BlockTestBlock(config.getBlock("BlockTestBlock", 511).getInt(),Material.rock);
        BlockTestBlock.setUnlocalizedName("ASB2_BlockTestBlock");
        GameRegistry.registerBlock(BlockTestBlock, "ASB2_BlockTestBlock");
        LanguageRegistry.addName(BlockTestBlock, "Test Block");
        MinecraftForge.setBlockHarvestLevel(BlockTestBlock, "pickaxe", 2);

        BlockTCEnergySphere = new BlockTCEnergySphere(config.getBlock("BlockTCEnergySphere", 512).getInt(),Material.rock);
        BlockTCEnergySphere.setUnlocalizedName("ASB2_BlockTCEnergySphere");
        GameRegistry.registerBlock(BlockTCEnergySphere, "ASB2_BlockTCEnergySphere");
        LanguageRegistry.addName(BlockTCEnergySphere, "TC Energy Sphere");
        MinecraftForge.setBlockHarvestLevel(BlockTCEnergySphere, "pickaxe", 2);

        BlockPowerConduitExporting = new BlockPowerConduitExporting(config.getBlock("BlockPowerConduitExporting", 513).getInt(),Material.rock);
        BlockPowerConduitExporting.setUnlocalizedName("ASB2_BlockPowerConduitExporting");
        GameRegistry.registerBlock(BlockPowerConduitExporting, "ASB2_BlockPowerConduitExporting");
        LanguageRegistry.addName(BlockPowerConduitExporting, "Force Exporting Conduit");
        MinecraftForge.setBlockHarvestLevel(BlockPowerConduitExporting, "pickaxe", 2);

        BlockPowerConduitImporting = new BlockPowerConduitImporting(config.getBlock("BlockPowerConduitImporting", 514).getInt(),Material.rock);
        BlockPowerConduitImporting.setUnlocalizedName("ASB2_BlockPowerConduitImporting");
        GameRegistry.registerBlock(BlockPowerConduitImporting, "ASB2_BlockPowerConduitImporting");
        LanguageRegistry.addName(BlockPowerConduitImporting, "Force Importing Conduit");
        MinecraftForge.setBlockHarvestLevel(BlockPowerConduitImporting, "pickaxe", 2);

        BlockPowerConduitMoving = new BlockPowerConduitMoving(config.getBlock("BlockPowerConduitMoving", 515).getInt(),Material.rock);
        BlockPowerConduitMoving.setUnlocalizedName("ASB2_BlockPowerConduitMoving");
        GameRegistry.registerBlock(BlockPowerConduitMoving, "ASB2_BlockPowerConduitMoving");
        LanguageRegistry.addName(BlockPowerConduitMoving, "TC Energy Conduit");
        MinecraftForge.setBlockHarvestLevel(BlockPowerConduitMoving, "pickaxe", 2);

        BlockTechnogryFocus = new BlockTechnogryFocus(config.getBlock("BlockTechnogryFocus", 516).getInt(),Material.rock);
        BlockTechnogryFocus.setUnlocalizedName("ASB2_BlockTechnogryFocus");
        GameRegistry.registerBlock(BlockTechnogryFocus, "ASB2_BlockTechnogryFocus");
        LanguageRegistry.addName(BlockTechnogryFocus, "Technogry Focus");
        MinecraftForge.setBlockHarvestLevel(BlockTechnogryFocus, "pickaxe", 2);

        BlockMagiciansBuildingBlocks = new BlockMagiciansBuildingBlocks(config.getBlock("BlockEnergizedBuildingBlocks", 517).getInt(),Material.rock);
        BlockMagiciansBuildingBlocks.setUnlocalizedName("ASB2_BlockMagiciansBuildingBlocks");
        GameRegistry.registerBlock(BlockMagiciansBuildingBlocks, "ASB2_BlockMagiciansBuildingBlocks");
        LanguageRegistry.addName(BlockMagiciansBuildingBlocks, "Energized Building Blocks");
        MinecraftForge.setBlockHarvestLevel(BlockMagiciansBuildingBlocks, "pickaxe", 2);

        BlockBasicFarm = new BlockBasicFarm(config.getBlock("BlockBasicFarm", 518).getInt(),Material.rock);
        BlockBasicFarm.setUnlocalizedName("ASB2_BlockBasicFarm");
        GameRegistry.registerBlock(BlockBasicFarm, "ASB2_BlockBasicFarm");
        LanguageRegistry.addName(BlockBasicFarm, "TC Farm");
        MinecraftForge.setBlockHarvestLevel(BlockBasicFarm, "pickaxe", 2);

        BlockGenorator = new BlockGenorator(config.getBlock("BlockGenorator", 519).getInt(),Material.rock);
        BlockGenorator.setUnlocalizedName("ASB2_BlockGenorator");
        GameRegistry.registerBlock(BlockGenorator, "ASB2_BlockGenorator");
        LanguageRegistry.addName(BlockGenorator, "TC Genorator");
        MinecraftForge.setBlockHarvestLevel(BlockGenorator, "pickaxe", 2);

        BlockMultiBlockCore = new BlockMultiBlockCore(config.getBlock("BlockMultiBlockCore", 520).getInt(),Material.rock);
        BlockMultiBlockCore.setUnlocalizedName("ASB2_BlockMultiBlockCore");
        GameRegistry.registerBlock(BlockMultiBlockCore, "ASB2_BlockMultiBlockCore");
        LanguageRegistry.addName(BlockMultiBlockCore, "TC Multi-Block Core");
        MinecraftForge.setBlockHarvestLevel(BlockMultiBlockCore, "pickaxe", 2);

        BlockTCFurnace = new BlockTCFurnace(config.getBlock("BlockTCFurnace", 521).getInt(),Material.rock);
        BlockTCFurnace.setUnlocalizedName("ASB2_BlockTCFurnace");
        GameRegistry.registerBlock(BlockTCFurnace, "ASB2_BlockTCFurnace");
        LanguageRegistry.addName(BlockTCFurnace, "TC Furnace");
        MinecraftForge.setBlockHarvestLevel(BlockTCFurnace, "pickaxe", 2);

        BlockTCChargeBench = new BlockTCChargeBench(config.getBlock("BlockTCChargeBench", 522).getInt(),Material.rock);
        BlockTCChargeBench.setUnlocalizedName("ASB2_BlockTCChargeBench");
        GameRegistry.registerBlock(BlockTCChargeBench, "ASB2_BlockTCChargeBench");
        LanguageRegistry.addName(BlockTCChargeBench, "TC Charge Bench");
        MinecraftForge.setBlockHarvestLevel(BlockTCChargeBench, "pickaxe", 2);

        BlockBasicRune = new BlockBasicRune(config.getBlock("BlockBasicRune", 523).getInt(),Material.rock);
        BlockBasicRune.setUnlocalizedName("ASB2_BlockBasicRune");
        GameRegistry.registerBlock(BlockBasicRune, "ASB2_BlockBasicRune");
        LanguageRegistry.addName(BlockBasicRune, "TC Basic Rune");
        MinecraftForge.setBlockHarvestLevel(BlockBasicRune, "pickaxe", 2);
        
        BlockTCInfuser = new BlockTCInfuser(config.getBlock("BlockTCInfuser", 524).getInt(),Material.rock);
        BlockTCInfuser.setUnlocalizedName("ASB2_BlockTCInfuser");
        GameRegistry.registerBlock(BlockTCInfuser, "ASB2_BlockTCInfuser");
        LanguageRegistry.addName(BlockTCInfuser, "TC Infuser");
        MinecraftForge.setBlockHarvestLevel(BlockTCInfuser, "pickaxe", 2);
        
        BlockTCTeleporter = new BlockTCTeleporter(config.getBlock("BlockTCTeleporter", 525).getInt(),Material.rock);
        BlockTCTeleporter.setUnlocalizedName("ASB2_BlockTCTeleporter");
        GameRegistry.registerBlock(BlockTCTeleporter, "ASB2_BlockTCTeleporter");
        LanguageRegistry.addName(BlockTCTeleporter, "TC Teleporter");
        MinecraftForge.setBlockHarvestLevel(BlockTCTeleporter, "pickaxe", 2);
        
        BlockTCTank = new BlockTCTank(config.getBlock("BlockTCTank", 526).getInt(), Material.rock);
        BlockTCTank.setUnlocalizedName("ASB2_BlockTCTank");
        GameRegistry.registerBlock(BlockTCTank, "ASB2_BlockTCTank");
        LanguageRegistry.addName(BlockTCTank, "TC Tank");
        MinecraftForge.setBlockHarvestLevel(BlockTCTank, "pickaxe", 2);
        
        BlockTCGrinder = new BlockTCGrinder(config.getBlock("BlockTCGrinder", 527).getInt(), Material.rock);
        BlockTCGrinder.setUnlocalizedName("ASB2_BlockTCGrinder");
        GameRegistry.registerBlock(BlockTCGrinder, "ASB2_BlockTCGrinder");
        LanguageRegistry.addName(BlockTCGrinder, "TC Grinder");
        MinecraftForge.setBlockHarvestLevel(BlockTCGrinder, "pickaxe", 2);
        
        BlockItemReciever = new BlockItemReciever(config.getBlock("BlockItemReciever", 528).getInt(), Material.rock);
        BlockItemReciever.setUnlocalizedName("ASB2_BlockItemReciever");
        GameRegistry.registerBlock(BlockItemReciever, "ASB2_BlockItemReciever");
        LanguageRegistry.addName(BlockItemReciever, "Item Reciever");
        MinecraftForge.setBlockHarvestLevel(BlockItemReciever, "pickaxe", 2);
        
        BlockItemSender = new BlockItemSender(config.getBlock("BlockItemSender", 529).getInt(), Material.rock);
        BlockItemSender.setUnlocalizedName("ASB2_BlockItemSender");
        GameRegistry.registerBlock(BlockItemSender, "ASB2_BlockItemSender");
        LanguageRegistry.addName(BlockItemSender, "Item Sender");
        MinecraftForge.setBlockHarvestLevel(BlockItemSender, "pickaxe", 2);
        
        BlockToolManager = new BlockToolManager(config.getBlock("BlockToolManager", 530).getInt(), Material.rock);
        BlockToolManager.setUnlocalizedName("ASB2_BlockToolManager");
        GameRegistry.registerBlock(BlockToolManager, "ASB2_BlockToolManager");
        LanguageRegistry.addName(BlockToolManager, "Tool Manager");
        MinecraftForge.setBlockHarvestLevel(BlockToolManager, "pickaxe", 2);
        
        BlockTCEnergyConstructor = new BlockTCEnergyConstructor(config.getBlock("BlockTCEnergyConstructor", 531).getInt(), Material.rock);
        BlockTCEnergyConstructor.setUnlocalizedName("ASB2_BlockTCEnergyConstructor");
        GameRegistry.registerBlock(BlockTCEnergyConstructor, "ASB2_BlockTCEnergyConstructor");
        LanguageRegistry.addName(BlockTCEnergyConstructor, "Energy Constructor");
        MinecraftForge.setBlockHarvestLevel(BlockTCEnergyConstructor, "pickaxe", 2);
    }

}
