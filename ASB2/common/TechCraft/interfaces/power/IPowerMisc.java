package TechCraft.interfaces.power;

public interface IPowerMisc {

    int getOutputMax();
    int getOutputMin();
    
    int getPowerStored();
    int getPowerMax();
    
    boolean recievePower();
    boolean outputPower();
    
    boolean requestingPower();
    boolean sendingPower();
    
    String getName();
    
    void usePower(int PowerUsed);
    void gainPower(int PowerGained);
    void updateConnections();
    
}
