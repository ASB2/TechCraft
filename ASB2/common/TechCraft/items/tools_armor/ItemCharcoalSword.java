package TechCraft.items.tools_armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import TechCraft.TechCraft;

public class ItemCharcoalSword extends ItemSword{

    public ItemCharcoalSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTCItems);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
             itemIcon = iconRegister.registerIcon("TechCraft:ItemCharcoalSword");
    }

}
