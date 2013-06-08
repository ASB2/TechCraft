package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.Message;
import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.technogery.power_Conduit.*;

public class PowerNetwork {

    private List <TilePowerConduitMoving> conductors = new ArrayList<TilePowerConduitMoving>();

    private List <TileEntity> powerSink = new ArrayList<TileEntity>();

    private List <TileEntity> powerSource = new ArrayList<TileEntity>();

    private World worldObj;

    private int age = 0;
    int powerToMove = 1;

    int conductorSize = 0;
    int sinkSize = 0;
    int sourceSize = 0;

    private boolean addTileAdjacent = false;

    public boolean updateNetworkSize = false;

    public PowerNetwork(World world, TileEntity tile) {    

        worldObj = world;

        if(tile instanceof TilePowerConduitMoving) {

            TilePowerConduitMoving tileI = (TilePowerConduitMoving)tile;

            this.addConductor(tileI);
        }
        else {
            Message.sendToClient("Non-Power Moving Conduit object has started a network");  
        }

    }

    public void updateNetwork() {

        age++;

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

        if(!(powerSource.isEmpty() && powerSink.isEmpty())) {

            for(int i = 0; i < powerSource.size(); i++) {

                if(powerSource.get(i) != null) {

                    for(int z = 0; z < powerSink.size(); z++) {

                        if(powerSink.get(z) != null) {

                            if(powerSink.get(z) instanceof IPowerMisc && powerSource.get(i) instanceof IPowerMisc) {

                                IPowerMisc sink = (IPowerMisc)powerSink.get(z);
                                IPowerMisc source = (IPowerMisc)powerSource.get(i);

                                if(sink != source) {

                                    if(sink.getPowerMax() - sink.getPowerStored() >= powerToMove) {

                                        if(source.usePower(powerToMove)) {

                                            sink.gainPower(powerToMove);
                                        }
                                    }
                                }
                            }
                        }

                        else {

                            this.removeSink(powerSink.get(z));
                        }
                    }
                }

                else {

                    this.removeSource(powerSource.get(i));
                }
            }
        }
    }

    public void addConductor(TilePowerConduitMoving tile) {
        conductorSize++;
        conductors.add(tile);
    }

    public void removeConductor(TilePowerConduitMoving tile) {
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

    public List<TilePowerConduitMoving> getConductors() {
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

    public boolean isAddTileAdjacent() {
        return addTileAdjacent;
    }

    public void setAddTileAdjacent(boolean addTileAdjacent) {
        this.addTileAdjacent = addTileAdjacent;
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

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                }                                
                            }
                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof TilePowerConduitMoving) {

                            if(((TilePowerConduitMoving) tileI).getNetwork() != null) {

                                if(((TilePowerConduitMoving)tileI).getNetwork() != this) {

                                    if(((TilePowerConduitMoving)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
                                    else {

                                        ((TilePowerConduitMoving)tileI).overrideNetwork(this);
                                        this.addConductor((TilePowerConduitMoving) tileI);
                                    }
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

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }

                                this.addSource(tile);
                            }
                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }
                                this.addSource(tile);
                            }
                        }
                        break;
                    }

                    case NORTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }
                                this.addSource(tile);
                            }
                        }
                        break;
                    }

                    case SOUTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }
                                this.addSource(tile);
                            }
                        }
                        break;

                    }

                    case UP: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }
                                this.addSource(tile);
                            }
                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).outputPower()) {

                                for(int i = 0; i < powerSource.size(); i++){
                                    if(powerSource.get(i) == tile)
                                        return;
                                }
                                this.addSource(tile);
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

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
                            }
                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
                            }
                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
                            }
                        }
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
                            }
                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
                            }
                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof IPowerMisc) {

                            if(((IPowerMisc)tileI).recievePower()) {

                                for(int i = 0; i < powerSink.size(); i++){
                                    if(powerSink.get(i) == tile)
                                        return;
                                }
                                this.addSink(tileI);
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
