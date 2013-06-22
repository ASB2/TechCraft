package TechCraft.blocks.technogery.tcFocus;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;
import TechCraft.power.PowerProvider;

public class TileTechnogryFocus extends TechCraftTile implements IPowerSink {

    public TileTechnogryFocus() {
    
        this.powerProvider = new PowerProvider(this, 1000, 1, 1, false, true);
    }
    
    public void updateEntity() {

        //worldObj.setBlock(translateDirectionToCoords()[0], translateDirectionToCoords()[1], translateDirectionToCoords()[2], BlockRegistry.BlockAirCrystalOre.blockID);
        //worldObj.spawnEntityInWorld(new EntityTest(worldObj,translateDirectionToCoords()[0],translateDirectionToCoords()[1],translateDirectionToCoords()[2]));

    }
    
    @Override
    public String getName() {

        return "Technogry Focus";
    }
}
