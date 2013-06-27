package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TehCraftItemBlock extends ItemBlock {

    public TehCraftItemBlock(int par1) {
        super(par1);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) {
        info.add("From: TechCraft");
    }
}
