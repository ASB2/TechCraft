package TechCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TechCraftCreativeTab extends net.minecraft.creativetab.CreativeTabs {
    
    String name;
    
    public TechCraftCreativeTab(int par1, String par2Str, String name) {
        super(par1, par2Str);
        this.name = name;
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
        return name;
    }
}