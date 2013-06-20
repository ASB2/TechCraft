package TechCraft.circuits;

import net.minecraft.item.ItemStack;

public interface ISimpleDataCircuit {

    boolean setType(ItemStack itemStack, int typeID);
    
    int getType(ItemStack itemStack);
    
    int getMaxTypes(ItemStack itemStack);

    boolean setStoredData(ItemStack itemStack, int amount, boolean adding);
    
    int getStoredData(ItemStack itemStack);
    
    int getMaximumData(ItemStack itemStack);
}
