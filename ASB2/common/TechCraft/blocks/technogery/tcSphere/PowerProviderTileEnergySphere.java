package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.tileentity.TileEntity;
import TechCraft.power.PowerClass;
import TechCraft.power.PowerProvider;
import TechCraft.power.State;

public class PowerProviderTileEnergySphere extends PowerProvider {

    public PowerProviderTileEnergySphere(TileEntity tile, int powerMax, PowerClass pClass) {
        super(tile, powerMax, pClass);
    }
    
    public State getCurrentState() {
        
        return State.OTHER;
    }
    
    public boolean requestingPower() {
        
        int temp = getPowerMax() / 4;
        if(getPowerStored() < getPowerMax() / 2 + temp) {
            
            return true;
        }
        
        return false;
    }

    public boolean outputtingPower() {
        
        return super.outputtingPower();
    }
}
