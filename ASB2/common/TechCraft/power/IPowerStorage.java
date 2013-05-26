package TechCraft.power;

public interface IPowerStorage extends IPowerMisc {

    PowerNetwork getNetwork();

    void overrideNetwork(PowerNetwork network);    
}
