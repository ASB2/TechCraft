package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSource;
import TechCraft.power.PowerProvider;

public class TileMagiciansBuildingBlocks extends TechCraftTile implements IPowerSource {
    
    public TileMagiciansBuildingBlocks() {
    
        this.powerProvider = new PowerProvider(this, 25, 1, 1, true, false);
    }
    
    @Override
    public void updateEntity() {
        super.managePowerAll(this,true);
    }

    public TechCraft.power.PowerProvider getPowerProvider() {

        return powerProvider;
    }

    @Override
    public String getName() {

        return "Magician's Building Block";
    }
    
}
