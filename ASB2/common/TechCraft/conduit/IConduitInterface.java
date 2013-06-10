package TechCraft.conduit;

import net.minecraftforge.common.ForgeDirection;

public interface IConduitInterface {
    
    ConduitInterfaceType getInterfaceType();

    boolean renderByDirection(ForgeDirection direction);

    ConduitNetwork getNetwork();
    
    void overrideNetwork(ConduitNetwork network);
    
    boolean importingToNetwork();
}