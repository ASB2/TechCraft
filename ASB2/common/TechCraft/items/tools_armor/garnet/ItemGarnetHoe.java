package TechCraft.items.tools_armor.garnet;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import TechCraft.TechCraft;

public class ItemGarnetHoe extends ItemHoe{

    public ItemGarnetHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTCItems);
        
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
             itemIcon = iconRegister.registerIcon("TechCraft:ItemGarnetHoe");
    }
}
