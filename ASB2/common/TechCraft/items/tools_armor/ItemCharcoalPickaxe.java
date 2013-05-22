package TechCraft.items.tools_armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import TechCraft.TechCraft;

public class ItemCharcoalPickaxe extends ItemPickaxe{

    public ItemCharcoalPickaxe(int itemID, EnumToolMaterial toolMaterial) {
        super(itemID, toolMaterial);
        setCreativeTab(TechCraft.tabTechno);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
             itemIcon = iconRegister.registerIcon("TechCraft:ItemCharcoalPickaxe");
    }
}
