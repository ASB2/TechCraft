package TechCraft;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import TechCraft.items.ItemAirCrystalShard;
import TechCraft.items.ItemEarthCrystalShard;
import TechCraft.items.ItemEnergyCrystalShard;
import TechCraft.items.ItemFireCrystalShard;
import TechCraft.items.ItemGarnet;
import TechCraft.items.ItemTechMultiTool;
import TechCraft.items.ItemTechnoMagicReader;
import TechCraft.items.ItemTeleporter;
import TechCraft.items.ItemTestItem;
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
import TechCraft.items.runes.*;

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
    public static TechCraftItems ItemRuneTest;    
    public static TechCraftItems ItemExplosionRune;
    public static TechCraftItems ItemRealityDifferentiationDrive;
    
    public static void init() {

        ItemAirCrystalShard = new ItemAirCrystalShard(5001);
        ItemAirCrystalShard.setUnlocalizedName("ItemAirCrystalShard");
        LanguageRegistry.addName(ItemAirCrystalShard, "Air Crystal Shard");

        ItemEarthCrystalShard = new ItemEarthCrystalShard(5002);
        ItemEarthCrystalShard.setUnlocalizedName("ItemEarthCrystalShard");
        LanguageRegistry.addName(ItemEarthCrystalShard, "Earth Crystal Shard");

        ItemFireCrystalShard = new ItemFireCrystalShard(5003);
        ItemFireCrystalShard.setUnlocalizedName("ItemFireCrystalShard");
        LanguageRegistry.addName(ItemFireCrystalShard, "Fire Crystal Shard");

        ItemWaterCrystalShard = new ItemWaterCrystalShard(5004);
        ItemWaterCrystalShard.setUnlocalizedName("ItemWaterCrystalShard");
        LanguageRegistry.addName(ItemWaterCrystalShard, "Water Crystal Shard");

        ItemGarnet = new ItemGarnet(5005);
        LanguageRegistry.addName(ItemGarnet, "Garnet");

        ItemEnergyCrystalShard = new ItemEnergyCrystalShard(5006);
        ItemEnergyCrystalShard.setUnlocalizedName("ItemEnergyCrystalShard");
        LanguageRegistry.addName(ItemEnergyCrystalShard, "Energy Crystal Shard");

        ItemZycrantianIngot = new ItemZycrantianIngot(5007);
        ItemZycrantianIngot.setUnlocalizedName("ItemZycrantianIngot");
        LanguageRegistry.addName(ItemZycrantianIngot, "Zycrantian Ingot");
        
        ItemTestItem = new ItemTestItem(5008);
        ItemTestItem.setUnlocalizedName("ItemTestItem");
        LanguageRegistry.addName(ItemTestItem, "Test Item");
        
        ItemTechnoMagicReader = new ItemTechnoMagicReader(5009);
        ItemTechnoMagicReader.setUnlocalizedName("ItemTechnoMagicReader");
        LanguageRegistry.addName(ItemTechnoMagicReader, "TechnoMagic Reader");
        
        ItemTechMultiTool = new ItemTechMultiTool(5010);
        ItemTechMultiTool.setUnlocalizedName("ItemTechMultiTool");
        LanguageRegistry.addName(ItemTechMultiTool, "Techergy Multi-Tool");
        
        ItemTeleporter = new ItemTeleporter(5011);
        ItemTeleporter.setUnlocalizedName("ItemTeleporter");
        LanguageRegistry.addName(ItemTeleporter, "Teleporter");

        //Charcoal Items
        ItemCharcoalAxe = new ItemCharcoalAxe(5012, EnumToolMaterial.STONE);
        ItemCharcoalAxe.setUnlocalizedName("ItemCharcoalAxe");
        LanguageRegistry.addName(ItemCharcoalAxe, "Charcoal Axe");
        
        ItemCharcoalPickaxe = new ItemCharcoalPickaxe(5013, EnumToolMaterial.STONE);
        ItemCharcoalPickaxe.setUnlocalizedName("ItemCharcoalPickaxe");
        LanguageRegistry.addName(ItemCharcoalPickaxe, "Charcoal Pickaxe");
        
        ItemCharcoalShovel = new ItemCharcoalShovel(5014, EnumToolMaterial.STONE);
        ItemCharcoalShovel.setUnlocalizedName("ItemCharcoalShovel");
        LanguageRegistry.addName(ItemCharcoalShovel, "Charcoal Shovel");
        
        ItemCharcoalSword = new ItemCharcoalSword(5015, EnumToolMaterial.STONE);
        ItemCharcoalSword.setUnlocalizedName("ItemCharcoalSword");
        LanguageRegistry.addName(ItemCharcoalSword, "Charcoal Sword");
        
        //Zycrantian Items
        
        ItemZycrantianAxe = new ItemZycrantianAxe(5016, EnumToolMaterial.EMERALD);
        ItemZycrantianAxe.setUnlocalizedName("ItemZycrantianAxe");
        LanguageRegistry.addName(ItemZycrantianAxe, "Zycrantian Axe");
        
        ItemZycrantianPickaxe = new ItemZycrantianPickaxe(5017, EnumToolMaterial.EMERALD);
        ItemZycrantianPickaxe.setUnlocalizedName("ItemZycrantianPickaxe");
        LanguageRegistry.addName(ItemZycrantianPickaxe, "Zycrantian Pickaxe");
        
        ItemZycrantianShovel = new ItemZycrantianShovel(5018, EnumToolMaterial.EMERALD);
        ItemZycrantianShovel.setUnlocalizedName("ItemZycrantianShovel");
        LanguageRegistry.addName(ItemZycrantianShovel, "Zycrantian Shovel");
        
        ItemZycrantianSword = new ItemZycrantianSword(5019, EnumToolMaterial.EMERALD);
        ItemZycrantianSword.setUnlocalizedName("ItemZycrantianSword");
        LanguageRegistry.addName(ItemZycrantianSword, "Zycrantian Sword");
        
        ItemZycrantianHoe = new ItemZycrantianHoe(5020, EnumToolMaterial.EMERALD);
        ItemZycrantianHoe.setUnlocalizedName("ItemZycrantianHoe");
        LanguageRegistry.addName(ItemZycrantianHoe, "Zycrantian Hoe");
        
        //Zycrantian Armor
        
        ItemZycrantianHelmet = new ItemZycrantianHelmet(5021, EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianHelmet"), 0);
        ItemZycrantianHelmet.setUnlocalizedName("ItemZycrantianHelmet");
        LanguageRegistry.addName(ItemZycrantianHelmet, "Zycrantian Helmet");
        
        ItemZycrantianChestPlate = new ItemZycrantianChestPlate(5022, EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianChestPlate"), 1);
        ItemZycrantianChestPlate.setUnlocalizedName("ItemZycrantianChestPlate");
        LanguageRegistry.addName(ItemZycrantianChestPlate, "Zycrantian Chestplate");
        
        ItemZycrantianPants = new ItemZycrantianPants(5023, EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianPants"), 2);
        ItemZycrantianPants.setUnlocalizedName("ItemZycrantianPants");
        LanguageRegistry.addName(ItemZycrantianPants, "Zycrantian Pants");
        
        ItemZycrantianBoots = new ItemZycrantianBoots(5024, EnumArmorMaterial.DIAMOND, CommonProxy.addArmor("ItemZycrantianBoots"), 3);
        ItemZycrantianBoots.setUnlocalizedName("ItemZycrantianBoots");
        LanguageRegistry.addName(ItemZycrantianBoots, "Zycrantian Boots");
        
        
        //Garnet Items
        
        ItemGarnetAxe = new ItemGarnetAxe(5025, EnumToolMaterial.IRON);
        ItemGarnetAxe.setUnlocalizedName("ItemGarnetAxe");
        LanguageRegistry.addName(ItemGarnetAxe, "Garnet Axe");
        
        ItemGarnetPickaxe = new ItemGarnetPickaxe(5026, EnumToolMaterial.IRON);
        ItemGarnetPickaxe.setUnlocalizedName("ItemGarnetPickaxe");
        LanguageRegistry.addName(ItemGarnetPickaxe, "Garnet Pickaxe");
        
        ItemGarnetShovel = new ItemGarnetShovel(5027, EnumToolMaterial.IRON);
        ItemGarnetShovel.setUnlocalizedName("ItemGarnetShovel");
        LanguageRegistry.addName(ItemGarnetShovel, "Garnet Shovel");
        
        ItemGarnetSword = new ItemGarnetSword(5028, EnumToolMaterial.IRON);
        ItemGarnetSword.setUnlocalizedName("ItemGarnetSword");
        LanguageRegistry.addName(ItemGarnetSword, "Garnet Sword");
        
        ItemGarnetHoe = new ItemGarnetHoe(5029, EnumToolMaterial.IRON);
        ItemGarnetHoe.setUnlocalizedName("ItemGarnetHoe");
        LanguageRegistry.addName(ItemGarnetHoe, "Garnet Hoe");
        
        //Regular
        
        ItemEnergyBlob = new ItemEnergyBlob(5030);
        ItemEnergyBlob.setUnlocalizedName("ItemEnergyBlob");
        LanguageRegistry.addName(ItemEnergyBlob, "TC Energy Blob");
        
        ItemRuneTest = new ItemRuneTest(5031);
        ItemRuneTest.setUnlocalizedName("ItemRuneTest");
        LanguageRegistry.addName(ItemRuneTest, "Test Rune");
        
        ItemExplosionRune = new ItemExplosionRune(5032);
        ItemExplosionRune.setUnlocalizedName("ItemExplosionRune");
        LanguageRegistry.addName(ItemExplosionRune, "Explosion Rune");
        
        ItemRealityDifferentiationDrive = new ItemExplosionRune(5033);
        ItemRealityDifferentiationDrive.setUnlocalizedName("ItemRealityDifferentiationDrive");
        LanguageRegistry.addName(ItemRealityDifferentiationDrive, "Reality Differentiation Drive");
    }

}
