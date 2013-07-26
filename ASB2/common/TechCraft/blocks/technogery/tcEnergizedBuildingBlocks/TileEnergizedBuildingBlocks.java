package TechCraft.blocks.technogery.tcEnergizedBuildingBlocks;

import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;

public class TileEnergizedBuildingBlocks extends TechCraftTile implements IPowerMisc {

    public TileEnergizedBuildingBlocks() {

        this.powerProvider = new TCPowerProvider(this, 25, PowerClass.LOW, State.SOURCE);
    }

    @Override
    public void updateEntity() {

        if(TechCraft.testingMode) {

            this.getPowerProvider().setPower(this.getPowerProvider().getPowerMax());
        } 
    }

    @Override
    public String getName() {

        return "Energized Building Block";
    }

}
