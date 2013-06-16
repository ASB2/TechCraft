package TechCraft.conduit;

public interface IConduitInterface extends IConduitNetwork {


    /**
     * Returns the type of conduit interface of this object.
     */
    EnumInterfaceType getInterfaceType();
    
    /**
     * Determines if the interface is requesting something from the network or outputting into the network
     */
    boolean importingToNetwork();
}
