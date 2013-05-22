package TechCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TechCraftCreativeTab extends net.minecraft.creativetab.CreativeTabs {
    
    public TechCraftCreativeTab(int par1, String par2Str) {
        super(par1, par2Str);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() //The item it displays for your tab
    {
        return ItemRegistry.ItemEnergyCrystalShard.itemID;
    }
    
    @Override
    public String getTranslatedTabLabel()
    {
        return "TechnoCraft"; //The name of the tab ingame
    }
}