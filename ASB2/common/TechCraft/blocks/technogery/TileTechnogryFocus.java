package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.IPowerSink;

public class TileTechnogryFocus extends TechCraftTile implements IPowerSink{

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
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
    }

    @Override
    public void gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){

            this.powerStored= powerStored + PowerGained;
        }
    }

    @Override
    public void usePower(int PowerUsed) {
        
        if(powerStored > PowerUsed) {

            powerStored = powerStored - PowerUsed;
        }
    }

    public boolean recievePower() {

        return true;
    }
}
