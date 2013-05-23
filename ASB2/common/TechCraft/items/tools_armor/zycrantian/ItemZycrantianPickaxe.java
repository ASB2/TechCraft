package TechCraft.items.tools_armor.zycrantian;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import TechCraft.TechCraft;

public class ItemZycrantianPickaxe extends ItemPickaxe{

    public ItemZycrantianPickaxe(int itemID, EnumToolMaterial toolMaterial) {
        super(itemID, toolMaterial);
        setCreativeTab(TechCraft.tabTechno);

    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemZycrantianPickaxe");
    }
}