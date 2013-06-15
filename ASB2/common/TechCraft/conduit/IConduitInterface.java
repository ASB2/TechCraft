package TechCraft.conduit;

import TechCraft.EnumColor;
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
     * Used for markings. Does NOT refer to the texture color of the block
     */
    EnumColor getColorEnum();

    /**
     * Sets the color of the block
     */
    void setColor(EnumColor color);
}