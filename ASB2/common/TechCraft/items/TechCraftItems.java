package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TechCraft.TechCraft;

public class TechCraftItems extends Item {
    
    public TechCraftItems(int par1) {
        super(par1);
        this.setCreativeTab(TechCraft.tabTechno);
        
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        info.add("From: TechCraft");
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTestItem");
    }


}
