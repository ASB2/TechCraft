package TechCraft.power;

import net.minecraft.tileentity.TileEntity;

public class TCPowerProvider extends PowerProvider{

    public TCPowerProvider(TileEntity tile, int powerMax, PowerClass pClass, State state) {
        super(tile, powerMax, pClass);
    
        this.currentState = state;
    }

    public State getCurrentState() {
        
        if(currentState == null) {
            
            currentState = State.SINK;
        }
        return currentState;        
    }
}
