package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;

public class PowerNetwork {

    private List <TileMagicConduitMoving> conductors = new ArrayList<TileMagicConduitMoving>();

    private List <TileEntity> powerSink = new ArrayList<TileEntity>();

    private List <TileEntity> powerSource = new ArrayList<TileEntity    >();

    private World worldObj;

    private int age = 0;
    int powerToMove = 1;

    int conductorSize = 0;
    int sinkSize = 0;
    int sourceSize = 0;

    public boolean updateNetworkSize = false;

    public PowerNetwork(World world, TileEntity tile) {    

        worldObj = world;

        if(tile instanceof TileMagicConduitMoving) {

            TileMagicConduitMoving tileI = (TileMagicConduitMoving)tile;

            this.addConductor(tileI);
        }

        if(tile instanceof IPowerMisc) {

            IPowerMisc tileO = (IPowerMisc)tile;

            if(tileO.recievePower()) {
                this.addSink(tile);
            }

            if(tileO.outputPower()) {
                this.addSource(tile);
            }
        }
    }

    public void updateNetwork() {

        age++;

        //if(updateNetworkSize) {

        for(int i = 0; i < conductors.size(); i++) {

            if(conductors.get(i) == null) { 

                conductors.remove(i);
            }

            if(worldObj == null){
                worldObj = conductors.get(i).worldObj;
            }

            this.addConductorsAround(conductors.get(i));
            this.addSourceAround(conductors.get(i));
            this.addSinkAround(conductors.get(i));
        }

        for(int i = 0; i < powerSource.size(); i++) {

            if(powerSource.get(i) == null) {

                powerSource.remove(i);
            }

            if(worldObj == null){
                worldObj = powerSource.get(i).worldObj;
            }

            this.addConductorsAround(powerSource.get(i));
            this.addSourceAround(powerSource.get(i));
            this.addSinkAround(powerSource.get(i));
        }

        for(int i = 0; i < powerSink.size(); i++) {

            if(powerSink.get(i) == null) {

                powerSink.remove(i);
            }

            if(worldObj == null){
                worldObj = powerSink.get(i).worldObj;
            }

            this.addConductorsAround(powerSink.get(i));
            this.addSourceAround(powerSink.get(i));
            this.addSinkAround(powerSink.get(i));
        }
        //}

        if(powerSource.size() > 0 && powerSink.size() > 0) {

            for(int i = 0; i < powerSource.size(); i++) {

                for(int z = 0; z < powerSink.size(); z++) {

                    if(powerSink.get(z) instanceof IPowerMisc && powerSource.get(i) instanceof IPowerMisc) {

                        IPowerMisc sink = (IPowerMisc)powerSink.get(z);
                        IPowerMisc source = (IPowerMisc)powerSource.get(i);

                        if(sink.getPowerMax() - sink.getPowerStored() >= powerToMove) {

                            if(source.usePower(powerToMove)) {

                                sink.gainPower(powerToMove);
                            }
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

    public void addSource(TileEntity tile) {
        sourceSize++;
        powerSource.add(tile);
    }

    public void removeSource(TileEntity tile) {
        sourceSize--;
        powerSource.remove(tile);
    }

    public void addSink(TileEntity tile) {
        sinkSize++;
        powerSink.add(tile);
    }

    public void removeSink(TileEntity tile) {
        sinkSize--;
        powerSink.remove(tile);
    }

    public List<TileMagicConduitMoving> getConductors() {
        return conductors;
    }

    public List<TileEntity> getSink() {
        return powerSink;
    }

    public List<TileEntity> getSource() {
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

    public void addConductorsAround(TileEntity tile){
        addConductorsAround(ForgeDirection.DOWN, tile);
        addConductorsAround(ForgeDirection.UP, tile);
        addConductorsAround(ForgeDirection.NORTH, tile);
        addConductorsAround(ForgeDirection.SOUTH, tile);
        addConductorsAround(ForgeDirection.WEST, tile);
        addConductorsAround(ForgeDirection.EAST, tile);
    }

    public void addConductorsAround(ForgeDirection direction, TileEntity tile){

        if(worldObj != null) {

            TileEntity tileI = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);

            if(tileI != null) {

                switch(direction) {

                    case DOWN: {

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof TileMagicConduitMoving) {

                            if(((TileMagicConduitMoving) tileI).getNetwork() != null) {

                                if(((TileMagicConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                    ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                    this.addConductor((TileMagicConduitMoving) tileI);
                                }
                            }
                            else {

                                ((TileMagicConduitMoving)tileI).overrideNetwork(this);
                                this.addConductor((TileMagicConduitMoving) tileI);
                            }
                        }
                        break;
                    }
                    case UNKNOWN:
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public void addSourceAround(TileEntity tile){
        addSourceAround(ForgeDirection.DOWN, tile);
        addSourceAround(ForgeDirection.UP, tile);
        addSourceAround(ForgeDirection.NORTH, tile);
        addSourceAround(ForgeDirection.SOUTH, tile);
        addSourceAround(ForgeDirection.WEST, tile);
        addSourceAround(ForgeDirection.EAST, tile);
    }

    public void addSourceAround(ForgeDirection direction, TileEntity tile){

        if(worldObj != null) {
            TileEntity tileI = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);

            if(tileI != null) {

                switch(direction) {

                    case DOWN: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }  
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).outputPower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSource(tile);
                                }
                            }

                        }
                        break;
                    }
                    case UNKNOWN:
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public void addSinkAround(TileEntity tile){
        addSinkAround(ForgeDirection.DOWN, tile);
        addSinkAround(ForgeDirection.UP, tile);
        addSinkAround(ForgeDirection.NORTH, tile);
        addSinkAround(ForgeDirection.SOUTH, tile);
        addSinkAround(ForgeDirection.WEST, tile);
        addSinkAround(ForgeDirection.EAST, tile);
    }

    public void addSinkAround(ForgeDirection direction, TileEntity tile){

        if(worldObj != null) {
            TileEntity tileI = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);

            if(tileI != null) {

                switch(direction) {

                    case DOWN: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                        }
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).getNetwork() == null) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }
                            }

                            else if(((IPowerMisc)tileI).getNetwork().getAge() < this.getAge()) {

                                if(((IPowerMisc)tileI).recievePower()) {

                                    ((IPowerMisc)tileI).overrideNetwork(this);
                                    this.addSink(tile);
                                }                            
                            }

                        }
                        break;
                    }
                    case UNKNOWN:
                        break;

                    default:
                        break;
                }
            }
        }
    }


}
