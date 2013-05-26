package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;
import TechCraft.power.PowerNetwork;

public class TileTechnogryFocus extends TechCraftTile implements IPowerSink{

    PowerNetwork network;
    
    int powerStored = 0;
    int powerMax = 100;

    public void updateEntity() {

        //worldObj.setBlock(translateDirectionToCoords()[0], translateDirectionToCoords()[1], translateDirectionToCoords()[2], BlockRegistry.BlockAirCrystalOre.blockID);
        //worldObj.spawnEntityInWorld(new EntityTest(worldObj,translateDirectionToCoords()[0],translateDirectionToCoords()[1],translateDirectionToCoords()[2]));

    }

    @Override
    public String getName() {

        return "Technogry Focus";
    }

    @Override
    public boolean recievePower() {

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
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){

            this.powerStored= powerStored + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public boolean usePower(int PowerUsed) {

        if(powerStored > PowerUsed) {

            powerStored = powerStored - PowerUsed;
            return true;
        }
        return false;
    }

    public PowerNetwork getNetwork(){

        return network;
    }

    public void overrideNetwork(PowerNetwork net){

        this.network = net;
    }
}
