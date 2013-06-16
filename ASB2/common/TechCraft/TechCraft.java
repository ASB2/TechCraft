package TechCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import TechCraft.blocks.conduitInterface.items.TileItemConduitInterface;
import TechCraft.blocks.item_transfer.item_SenderReciever.TileItemReciever;
import TechCraft.blocks.item_transfer.item_SenderReciever.TileItemSender;
import TechCraft.blocks.item_transfer.tcItemSorter.TileItemSorter;
import TechCraft.blocks.tanks.TileTCTank;
import TechCraft.blocks.tcConduits.tcItemConduits.*;
import TechCraft.blocks.tcRunes.TileBasicRune;
import TechCraft.blocks.tcToolManager.TileToolManager;
import TechCraft.blocks.technogery.TileMagiciansBuildingBlocks;
import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.blocks.technogery.tcFarms.BasicFarm.TileBasicFarm;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFocus.TileTechnogryFocus;
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
import TechCraft.blocks.tcPersonalBlocks.*;

@Mod(modid = TechCraft.modid, name = "ASB2's TechCraft", version = "Not a Full Release Yet")

@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels={TechCraftPacketBase.CHANNEL}, packetHandler = TechCraftPacketHandler.class)

public class TechCraft {

    public static final String modid = "ASB2_TechCraft";

    @Instance(TechCraft.modid)

    public static TechCraft instance;

    @SidedProxy(clientSide="TechCraft.ClientProxy", serverSide="TechCraft.CommonProxy")

    public static CommonProxy proxy;

    public static CreativeTabs tabTechno = new TechCraftCreativeTab(CreativeTabs.getNextID(),"TechnoCraft");

    public static boolean includePowerRecipies = false;
    public static boolean includeArmorRecipies = true;
    public static boolean includeRuneRecipies = false;
    public static boolean modCreatorAndHelperPerks = false;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        ItemRegistry.init(config);

        BlockRegistry.init(config);

        CraftRegistry.init();
        CraftRegistry.craftSmelting();

        if(includePowerRecipies)
            CraftRegistry.craftPower();

        if(includeArmorRecipies)
            CraftRegistry.craftTool_Armor();

        if(includePowerRecipies)
            CraftRegistry.craftRunes();

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

        GameRegistry.registerTileEntity(TileTechnogryFocus.class, "TileTechnogryFocus");

        GameRegistry.registerTileEntity(TileMagiciansBuildingBlocks.class, "TileMagiciansBuildingBlocks");

        GameRegistry.registerTileEntity(TileTestBlock.class, "TileTestBlock");

        GameRegistry.registerTileEntity(TileBasicFarm.class, "TileBasicFarm");

        GameRegistry.registerTileEntity(TileGenorator.class, "TileGenorator");

        GameRegistry.registerTileEntity(TileTCFurnace.class, "TileTCFurnace");

        GameRegistry.registerTileEntity(TileTCChargeBench.class, "TileTCChargeBench");

        GameRegistry.registerTileEntity(TileBasicRune.class, "TileBasicRune");

        GameRegistry.registerTileEntity(TileTCInfuser.class, "TileTCInfuser");

        GameRegistry.registerTileEntity(TileTCTeleporter.class, "TileTCTeleporter");

        GameRegistry.registerTileEntity(TileTCTank.class, "TileTCTank");

        GameRegistry.registerTileEntity(TileItemReciever.class, "TileItemReciever");

        GameRegistry.registerTileEntity(TileItemSender.class, "TileItemSender");

        GameRegistry.registerTileEntity(TileToolManager.class, "TileToolManager");

        GameRegistry.registerTileEntity(TileTCEnergyConstructor.class, "TileTCEnergyConstructor");

        GameRegistry.registerTileEntity(TileItemSorter.class, "TileItemSorter");

        GameRegistry.registerTileEntity(TileItemConduitInterface.class, "TileItemConduitInterface");

        GameRegistry.registerTileEntity(TileTCItemConduit.class, "TileTCItemConduit");

        GameRegistry.registerTileEntity(TilePersonalBlock.class, "TilePersonalBlock");

        NetworkRegistry.instance().registerGuiHandler(this, TechCraft.proxy);

    }



    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
    }

}