package TechCraft.power;

public interface IPowerSource extends IPowerMisc {

    PowerNetwork getNetwork();

    void overrideNetwork(PowerNetwork network);
}
