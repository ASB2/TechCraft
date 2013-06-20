package TechCraft.conduit;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;


public interface IConduitInterfaceItem  extends IConduitInterface {

    /**
     * Get the inventories this interface wiil manage
     */
    IInventory getAccessibleInventoryByDirection(ForgeDirection direction); 

    /**
     * Actually move and item into the specified slot
     * @return What is left of the itemstack
     */
    ItemStack moveItemToInventory(ItemStack itemStack, int slot, int amount);

    /**
     * Actually take an item from the specified slot
     * @return What is left of the itemstack
     */
    ItemStack takeItemFromInventory(ItemStack itemStack, int slot, int amount);
}
