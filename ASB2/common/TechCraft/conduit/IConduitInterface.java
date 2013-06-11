package TechCraft.conduit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public interface IConduitInterface {

    /**
     * Returns the type of conduit interface of this object.
     */
    ConduitInterfaceType getInterfaceType();

    /**
     * Should conduits render at the specified direction.
     */
    boolean renderByDirection(ForgeDirection direction);

    /**
     * Conduit Network this interface belongs to.
     */
    ConduitNetwork getNetwork();

    /**
     * Overrides the conduit network of this interface with the network specified
     */
    void overrideNetwork(ConduitNetwork network);

    /**
     * Determines if the interface is requesting something from the network or outputting into the network
     */
    boolean importingToNetwork();

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