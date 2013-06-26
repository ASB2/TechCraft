package TechCraft.items.tools_armor.garnet;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import TechCraft.TechCraft;

public class ItemGarnetAxe extends ItemAxe {

    public ItemGarnetAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTCItems);
        
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemGarnetAxe");
    }
}
