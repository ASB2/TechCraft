package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.World;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitExporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;

public class PowerNetwork {

    private List <TileMagicConduitMoving> conductors = new ArrayList<TileMagicConduitMoving>();

    private List <IPowerMisc> powerSink = new ArrayList<IPowerMisc>();

    private List <IPowerMisc> powerSource = new ArrayList<IPowerMisc>();

    @SuppressWarnings("unused")
    private World worldObj;

    public TileMagicConduitMoving tileCore;

    private int age = 0;
    int powerToMove = 1;
    int buffer = 0;

    public PowerNetwork(World world, TileMagicConduitMoving tile) {    

        worldObj = world;
        this.tileCore = tile;

        this.addConductor(tile);
    }

    public void updateNetwork() {

        age = tileCore.age;

        for(int i = 0; i < conductors.size(); i++){

            conductors.get(i).addConductorsAround();
            conductors.get(i).addSourceAround();
            conductors.get(i).addSinkAround();
        }

        if(powerSource.size() > 0 && powerSink.size() > 0){

            for(int i = 0; i < powerSource.size(); i++) {

                for(int z = 0; z < powerSink.size(); z++) {

                    if(powerSink.get(z).getPowerMax() - powerSink.get(i).getPowerStored() >= powerToMove){
                        
                        if(powerSource.get(i).usePower(powerToMove)) {
                            
                            powerSink.get(z).gainPower(powerToMove);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void addConductor(TileMagicConduitMoving tile) {

        conductors.add(tile);
    }

    public void removeConductor(TileMagicConduitMoving tile) {

        conductors.remove(tile);
    }

    public void addSource(IPowerMisc tile) {

        powerSource.add(tile);
    }

    public void removeSource(IPowerMisc tile) {

        powerSource.remove(tile);
    }

    public void addSink(IPowerMisc tile) {

        powerSink.add(tile);
    }

    public void removeSink(IPowerMisc tile) {

        powerSink.remove(tile);
    }

    public List<TileMagicConduitMoving> getConductors() {
        return conductors;
    }

    public List<IPowerMisc> getSink() {
        return powerSink;
    }

    public List<IPowerMisc> getSource() {
        return powerSource;
    }

    public int getAge() {
        return age;
    }

    public int getBuffer() {

        return this.buffer;
    }
}
