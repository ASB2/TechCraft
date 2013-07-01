package TechCraft.blocks.technogery.tcEnergizedBuildingBlocks;

import net.minecraft.tileentity.TileEntity;
import TechCraft.power.PowerClass;
import TechCraft.power.PowerProvider;
import TechCraft.power.State;

public class PowerProviderEnergizedBuildingBlocks extends PowerProvider {

    public PowerProviderEnergizedBuildingBlocks(TileEntity tile, int powerMax, PowerClass pClass) {
        super(tile, powerMax, pClass);
    }

    public State getCurrentState() {

        if(currentState == null) {

            currentState = State.SOURCE;
        }
        return currentState;
    }
}
