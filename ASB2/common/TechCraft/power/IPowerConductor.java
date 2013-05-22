package TechCraft.power;

public interface IPowerConductor extends IPowerMisc{

    EnumPowerClass getPowerClass();
    double getRange();
    int[] getPosition();
    int getPrecentFilled();
}
