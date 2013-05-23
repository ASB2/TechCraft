package TechCraft.items.tools_armor.garnet;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import TechCraft.TechCraft;

public class ItemGarnetPickaxe extends ItemPickaxe{

    public ItemGarnetPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(TechCraft.tabTechno);
        
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemGarnetPickaxe");
    }
}
