package TechCraft.blocks.technogery;

import TechCraft.interfaces.power.IPowerMisc;
import TechCraft.interfaces.power.TechCraftTile;

public class TileTestBlock extends TechCraftTile implements IPowerMisc{

    int powerStored = 0;
    int powerMax = 1000;
    
    public void onUpdateEntity(){

    }
    @Override
    public int getOutputMax() {
        // TODO Auto-generated method stub
        return 100;
    }

    @Override
    public int getOutputMin() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int getPowerStored() {
        // TODO Auto-generated method stub
        return powerStored;
    }

    @Override
    public int getPowerMax() {
        // TODO Auto-generated method stub
        return powerMax;
    }

    @Override
    public boolean recievePower() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean outputPower() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Test Block";
    }

    @Override
    public void usePower(int PowerUsed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void gainPower(int PowerGained) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateConnections() {


    }

    @Override
    public boolean requestingPower() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean sendingPower() {
        // TODO Auto-generated method stub
        return true;
    }
}
