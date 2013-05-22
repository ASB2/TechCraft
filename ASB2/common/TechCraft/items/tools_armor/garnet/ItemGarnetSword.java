package TechCraft.items.tools_armor.garnet;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import TechCraft.TechCraft;

public class ItemGarnetSword extends ItemSword{

    public ItemGarnetSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTechno);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
             itemIcon = iconRegister.registerIcon("TechCraft:ItemGarnetSword");
    }

} 