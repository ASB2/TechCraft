package TechCraft.blocks.technogery.tcSphere;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.TCPowerProvider;

public class TileTCEnergySphere extends TechCraftTile implements IPowerMisc {
    
    int color = 0;

    public TileTCEnergySphere() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW);
    }
    
    public void updateEntity() {
        super.updateEntity();
        
    }

    @Override
    public String getName() {

        return "Energy Sphere";
    }
}

