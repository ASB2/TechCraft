package TechCraft.blocks.technogery.tcEnergizedBuildingBlocks;

import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.*;

public class TileEnergizedBuildingBlocks extends TechCraftTile implements IPowerMisc {
    
    public TileEnergizedBuildingBlocks() {
    
        this.powerProvider = new PowerProviderEnergizedBuildingBlocks(this, 25, PowerClass.LOW);
    }
    
    @Override
    public void updateEntity() {
        
        this.getPowerProvider().setPower(this.getPowerProvider().getPowerMax());
    }

    public TechCraft.power.PowerProvider getPowerProvider() {

        return powerProvider;
    }

    @Override
    public String getName() {

        return "Energized Building Block";
    }
    
}
