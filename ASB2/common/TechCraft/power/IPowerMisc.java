package TechCraft.power;

import TechCraft.EnumColor;
import net.minecraftforge.common.ForgeDirection;

public interface IPowerMisc {

    /**
     * Get the orientation of the block
     * @return direction facing
     */
    ForgeDirection getOrientation();

    /**
     * Name of the block
     */
    String getName();

    /**
     * Get the position of the block
     */
    int[] getPosition();

    /**
     * Should the block render and be powered from this direction
     */
    boolean renderByDirection(ForgeDirection direction);

    /**
     * Used for markings. Does NOT refer to the texture color of the block
     */
    EnumColor getColorEnum();

    /**
     * Sets the color of the block
     */
    void setColor(EnumColor color);
    
    /**
     * Returns power provider class of the tile
     */
    PowerProvider getPowerProvider();
}
