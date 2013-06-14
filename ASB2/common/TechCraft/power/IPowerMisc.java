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
     * Get the amount of power stored in the block
     * @return Integer amount of power stored
     */
    int getPowerStored();
    
    /**
     * Get maximum power capacity of the block
     */
    int getPowerMax();

    /**
     * Get the power class of the block
     */
    EnumPowerClass getPowerClass();

    /**
     * If the block is a power sink
     */
    boolean recievePower();
    
    /**
     * If the block is a power source
     */
    boolean outputPower();

    /**
     * If the block can gain power
     */
    boolean canGainPower(int power);
    
    /**
     * If the block can use power
     */
    boolean canUsePower(int power);

    /**
     * If the block is requesting power from this direction
     * @param direction
     */
    boolean requestingPower(ForgeDirection direction);
    
    /**
     * If this block is sending power to that direction
     * @param direction
     */
    boolean outputtingPower(ForgeDirection direction);

    /**
     * The amount of output this block can output per tick
     */
    int powerOutput();
    
    /**
     * The amount of power this block can take in per tick
     */
    int powerInput();

    /**
     * Name of the block
     */
    String getName();

    /**
     * Tells the block to gain the amount of power passed
     */
    boolean usePower(int PowerUsed, ForgeDirection direction);
    
    /**
     * Tells the block the use the amount of power passed
     */
    boolean gainPower(int PowerGained, ForgeDirection direction);

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
}
