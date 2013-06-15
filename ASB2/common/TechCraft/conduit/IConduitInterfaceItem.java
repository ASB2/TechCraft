package TechCraft.conduit;

import net.minecraft.item.ItemStack;


public interface IConduitInterfaceItem  extends IConduitInterface {

    /**
     * If an item can be added to the specified slot
     */
    boolean canMoveItemToInventory(ItemStack itemStack, int slot, int amount);

    /**
     * Actually move and item into the specified slot
     */
    boolean moveItemToInventory(ItemStack itemStack, int slot, int amount);

    /**
     * If an item can be taken from the specified slot
     */
    boolean canTakeItemFromInventory(ItemStack itemStack, int slot, int amount);

    /**
     * Actually take an item from the specified slot
     */
    boolean takeItemFromInventory(ItemStack itemStack, int slot, int amount);
}
