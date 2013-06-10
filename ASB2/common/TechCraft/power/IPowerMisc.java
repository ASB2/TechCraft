package TechCraft.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerMisc {
    
    ForgeDirection getOrientation();
    
    int getPowerStored();
    int getPowerMax();

    EnumPowerClass getPowerClass();

    boolean recievePower();
    boolean outputPower();

    boolean canGainPower(int power);
    boolean canUsePower(int power);
    
    boolean requestingPower();
    boolean outputtingPower();
    
    int powerOutput();
    int powerInput();

    String getName();

    boolean usePower(int PowerUsed);
    boolean gainPower(int PowerGained);

    int[] getPosition();
    
    boolean powerByDirection(ForgeDirection direction);
}
