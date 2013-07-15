package TechCraft.blocks.technogery.tcSphere;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;


public class TileTCEnergySphere extends TechCraftTile implements IPowerMisc {

    public TileTCEnergySphere() {

        this.powerProvider = new PowerProviderTileEnergySphere(this, 1000, PowerClass.LOW);
    }

    public void updateEntity() {

    }    

    @Override
    public String getName() {

        return "Energy Sphere";
    }
}

