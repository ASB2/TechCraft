package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBlankCircuit extends TechCraftItems {

    public ItemBlankCircuit(int par1) {
        super(par1);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        super.addInformation(itemStack, player, info, var1);
        info.add("Basics of Electronics");
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        
        itemIcon = iconRegister.registerIcon("TechCraft:ItemCircuitBlank");
    }
}
