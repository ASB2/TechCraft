package TechCraft.items.tools_armor.zycrantian;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import TechCraft.TechCraft;

public class ItemZycrantianBoots extends ItemArmor{

    public ItemZycrantianBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        setCreativeTab(TechCraft.tabTechno);

    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemZycrantianBoots");
    }    
}