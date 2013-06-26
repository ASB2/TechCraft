package TechCraft.items.tools_armor.zycrantian;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import TechCraft.TechCraft;

public class ItemZycrantianSword extends ItemSword{

    public ItemZycrantianSword(int itemID, EnumToolMaterial toolMaterial) {
        super(itemID, toolMaterial);
        setCreativeTab(TechCraft.tabTCItems);

    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemZycrantianSword");
    }
}