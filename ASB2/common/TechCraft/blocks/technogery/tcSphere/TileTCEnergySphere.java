package TechCraft.blocks.technogery.tcSphere;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.TechCraft;

public class TileTCEnergySphere extends TechCraftTile implements IPowerMisc {

    public TileTCEnergySphere() {

        this.powerProvider = new PowerProviderTileEnergySphere(this, 1000, PowerClass.LOW);
    }

    public void updateEntity() {

        if(TechCraft.testingMode) {

            this.getPowerProvider().setPower(0);
        }    
    }

    @Override
    public String getName() {

        return "Energy Sphere";
    }
}

