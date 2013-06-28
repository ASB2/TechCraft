package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.*;

public class TileMagiciansBuildingBlocks extends TechCraftTile implements IPowerMisc {
    
    public TileMagiciansBuildingBlocks() {
    
        this.powerProvider = new TCPowerProvider(this, 25, PowerClass.LOW);
    }
    
    @Override
    public void updateEntity() {
        
    }

    public TechCraft.power.PowerProvider getPowerProvider() {

        return powerProvider;
    }

    @Override
    public String getName() {

        return "Magician's Building Block";
    }
    
}
