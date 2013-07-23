package TechCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import TechCraft.blocks.tcItemExtractor.TileItemExtractor;
import TechCraft.blocks.tcPersonalBlocks.TilePersonalBlock;
import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergizedBuildingBlocks.TileEnergizedBuildingBlocks;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
import TechCraft.blocks.technogery.tcEnergySender.TileEnergySender;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.packets.TechCraftPacketBase;
import TechCraft.packets.TechCraftPacketHandler;
import TechCraft.worldGen.WorldGenBlockAirCrystalOre;
import TechCraft.worldGen.WorldGenBlockBurningFlower;
import TechCraft.worldGen.WorldGenBlockEarthCrystalOre;
import TechCraft.worldGen.WorldGenBlockEnergyCrystalOre;
import TechCraft.worldGen.WorldGenBlockFalseBlock;
import TechCraft.worldGen.WorldGenBlockFireCrystalOre;
import TechCraft.worldGen.WorldGenBlockFreezingFlower;
import TechCraft.worldGen.WorldGenBlockGarnetOre;
import TechCraft.worldGen.WorldGenBlockWaterCrystalOre;
import TechCraft.worldGen.WorldGenBlockZycrantianOre;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import TechCraft.blocks.technogery.tcPlanter.*;

@Mod(modid = TechCraft.modid, name = "ASB2's TechCraft", version = "Not a Full Release Yet")

@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels={TechCraftPacketBase.CHANNEL}, packetHandler = TechCraftPacketHandler.class)

public class TechCraft {

    public static final String modid = "ASB2_TechCraft";

    @Instance(TechCraft.modid)

    public static TechCraft instance;

    @SidedProxy(clientSide="TechCraft.ClientProxy", serverSide="TechCraft.CommonProxy")

    public static CommonProxy proxy;
    public static ClientProxy clientProxy;

    public static CreativeTabs tabTCBlocks = new TechCraftCreativeTab(CreativeTabs.getNextID(),"TechCraft Blocks", "TechCraft Blocks");
    public static CreativeTabs tabTCItems = new TechCraftCreativeTab( CreativeTabs.getNextID(),"TechCraft Items", "TechCraft Blocks");

    public static boolean includePowerRecipies = false;
    public static boolean includeArmorRecipies = true;
    public static boolean includeRuneRecipies = false;
    public static boolean modCreatorAndHelperPerks = true;
    public static boolean testingMode = true;

    public static int crystilineTreeHight = 10;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        ItemRegistry.init(config);
        BlockRegistry.init(config);

        modCreatorAndHelperPerks = config.get("Misc", "modCreatorAndHelperPerks", true, "A few little things to show you care. Nothing game changing. Will have no affect on any one but us.").getBoolean(true);
        crystilineTreeHight = config.get("Misc", "crystilineTreeHight", 10, "Play with the value. Its fun. It can get a little rediculus").getInt(10);
        config.save();
    }

    @Init
    public void load(FMLInitializationEvent event) {

        proxy.register();
        instance = this;

        MinecraftForge.EVENT_BUS.register(new TechCraftForgeEvents());
        GameRegistry.registerFuelHandler(new TechCraftFuelHandler());

        GameRegistry.registerPlayerTracker(new TechCraftPlayerTracker ());

        //MinecraftForge.addGrassSeed(new ItemStack(ItemRegistry.ItemLifeCrystal), 10);
        MinecraftForge.addGrassPlant(BlockRegistry.BlockBurningFlower,0,20);
        MinecraftForge.addGrassPlant(BlockRegistry.BlockFreezingFlower,0,20);

        GameRegistry.registerWorldGenerator(new WorldGenBlockAirCrystalOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockEarthCrystalOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockFireCrystalOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockWaterCrystalOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockFreezingFlower());
        GameRegistry.registerWorldGenerator(new WorldGenBlockBurningFlower());
        GameRegistry.registerWorldGenerator(new WorldGenBlockEnergyCrystalOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockZycrantianOre());
        GameRegistry.registerWorldGenerator(new WorldGenBlockGarnetOre());                 
        GameRegistry.registerWorldGenerator(new WorldGenBlockFalseBlock());

        GameRegistry.registerTileEntity(TileTCEnergySphere.class, "TileTCEnergySphere");

        GameRegistry.registerTileEntity(TileEnergizedBuildingBlocks.class, "TileEnergizedBuildingBlocks");

        GameRegistry.registerTileEntity(TileTestBlock.class, "TileTestBlock");

        GameRegistry.registerTileEntity(TileGenorator.class, "TileGenorator");

        GameRegistry.registerTileEntity(TileTCFurnace.class, "TileTCFurnace");

        GameRegistry.registerTileEntity(TileTCChargeBench.class, "TileTCChargeBench");

        GameRegistry.registerTileEntity(TileTCInfuser.class, "TileTCInfuser");

        GameRegistry.registerTileEntity(TileTCTeleporter.class, "TileTCTeleporter");

        GameRegistry.registerTileEntity(TileTCEnergyConstructor.class, "TileTCEnergyConstructor");

        GameRegistry.registerTileEntity(TileItemExtractor.class, "TileItemExtractor");

        GameRegistry.registerTileEntity(TilePersonalBlock.class, "TilePersonalBlock");

        GameRegistry.registerTileEntity(TileEnergySender.class, "TileEnergySender");

        GameRegistry.registerTileEntity(TilePlanter.class, "TilePlanter");
        
        NetworkRegistry.instance().registerGuiHandler(this, TechCraft.proxy);

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

        CraftRegistry.init();
        CraftRegistry.placeHolderRecipes();
        CraftRegistry.teiredCrafting();

        CraftRegistry.craftSmelting();

        if(includePowerRecipies)
            CraftRegistry.craftPower();

        if(includeArmorRecipies)
            CraftRegistry.craftTool_Armor();
    }

}