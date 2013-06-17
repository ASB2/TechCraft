package TechCraft.circuits;

import net.minecraft.item.ItemStack;

public interface ISimpleDataCircuit {

    boolean setType(ItemStack itemStack, int typeID);
    
    int getType(ItemStack itemStack);
    
    int getMaxiumTypes(ItemStack itemStack);

    boolean setStoredData(ItemStack itemStack, int blockOrItemID, int amount);
    
    int getStoredData(ItemStack itemStack);
    
    int getMaximumData(ItemStack itemStack);
}
