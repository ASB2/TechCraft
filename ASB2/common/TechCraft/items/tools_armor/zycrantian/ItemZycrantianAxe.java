package TechCraft.items.tools_armor.zycrantian;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import TechCraft.TechCraft;

public class ItemZycrantianAxe extends ItemAxe{

    public ItemZycrantianAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTechno);
        
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemZycrantianAxe");
    }

}
