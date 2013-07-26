package TechCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TechCraftCreativeTab extends net.minecraft.creativetab.CreativeTabs {
    
    String name;
    
    public TechCraftCreativeTab(int par1, String name) {
        super(par1, name);
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