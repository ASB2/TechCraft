package TechCraft;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
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
import TechCraft.blocks.technogery.BlockMagiciansBuildingBlocks;
import TechCraft.blocks.technogery.BlockMultiBlockCore;
import TechCraft.blocks.technogery.BlockTechnogryFocus;
import TechCraft.blocks.technogery.BlockTestBlock;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.BlockMagicConduitExporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.BlockMagicConduitImporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.BlockMagicConduitMoving;
import TechCraft.blocks.technogery.farms.BasicFarm.BlockBasicFarm;
import TechCraft.blocks.technogery.tcChargeBench.BlockTCChargeBench;
import TechCraft.blocks.technogery.tcFurnace.BlockTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.BlockGenorator;
import TechCraft.blocks.technogery.tcSphere.BlockTCEnergySphere;
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
    
    public static TechCraftContainers BlockMagicConduitExporting;
    public static TechCraftContainers BlockMagicConduitImporting;
    public static TechCraftContainers BlockMagicConduitMoving;
    
    public static TechCraftContainers BlockTechnogryFocus;
    public static TechCraftContainers BlockMagiciansBuildingBlocks;
    
    public static TechCraftContainers BlockBasicFarm;
    public static TechCraftContainers BlockGenorator;
    public static TechCraftContainers BlockMultiBlockCore;
    public static TechCraftContainers BlockTCFurnace;
    public static TechCraftContainers BlockTCChargeBench;
    
    public static void init() {

        BlockAirCrystalOre = new BlockAirCrystalOre(500, 0, Material.rock);
        BlockAirCrystalOre.setUnlocalizedName("BlockAirCrystalOre");
        GameRegistry.registerBlock(BlockAirCrystalOre, "ASB2_BlockAirCrystalOre");
        LanguageRegistry.addName(BlockAirCrystalOre, "Air Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockAirCrystalOre, "pickaxe", 1);

        BlockEarthCrystalOre = new BlockEarthCrystalOre(501, 1, Material.rock);
        BlockEarthCrystalOre.setUnlocalizedName("BlockEarthCrystalOre");
        GameRegistry.registerBlock(BlockEarthCrystalOre, "ASB2_BlockEarthCrystalOre");
        LanguageRegistry.addName(BlockEarthCrystalOre, "Earth Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEarthCrystalOre, "pickaxe", 1);

        BlockFireCrystalOre = new BlockFireCrystalOre(502, 2, Material.rock);
        BlockFireCrystalOre.setUnlocalizedName("BlockFireCrystalOre");
        GameRegistry.registerBlock(BlockFireCrystalOre, "ASB2_BlockFireCrystalOre");
        LanguageRegistry.addName(BlockFireCrystalOre, "Fire Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockFireCrystalOre, "pickaxe", 1);

        BlockWaterCrystalOre = new BlockWaterCrystalOre(503, 3, Material.rock);
        BlockWaterCrystalOre.setUnlocalizedName("BlockWaterCrystalOre");
        GameRegistry.registerBlock(BlockWaterCrystalOre, "ASB2_BlockWaterCrystalOre");
        LanguageRegistry.addName(BlockWaterCrystalOre, "Water Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockWaterCrystalOre, "pickaxe", 1);

        BlockFreezingFlower = new BlockFreezingFlower(504, 4, Material.plants);
        BlockFreezingFlower.setUnlocalizedName("BlockFreezingFlower");
        GameRegistry.registerBlock(BlockFreezingFlower, "ASB2_BlockFreezingFlower");
        LanguageRegistry.addName(BlockFreezingFlower, "Freezing Flower");
        MinecraftForge.setBlockHarvestLevel(BlockFreezingFlower, "fist", 0);

        BlockBurningFlower = new BlockBurningFlower(505, 5, Material.plants);
        BlockBurningFlower.setUnlocalizedName("BlockBurningFlower");
        GameRegistry.registerBlock(BlockBurningFlower, "ASB2_BlockBurningFlower");
        LanguageRegistry.addName(BlockBurningFlower, "Burning Flower");
        MinecraftForge.setBlockHarvestLevel(BlockBurningFlower, "fist", 0);

        BlockFalseBlock = new BlockFalseBlock(506, 1, Material.rock);
        BlockFalseBlock.setUnlocalizedName("BlockFalseBlock");
        GameRegistry.registerBlock(BlockFalseBlock, "ASB2_BlockFalseBlock");
        LanguageRegistry.addName(BlockFalseBlock, "False Floor");
        MinecraftForge.setBlockHarvestLevel(BlockFalseBlock, "pickaxe", 1);

        BlockEnergyCrystalOre = new BlockEnergyCrystalOre(507, 7, Material.rock);
        BlockEnergyCrystalOre.setUnlocalizedName("BlockEnergyCrystalOre");
        GameRegistry.registerBlock(BlockEnergyCrystalOre, "ASB2_BlockEmptyCrystalOre");
        LanguageRegistry.addName(BlockEnergyCrystalOre, "Energy Crystal Ore");
        MinecraftForge.setBlockHarvestLevel(BlockEnergyCrystalOre, "pickaxe", 1);

        BlockZycrantianOre = new BlockZycrantianOre(508, 8, Material.rock);
        BlockZycrantianOre.setUnlocalizedName("BlockZycrantianOre");
        GameRegistry.registerBlock(BlockZycrantianOre, "ASB2_BlockZycrantianOre");
        LanguageRegistry.addName(BlockZycrantianOre, "Zycrantain Ore");
        MinecraftForge.setBlockHarvestLevel(BlockZycrantianOre, "pickaxe", 2);

        BlockGarnetOre = new BlockGarnetOre(509, 9, Material.rock);
        BlockGarnetOre.setUnlocalizedName("BlockGarnetOre");
        GameRegistry.registerBlock(BlockGarnetOre, "ASB2_BlockGarnetOre");
        LanguageRegistry.addName(BlockGarnetOre, "Garnet Ore");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetOre, "pickaxe", 2);

        BlockGarnetBlock = new BlockGarnetBlock(510,Material.rock);
        BlockGarnetBlock.setUnlocalizedName("BlockGarnetBlock");
        GameRegistry.registerBlock(BlockGarnetBlock, "ASB2_BlockGarnetBlock");
        LanguageRegistry.addName(BlockGarnetBlock, "Garnet Block");
        MinecraftForge.setBlockHarvestLevel(BlockGarnetBlock, "pickaxe", 2);
        
        BlockTestBlock = new BlockTestBlock(511,Material.rock);
        BlockTestBlock.setUnlocalizedName("BlockTestBlock");
        GameRegistry.registerBlock(BlockTestBlock, "ASB2_BlockTestBlock");
        LanguageRegistry.addName(BlockTestBlock, "Test Block");
        MinecraftForge.setBlockHarvestLevel(BlockTestBlock, "pickaxe", 2);
        
        BlockTCEnergySphere = new BlockTCEnergySphere(512,Material.rock);
        BlockTCEnergySphere.setUnlocalizedName("BlockTCEnergySphere");
        GameRegistry.registerBlock(BlockTCEnergySphere, "ASB2_BlockTCEnergySphere");
        LanguageRegistry.addName(BlockTCEnergySphere, "TC Energy Sphere");
        MinecraftForge.setBlockHarvestLevel(BlockTCEnergySphere, "pickaxe", 2);
        
        BlockMagicConduitExporting = new BlockMagicConduitExporting(513,Material.rock);
        BlockMagicConduitExporting.setUnlocalizedName("BlockMagicConduitExporting");
        GameRegistry.registerBlock(BlockMagicConduitExporting, "ASB2_BlockMagicConduitExporting");
        LanguageRegistry.addName(BlockMagicConduitExporting, "Techno Energy Conduit (Exporting)");
        MinecraftForge.setBlockHarvestLevel(BlockMagicConduitExporting, "pickaxe", 2);

        BlockMagicConduitImporting = new BlockMagicConduitImporting(514,Material.rock);
        BlockMagicConduitImporting.setUnlocalizedName("BlockMagicConduitImporting");
        GameRegistry.registerBlock(BlockMagicConduitImporting, "ASB2_BlockMagicConduitImporting");
        LanguageRegistry.addName(BlockMagicConduitImporting, "Techno Energy Conduit (Importing)");
        MinecraftForge.setBlockHarvestLevel(BlockMagicConduitImporting, "pickaxe", 2);

        BlockMagicConduitMoving = new BlockMagicConduitMoving(515,Material.rock);
        BlockMagicConduitMoving.setUnlocalizedName("BlockMagicConduitMoving");
        GameRegistry.registerBlock(BlockMagicConduitMoving, "ASB2_BlockMagicConduitMoving");
        LanguageRegistry.addName(BlockMagicConduitMoving, "Techno Energy Conduit (Moving)");
        MinecraftForge.setBlockHarvestLevel(BlockMagicConduitMoving, "pickaxe", 2);
        
        BlockTechnogryFocus = new BlockTechnogryFocus(516,Material.rock);
        BlockTechnogryFocus.setUnlocalizedName("BlockTechnogryFocus");
        GameRegistry.registerBlock(BlockTechnogryFocus, "ASB2_BlockTechnogryFocus");
        LanguageRegistry.addName(BlockTechnogryFocus, "Technogry Focus");
        MinecraftForge.setBlockHarvestLevel(BlockTechnogryFocus, "pickaxe", 2);
        
        BlockMagiciansBuildingBlocks = new BlockMagiciansBuildingBlocks(517,Material.rock);
        BlockMagiciansBuildingBlocks.setUnlocalizedName("BlockMagiciansBuildingBlocks");
        GameRegistry.registerBlock(BlockMagiciansBuildingBlocks, "ASB2_BlockMagiciansBuildingBlocks");
        LanguageRegistry.addName(BlockMagiciansBuildingBlocks, "Magician's Building Blocks");
        MinecraftForge.setBlockHarvestLevel(BlockMagiciansBuildingBlocks, "pickaxe", 2);
        
        BlockBasicFarm = new BlockBasicFarm(518,Material.rock);
        BlockBasicFarm.setUnlocalizedName("BlockBasicFarm");
        GameRegistry.registerBlock(BlockBasicFarm, "ASB2_BlockBasicFarm");
        LanguageRegistry.addName(BlockBasicFarm, "Basic TechCraft Farm");
        MinecraftForge.setBlockHarvestLevel(BlockBasicFarm, "pickaxe", 2);
        
        BlockGenorator = new BlockGenorator(519,Material.rock);
        BlockGenorator.setUnlocalizedName("BlockGenorator");
        GameRegistry.registerBlock(BlockGenorator, "ASB2_BlockGenorator");
        LanguageRegistry.addName(BlockGenorator, "Basic Genorator");
        MinecraftForge.setBlockHarvestLevel(BlockGenorator, "pickaxe", 2);
        
        BlockMultiBlockCore = new BlockMultiBlockCore(520,Material.rock);
        BlockMultiBlockCore.setUnlocalizedName("BlockMultiBlockCore");
        GameRegistry.registerBlock(BlockMultiBlockCore, "ASB2_BlockMultiBlockCore");
        LanguageRegistry.addName(BlockMultiBlockCore, "Multi-Block Core");
        MinecraftForge.setBlockHarvestLevel(BlockMultiBlockCore, "pickaxe", 2);
        
        BlockTCFurnace = new BlockTCFurnace(521,Material.rock);
        BlockTCFurnace.setUnlocalizedName("BlockTCFurnace");
        GameRegistry.registerBlock(BlockTCFurnace, "ASB2_BlockTCFurnace");
        LanguageRegistry.addName(BlockTCFurnace, "TC Furnace");
        MinecraftForge.setBlockHarvestLevel(BlockTCFurnace, "pickaxe", 2);
        
        BlockTCChargeBench = new BlockTCChargeBench(522,Material.rock);
        BlockTCChargeBench.setUnlocalizedName("BlockTCChargeBench");
        GameRegistry.registerBlock(BlockTCChargeBench, "ASB2_BlockTCChargeBench");
        LanguageRegistry.addName(BlockTCChargeBench, "TC Charge Bench");
        MinecraftForge.setBlockHarvestLevel(BlockTCChargeBench, "pickaxe", 2);
        
    }

}
