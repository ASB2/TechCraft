package TechCraft.blocks.technogery;

import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;

public class TileTestBlock extends TechCraftTile {

    int powerStored = 1000;
    int powerMax = 1000;

    public void updateEntity(){
        this.managePowerAll(this, 10, true);
    }

    @Override
    public boolean gainPower(int PowerGained, ForgeDirection direction) {


        return false;
    }

    @Override
    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        return true;
    }
    
    @Override
    public boolean requestingPower(ForgeDirection direction) {

        return false;
    }

    @Override
    public boolean outputtingPower(ForgeDirection direction) {

        return true;
    }

    @Override
    public boolean canGainPower(int power) {
        return false;
    }

    @Override
    public boolean canUsePower(int power) {


        return true;
    }

    @Override
    public boolean outputPower() {

        return true;
    }

    @Override
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
    }

    @Override
    public String getName() {

        return "Test Block";
    }
}
