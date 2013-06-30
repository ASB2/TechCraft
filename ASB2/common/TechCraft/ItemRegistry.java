package TechCraft;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.Configuration;
import TechCraft.items.ItemAirCrystalShard;
import TechCraft.items.ItemBasicDestructionCatalyst;
import TechCraft.items.ItemCrystalCasing;
import TechCraft.items.ItemCrystillineShard;
import TechCraft.items.ItemEarthCrystalShard;
import TechCraft.items.ItemEnergyCrystalShard;
import TechCraft.items.ItemEnhancedDestructionCatalyst;
import TechCraft.items.ItemFireCrystalShard;
import TechCraft.items.ItemGarnet;
import TechCraft.items.ItemLifeStealingBludgeoningStick;
import TechCraft.items.ItemLinker;
import TechCraft.items.ItemOmniTool;
import TechCraft.items.ItemTCMultiTool;
import TechCraft.items.ItemTechnoMagicReader;
import TechCraft.items.ItemTeleporter;
import TechCraft.items.ItemTestItem;
import TechCraft.items.ItemTradeStick;
import TechCraft.items.ItemWaterCrystalShard;
import TechCraft.items.ItemZycrantianIngot;
import TechCraft.items.TechCraftItems;
import TechCraft.items.technogery.ItemEnergyBlob;
import TechCraft.items.tools_armor.ItemCharcoalAxe;
import TechCraft.items.tools_armor.ItemCharcoalPickaxe;
import TechCraft.items.tools_armor.ItemCharcoalShovel;
import TechCraft.items.tools_armor.ItemCharcoalSword;
import TechCraft.items.tools_armor.garnet.ItemGarnetAxe;
import TechCraft.items.tools_armor.garnet.ItemGarnetHoe;
import TechCraft.items.tools_armor.garnet.ItemGarnetPickaxe;
import TechCraft.items.tools_armor.garnet.ItemGarnetShovel;
import TechCraft.items.tools_armor.garnet.ItemGarnetSword;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianAxe;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianBoots;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianChestPlate;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianHelmet;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianHoe;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianPants;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianPickaxe;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianShovel;
import TechCraft.items.tools_armor.zycrantian.ItemZycrantianSword;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegistry {

    public static TechCraftItems ItemAirCrystalShard;
    public static TechCraftItems ItemEarthCrystalShard;
    public static TechCraftItems ItemFireCrystalShard;
    public static TechCraftItems ItemWaterCrystalShard;
    public static TechCraftItems ItemGarnet;    
    public static TechCraftItems ItemEnergyCrystalShard;
    public static TechCraftItems ItemZycrantianIngot;

    public static TechCraftItems ItemTestItem;
    public static TechCraftItems ItemTechnoMagicReader;
    public static TechCraftItems ItemTechMultiTool;
    public static TechCraftItems ItemTeleporter;

    public static ItemAxe ItemCharcoalAxe;
    public static ItemPickaxe ItemCharcoalPickaxe;
    public static ItemSpade ItemCharcoalShovel;
    public static ItemSword ItemCharcoalSword;

    public static ItemAxe ItemZycrantianAxe;
    public static ItemPickaxe ItemZycrantianPickaxe;
    public static ItemSpade ItemZycrantianShovel;
    public static ItemSword ItemZycrantianSword;
    public static ItemHoe ItemZycrantianHoe;

    public static ItemArmor ItemZycrantianHelmet;
    public static ItemArmor ItemZycrantianChestPlate;
    public static ItemArmor ItemZycrantianPants;
    public static ItemArmor ItemZycrantianBoots;

    public static ItemAxe ItemGarnetAxe;
    public static ItemPickaxe ItemGarnetPickaxe;
    public static ItemSpade ItemGarnetShovel;
    public static ItemSword ItemGarnetSword;
    public static ItemHoe ItemGarnetHoe;

    public static TechCraftItems ItemEnergyBlob;
    public static TechCraftItems ItemRealityDifferentiationDrive;
    public static TechCraftItems ItemLinker;
    public static TechCraftItems ItemTeleportModule;
    public static TechCraftItems ItemBasicDestructionCatalyst;
    public static TechCraftItems ItemEnhancedDestructionCatalyst;
    public static TechCraftItems ItemTradeStick;
    public static TechCraftItems ItemOmniTool;
    public static TechCraftItems ItemLifeStealingBludgeoningStick;    
    public static TechCraftItems ItemBlankCircuit;
    public static TechCraftItems ItemDataCircuit;
    public static TechCraftItems ItemCrystalCasing;
    public static TechCraftItems ItemCrystillineShard;

    private static int id = 5000;

    public static void init(Configuration config) {

        ItemAirCrystalShard = new ItemAirCrystalShard(config.getItem("ItemAirCrystalShard", ItemRegistry.getNextBaseID()).getInt());
        ItemAirCrystalShard.setUnlocalizedName("ASB2_ItemAirCrystalShard");
        LanguageRegistry.addName(ItemAirCrystalShard, "Air Crystal Shard");

        ItemEarthCrystalShard = new ItemEarthCrystalShard(config.getItem("ItemEarthCrystalShard", ItemRegistry.getNextBaseID()).getInt());
        ItemEarthCrystalShard.setUnlocalizedName("ASB2_ItemEarthCrystalShard");
        LanguageRegistry.addName(ItemEarthCrystalShard, "Earth Crystal Shard");

        ItemFireCrystalShard = new ItemFireCrystalShard(config.getItem("ItemFireCrystalShard", ItemRegistry.getNextBaseID()).getInt());
        ItemFireCrystalShard.setUnlocalizedName("ASB2_ItemFireCrystalShard");
        LanguageRegistry.addName(ItemFireCrystalShard, "Fire Crystal Shard");

        ItemWaterCrystalShard = new ItemWaterCrystalShard(config.getItem("ItemWaterCrystalShard", ItemRegistry.getNextBaseID()).getInt());
        ItemWaterCrystalShard.setUnlocalizedName("ASB2_ItemWaterCrystalShard");
        LanguageRegistry.addName(ItemWaterCrystalShard, "Water Crystal Shard");

        ItemGarnet = new ItemGarnet(config.getItem("ItemGarnet", ItemRegistry.getNextBaseID()).getInt());
        ItemGarnet.setUnlocalizedName("ASB2_ItemGarnet");
        LanguageRegistry.addName(ItemGarnet, "Garnet");

        ItemEnergyCrystalShard = new ItemEnergyCrystalShard(config.getItem("ItemEnergyCrystalShard", ItemRegistry.getNextBaseID()).getInt());
        ItemEnergyCrystalShard.setUnlocalizedName("ASB2_ItemEnergyCrystalShard");
        LanguageRegistry.addName(ItemEnergyCrystalShard, "Energy Crystal Shard");

        ItemZycrantianIngot = new ItemZycrantianIngot(config.getItem("ItemZycrantianIngot", ItemRegistry.getNextBaseID()).getInt());
        ItemZycrantianIngot.setUnlocalizedName("ASB2_ItemZycrantianIngot");
        LanguageRegistry.addName(ItemZycrantianIngot, "Zycrantian Ingot");

        ItemTestItem = new ItemTestItem(config.getItem("ItemTestItem", ItemRegistry.getNextBaseID()).getInt());
        ItemTestItem.setUnlocalizedName("ItemTestItem");
        LanguageRegistry.addName(ItemTestItem, "Test Item");

        ItemTechnoMagicReader = new ItemTechnoMagicReader(config.getItem("ItemTechnoMagicReader", ItemRegistry.getNextBaseID()).getInt());
        ItemTechnoMagicReader.setUnlocalizedName("ASB2_ItemTechnoMagicReader");
        LanguageRegistry.addName(ItemTechnoMagicReader, "TechnoMagic Reader");

        ItemTechMultiTool = new ItemTCMultiTool(config.getItem("ItemTechMultiTool", ItemRegistry.getNextBaseID()).getInt());
        ItemTechMultiTool.setUnlocalizedName("ASB2_ItemTechMultiTool");
        LanguageRegistry.addName(ItemTechMultiTool, "Techergy Multi-Tool");

        ItemTeleporter = new ItemTeleporter(config.getItem("ItemTeleporter", ItemRegistry.getNextBaseID()).getInt());
        ItemTeleporter.setUnlocalizedName("ASB2_ItemTeleporter");
        LanguageRegistry.addName(ItemTeleporter, "Teleporter");

        //Charcoal Items
        ItemCharcoalAxe = new ItemCharcoalAxe(config.getItem("ItemCharcoalAxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.STONE);
        ItemCharcoalAxe.setUnlocalizedName("ASB2_ItemCharcoalAxe");
        LanguageRegistry.addName(ItemCharcoalAxe, "Charcoal Axe");

        ItemCharcoalPickaxe = new ItemCharcoalPickaxe(config.getItem("ItemCharcoalPickaxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.STONE);
        ItemCharcoalPickaxe.setUnlocalizedName("ASB2_ItemCharcoalPickaxe");
        LanguageRegistry.addName(ItemCharcoalPickaxe, "Charcoal Pickaxe");

        ItemCharcoalShovel = new ItemCharcoalShovel(config.getItem("ItemCharcoalShovel", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.STONE);
        ItemCharcoalShovel.setUnlocalizedName("ASB2_ItemCharcoalShovel");
        LanguageRegistry.addName(ItemCharcoalShovel, "Charcoal Shovel");

        ItemCharcoalSword = new ItemCharcoalSword(config.getItem("ItemCharcoalSword", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.STONE);
        ItemCharcoalSword.setUnlocalizedName("ASB2_ItemCharcoalSword");
        LanguageRegistry.addName(ItemCharcoalSword, "Charcoal Sword");

        //Zycrantian Items

        ItemZycrantianAxe = new ItemZycrantianAxe(config.getItem("ItemZycrantianAxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.EMERALD);
        ItemZycrantianAxe.setUnlocalizedName("ASB2_ItemZycrantianAxe");
        LanguageRegistry.addName(ItemZycrantianAxe, "Zycrantian Axe");

        ItemZycrantianPickaxe = new ItemZycrantianPickaxe(config.getItem("ItemZycrantianPickaxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.EMERALD);
        ItemZycrantianPickaxe.setUnlocalizedName("ASB2_ItemZycrantianPickaxe");
        LanguageRegistry.addName(ItemZycrantianPickaxe, "Zycrantian Pickaxe");

        ItemZycrantianShovel = new ItemZycrantianShovel(config.getItem("ItemZycrantianShovel", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.EMERALD);
        ItemZycrantianShovel.setUnlocalizedName("ASB2_ItemZycrantianShovel");
        LanguageRegistry.addName(ItemZycrantianShovel, "Zycrantian Shovel");

        ItemZycrantianSword = new ItemZycrantianSword(config.getItem("ItemZycrantianSword", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.EMERALD);
        ItemZycrantianSword.setUnlocalizedName("ASB2_ItemZycrantianSword");
        LanguageRegistry.addName(ItemZycrantianSword, "Zycrantian Sword");

        ItemZycrantianHoe = new ItemZycrantianHoe(config.getItem("ItemZycrantianHoe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.EMERALD);
        ItemZycrantianHoe.setUnlocalizedName("ASB2_ItemZycrantianHoe");
        LanguageRegistry.addName(ItemZycrantianHoe, "Zycrantian Hoe");

        //Zycrantian Armor

        ItemZycrantianHelmet = new ItemZycrantianHelmet(config.getItem("ItemZycrantianHelmet", ItemRegistry.getNextBaseID()).getInt(), EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianHelmet"), 0);
        ItemZycrantianHelmet.setUnlocalizedName("ASB2_ItemZycrantianHelmet");
        LanguageRegistry.addName(ItemZycrantianHelmet, "Zycrantian Helmet");

        ItemZycrantianChestPlate = new ItemZycrantianChestPlate(config.getItem("ItemZycrantianChestPlate", ItemRegistry.getNextBaseID()).getInt(), EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianChestPlate"), 1);
        ItemZycrantianChestPlate.setUnlocalizedName("ASB2_ItemZycrantianChestPlate");
        LanguageRegistry.addName(ItemZycrantianChestPlate, "Zycrantian Chestplate");

        ItemZycrantianPants = new ItemZycrantianPants(config.getItem("ItemZycrantianPants", ItemRegistry.getNextBaseID()).getInt(), EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianPants"), 2);
        ItemZycrantianPants.setUnlocalizedName("ASB2_ItemZycrantianPants");
        LanguageRegistry.addName(ItemZycrantianPants, "Zycrantian Pants");

        ItemZycrantianBoots = new ItemZycrantianBoots(config.getItem("ItemZycrantianBoots", ItemRegistry.getNextBaseID()).getInt(), EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianBoots"), 3);
        ItemZycrantianBoots.setUnlocalizedName("ASB2_ItemZycrantianBoots");
        LanguageRegistry.addName(ItemZycrantianBoots, "Zycrantian Boots");


        //Garnet Items

        ItemGarnetAxe = new ItemGarnetAxe(config.getItem("ItemGarnetAxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.IRON);
        ItemGarnetAxe.setUnlocalizedName("ASB2_ItemGarnetAxe");
        LanguageRegistry.addName(ItemGarnetAxe, "Garnet Axe");

        ItemGarnetPickaxe = new ItemGarnetPickaxe(config.getItem("ItemGarnetPickaxe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.IRON);
        ItemGarnetPickaxe.setUnlocalizedName("ASB2_ItemGarnetPickaxe");
        LanguageRegistry.addName(ItemGarnetPickaxe, "Garnet Pickaxe");

        ItemGarnetShovel = new ItemGarnetShovel(config.getItem("ItemGarnetShovel", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.IRON);
        ItemGarnetShovel.setUnlocalizedName("ASB2_ItemGarnetShovel");
        LanguageRegistry.addName(ItemGarnetShovel, "Garnet Shovel");

        ItemGarnetSword = new ItemGarnetSword(config.getItem("ItemGarnetSword", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.IRON);
        ItemGarnetSword.setUnlocalizedName("ASB2_ItemGarnetSword");
        LanguageRegistry.addName(ItemGarnetSword, "Garnet Sword");

        ItemGarnetHoe = new ItemGarnetHoe(config.getItem("ItemGarnetHoe", ItemRegistry.getNextBaseID()).getInt(), EnumToolMaterial.IRON);
        ItemGarnetHoe.setUnlocalizedName("ASB2_ItemGarnetHoe");
        LanguageRegistry.addName(ItemGarnetHoe, "Garnet Hoe");

        //Regular

        ItemEnergyBlob = new ItemEnergyBlob(config.getItem("ItemEnergyBlob", ItemRegistry.getNextBaseID()).getInt());
        ItemEnergyBlob.setUnlocalizedName("ASB2_ItemEnergyBlob");
        LanguageRegistry.addName(ItemEnergyBlob, "TC Energy Blob");

        ItemRealityDifferentiationDrive = new TechCraftItems(config.getItem("ItemRealityDifferentiationDrive", ItemRegistry.getNextBaseID()).getInt());
        ItemRealityDifferentiationDrive.setUnlocalizedName("ASB2_ItemRealityDifferentiationDrive");
        LanguageRegistry.addName(ItemRealityDifferentiationDrive, "Reality Confabulator");

        ItemLinker = new ItemLinker(config.getItem("ItemLinker", ItemRegistry.getNextBaseID()).getInt());
        ItemLinker.setUnlocalizedName("ASB2_ItemLinker");
        LanguageRegistry.addName(ItemLinker, "TC Linker");

        ItemTeleportModule = new TechCraftItems(config.getItem("ItemTeleportModule", ItemRegistry.getNextBaseID()).getInt());
        ItemTeleportModule.setUnlocalizedName("ASB2_ItemTeleportModule");
        LanguageRegistry.addName(ItemTeleportModule, "Teleportation Module");

        ItemBasicDestructionCatalyst = new ItemBasicDestructionCatalyst(config.getItem("ItemContritioSimplexCatalyst", ItemRegistry.getNextBaseID()).getInt());
        ItemBasicDestructionCatalyst.setUnlocalizedName("ASB2_ItemBasicDestructionCatalyst");
        LanguageRegistry.addName(ItemBasicDestructionCatalyst, "Contritio Simplex Catalyst");

        ItemEnhancedDestructionCatalyst = new ItemEnhancedDestructionCatalyst(config.getItem("ItemContritioConsecteturCatalyst", ItemRegistry.getNextBaseID()).getInt());
        ItemEnhancedDestructionCatalyst.setUnlocalizedName("ASB2_ItemEnhancedDestructionCatalyst");
        LanguageRegistry.addName(ItemEnhancedDestructionCatalyst, "Contritio Consectetur Catalyst");

        ItemTradeStick = new ItemTradeStick(config.getItem("ItemTradeStick", ItemRegistry.getNextBaseID()).getInt());
        ItemTradeStick.setUnlocalizedName("ASB2_ItemTradeStick");
        LanguageRegistry.addName(ItemTradeStick, "Trade Stick");

        ItemOmniTool = new ItemOmniTool(config.getItem("ItemOmniTool", ItemRegistry.getNextBaseID()).getInt());
        ItemOmniTool.setUnlocalizedName("ASB2_ItemOmniTool");
        LanguageRegistry.addName(ItemOmniTool, "Omni-Tool");

        ItemLifeStealingBludgeoningStick = new ItemLifeStealingBludgeoningStick(config.getItem("ItemLifeStealingBludgeoningStick", ItemRegistry.getNextBaseID()).getInt());
        ItemLifeStealingBludgeoningStick.setUnlocalizedName("ASB2_ItemLifeStealingBludgeoningStick");
        LanguageRegistry.addName(ItemLifeStealingBludgeoningStick, "Life Stealing Bludgeoning Stick");

        ItemCrystalCasing = new ItemCrystalCasing(config.getItem("ItemCrystalCasing", ItemRegistry.getNextBaseID()).getInt());
        ItemCrystalCasing.setUnlocalizedName("ASB2_ItemCrystalCasing");
        LanguageRegistry.addName(ItemCrystalCasing, "Crystal Casing");
        
        ItemCrystillineShard = new ItemCrystillineShard(config.getItem("ItemCrystillineShard", ItemRegistry.getNextBaseID()).getInt());
        ItemCrystillineShard.setUnlocalizedName("ASB2_ItemCrystillineShard");
        LanguageRegistry.addName(ItemCrystillineShard, "Crystilline Shard");
    }

    public static int getNextBaseID() {

        return id++;
    }
}
