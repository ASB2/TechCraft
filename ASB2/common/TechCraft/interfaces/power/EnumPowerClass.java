package TechCraft.interfaces.power;

public enum EnumPowerClass {

    Low(10),
    Mid(50),
    High(100);

    private final int powerClass;

    EnumPowerClass(int powerClass) {
        this.powerClass = powerClass;
    }

    public int getValue() {
        return powerClass;
    }
}
