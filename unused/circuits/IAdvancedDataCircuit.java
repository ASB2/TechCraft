package TechCraft.circuits;

import net.minecraft.item.ItemStack;

public interface IAdvancedDataCircuit {

    boolean setType(ItemStack itemStack, int blockOrItemID);

    int getType(ItemStack itemStack);

    int getMaxiumTypes(ItemStack itemStack, int blockOrItemID);

    boolean setStoredData(ItemStack itemStack, int blockOrItemID, int amount);
    int getStoredData(ItemStack itemStack, int blockOrItemID);

    int getMaximumData(ItemStack itemStack, int blockOrItemID);
}
