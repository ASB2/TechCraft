package TechCraft.power;

public enum EnumPowerClass {

    Low(10);

    private final int powerClass;

    EnumPowerClass(int powerClass) {
        this.powerClass = powerClass;
    }

    public int getValue() {
        return powerClass;
    }
}
