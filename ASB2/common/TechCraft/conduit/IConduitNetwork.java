package TechCraft.conduit;

import net.minecraftforge.common.ForgeDirection;
import TechCraft.EnumColor;

public interface IConduitNetwork {

    /**
     * Should conduits render at the specified direction.
     * @param Direction
     */
    boolean renderByDirection(ForgeDirection direction);

    /**
     * Conduit Network this interface belongs to.
     */
    ConduitNetwork getNetwork();

    /**
     * Overrides the conduit network of this interface with the network specified
     * @param New network
     */
    void overrideNetwork(ConduitNetwork network);
    
    /**
     * Used for markings. Does NOT refer to the texture color of the block
     */
    EnumColor getColorEnum();

    /**
     * Sets the color of the block
     */
    void setColor(EnumColor color);
}