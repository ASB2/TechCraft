package TechCraft.blocks.tcConduits;

import TechCraft.ConduitNetwork;
import TechCraft.blocks.TechCraftTile;

public class TileTCConduit extends TechCraftTile {

    ConduitNetwork network;
    
    public void updateEntity() {
        
        super.updateEntity();
        
        if(network != null) {
            
           network.updateNetwork();
        }
        else {
            network = new ConduitNetwork(worldObj, this);
        }
    }
    
    @Override
    public String getName() {

        return "TechCraft Conduit(Moving)";
    }
    
    public ConduitNetwork getNetwork() {

        return network;
    }


    public void overrideNetwork(ConduitNetwork network) {

        this.network = network;
    }
}