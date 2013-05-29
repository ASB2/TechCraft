package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;

public class PowerNetwork {

    private List <TileMagicConduitMoving> conductors = new ArrayList<TileMagicConduitMoving>();

    private List <IPowerMisc> powerSink = new ArrayList<IPowerMisc>();

    private List <IPowerMisc> powerSource = new ArrayList<IPowerMisc>();

    @SuppressWarnings("unused")
    private World worldObj;

    private int age = 0;
    int powerToMove = 1;

    int conductorSize = 0;
    int sinkSize = 0;
    int sourceSize = 0;


    public PowerNetwork(World world, TileEntity tile) {    

        worldObj = world;

        if(tile instanceof TileMagicConduitMoving) {

            TileMagicConduitMoving tileI = (TileMagicConduitMoving)tile;

            this.addConductor(tileI);
        }

        if(tile instanceof IPowerMisc) {

            IPowerMisc tileO = (IPowerMisc)tile;

            if(tileO.recievePower()) {
                this.addSink(tileO);
            }

            if(tileO.outputPower()) {
                this.addSource(tileO);
            }
        }
    }

    public void updateNetwork() {

        age++;

        for(int i = 0; i < conductors.size(); i++){

            conductors.get(i).addConductorsAround();
            conductors.get(i).addSourceAround();
            conductors.get(i).addSinkAround();
        }

        if(powerSource.size() > 0 && powerSink.size() > 0) {

            for(int i = 0; i < powerSource.size(); i++) {

                for(int z = 0; z < powerSink.size(); z++) {

                    if(powerSink.get(z).getPowerMax() - powerSink.get(z).getPowerStored() >= powerToMove) {

                        if(powerSource.get(i).usePower(powerToMove)) {

                            powerSink.get(z).gainPower(powerToMove);
                        }
                    }
                }
            }
        }
    }

    public void addConductor(TileMagicConduitMoving tile) {
        conductorSize++;
        conductors.add(tile);
    }

    public void removeConductor(TileMagicConduitMoving tile) {
        conductorSize--;
        conductors.remove(tile);
    }

    public void addSource(IPowerMisc tile) {
        sourceSize++;
        powerSource.add(tile);
    }

    public void removeSource(IPowerMisc tile) {
        sourceSize--;
        powerSource.remove(tile);
    }

    public void addSink(IPowerMisc tile) {
        sinkSize++;
        powerSink.add(tile);
    }

    public void removeSink(IPowerMisc tile) {
        sinkSize--;
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

    public int getConductorSize() {
        return conductorSize;
    }

    public int getSinkSize() {
        return sinkSize;
    }

    public int getSourceSize() {
        return sourceSize;
    }


}
