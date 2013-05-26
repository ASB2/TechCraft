package TechCraft.power;

public interface IPowerSink extends IPowerMisc {

    PowerNetwork getNetwork();

    void overrideNetwork(PowerNetwork network);
}
