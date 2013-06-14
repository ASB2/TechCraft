package TechCraft.power;

import net.minecraft.item.ItemStack;

public interface IPowerItems {

    int getPowerStored(ItemStack item);
    int getPowerMax(ItemStack item);
    
    boolean usePower(int PowerUsed,ItemStack item);
    boolean gainPower(int PowerGained, ItemStack item);
    
    boolean canUsePower(int PowerUsed, ItemStack item);
    boolean canGainPower(int PowerGained, ItemStack item);
    
    String getName();

}
