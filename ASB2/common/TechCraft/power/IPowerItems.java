package TechCraft.power;

import net.minecraft.item.ItemStack;

public interface IPowerItems {

    int getPowerStored(ItemStack item);
    int getPowerMax(ItemStack item);
    
    void usePower(int PowerUsed,ItemStack item);
    void gainPower(int PowerGained, ItemStack item);
    
    String getName();

}
