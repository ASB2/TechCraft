package TechCraft.power;

public interface IPowerMisc {

    int getPowerStored();
    int getPowerMax();

    EnumPowerClass getPowerClass();

    boolean recievePower();
    boolean outputPower();

    boolean requestingPower();
    boolean outputtingPower();
    
    int powerOutput();
    int powerInput();

    String getName();

    boolean usePower(int PowerUsed);
    boolean gainPower(int PowerGained);    

    PowerNetwork getNetwork();

    void overrideNetwork(PowerNetwork network);
}
