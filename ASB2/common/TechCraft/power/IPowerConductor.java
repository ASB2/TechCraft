package TechCraft.power;

public abstract interface IPowerConductor extends IPowerMisc {

    EnumPowerClass getPowerClass();

    int[] getPosition();
    
    PowerNetwork getNetwork();
    
    void overrideNetwork(PowerNetwork network);
}
