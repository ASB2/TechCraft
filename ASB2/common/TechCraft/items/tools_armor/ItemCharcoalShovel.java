package TechCraft.items.tools_armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import TechCraft.TechCraft;

public class ItemCharcoalShovel extends ItemSpade {

    public ItemCharcoalShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTechno);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
             itemIcon = iconRegister.registerIcon("TechCraft:ItemCharcoalShovel");
    }

}
