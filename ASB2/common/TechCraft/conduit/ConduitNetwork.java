package TechCraft.conduit;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.tcConduits.TileTCConduit;

public class ConduitNetwork {

    private List <TileTCConduit> conductors = new ArrayList<TileTCConduit>();
    private List <TileEntity> itemInterface = new ArrayList<TileEntity>();
    private List <TileEntity> tcuInterface = new ArrayList<TileEntity>();
    private List <TileEntity> liquidInterface = new ArrayList<TileEntity>();
    private List <TileEntity> bcInterface = new ArrayList<TileEntity>();
    private List <TileEntity> ic2Interface = new ArrayList<TileEntity>();
    private List <TileEntity> otherInterface = new ArrayList<TileEntity>();

    private World worldObj;

    private int age = 0;

    public ConduitNetwork(World world, TileEntity tile) {

        worldObj = world;

        if(tile instanceof IConduitInterface) {

            if(tile instanceof TileTCConduit) {

                TileTCConduit tileI = (TileTCConduit)tile;

                this.addConductor(tileI);
            }

            if(((IConduitInterface)tile).getInterfaceType() != null) {

                switch(((IConduitInterface)tile).getInterfaceType()) {

                    case ITEM: itemInterface.add(tile);
                    break;

                    case TCU: tcuInterface.add(tile);
                    break;

                    case LIQUID: liquidInterface.add(tile);
                    break;

                    case BCPOWER: bcInterface.add(tile);
                    break;

                    case IC2POWER: ic2Interface.add(tile);
                    break;          

                    case OTHER: otherInterface.add(tile);
                    break;

                    default:
                        break;

                }
            }
        }
    }

    public void updateNetwork() {
        age++;

        for(int i = 0; i < conductors.size(); i++) {

            if(conductors.get(i) == null) { 

                conductors.remove(i);
                return;
            }

            if(worldObj == null){

                worldObj = conductors.get(i).worldObj;
            }

            if(worldObj.getBlockId(conductors.get(i).xCoord, conductors.get(i).yCoord, conductors.get(i).zCoord) == 0) {

                conductors.remove(i);
                return;
            }

            this.addConductorsAround(conductors.get(i));
            this.addInterfacesAround(conductors.get(i));
        }
    }

    public void addConductor(TileTCConduit tile) {
        conductors.add(tile);
    }

    public void removeConductor(TileTCConduit tile) {
        conductors.remove(tile);
    }

    public int getAge() {

        return age;
    }

    public int getConductorSize() {

        return conductors.size();
    }

    public int getItemInterfaceSize() {

        return itemInterface.size();
    }

    public int getTcuInterfaceSize() {

        return tcuInterface.size();
    }

    public int getLiquidInterfaceSize() {

        return liquidInterface.size();
    }

    public int getBcInterfaceSize() {

        return bcInterface.size();
    }

    public int getIc2InterfaceSize() {

        return ic2Interface.size();
    }

    public int getOtherInterfaceSize() {

        return otherInterface.size();
    }

    public List<TileTCConduit> getConductors() {

        for(int i = 0; i < conductors.size(); i++) {

            if(conductors.get(i) == null) { 

                conductors.remove(i);
            }

            if(worldObj == null){

                worldObj = conductors.get(i).worldObj;
            }

            if(worldObj.getBlockId(conductors.get(i).xCoord, conductors.get(i).yCoord, conductors.get(i).zCoord) == 0) {

                conductors.remove(i);
            }
        }
        return conductors;
    }

    public List<TileEntity> getItemInterface() {

        for(int i = 0; i < itemInterface.size(); i++) {

            if(itemInterface.get(i) == null) { 

                itemInterface.remove(i);
            }

            if(worldObj == null){

                worldObj = itemInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(itemInterface.get(i).xCoord, itemInterface.get(i).yCoord, itemInterface.get(i).zCoord) == 0) {

                itemInterface.remove(i);
            }
        }
        return itemInterface;
    }

    public List<TileEntity> getTcuInterface() {

        for(int i = 0; i < tcuInterface.size(); i++) {

            if(tcuInterface.get(i) == null) { 

                tcuInterface.remove(i);
            }

            if(worldObj == null){

                worldObj = tcuInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(tcuInterface.get(i).xCoord, tcuInterface.get(i).yCoord, tcuInterface.get(i).zCoord) == 0) {

                tcuInterface.remove(i);
            }
        }
        return tcuInterface;
    }

    public List<TileEntity> getLiquidInterface() {

        for(int i = 0; i < liquidInterface.size(); i++) {

            if(liquidInterface.get(i) == null) { 

                liquidInterface.remove(i);
            }

            if(worldObj == null){

                worldObj = liquidInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(liquidInterface.get(i).xCoord, liquidInterface.get(i).yCoord, liquidInterface.get(i).zCoord) == 0) {

                liquidInterface.remove(i);
            }
        }
        return liquidInterface;
    }

    public List<TileEntity> getBcInterface() {

        for(int i = 0; i < bcInterface.size(); i++) {

            if(bcInterface.get(i) == null) { 

                bcInterface.remove(i);
            }

            if(worldObj == null){

                worldObj = bcInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(bcInterface.get(i).xCoord, bcInterface.get(i).yCoord, bcInterface.get(i).zCoord) == 0) {

                bcInterface.remove(i);
            }
        }
        return bcInterface;
    }

    public List<TileEntity> getIc2Interface() {

        for(int i = 0; i < ic2Interface.size(); i++) {

            if(ic2Interface.get(i) == null) { 

                ic2Interface.remove(i);
            }

            if(worldObj == null){

                worldObj = ic2Interface.get(i).worldObj;
            }

            if(worldObj.getBlockId(ic2Interface.get(i).xCoord, ic2Interface.get(i).yCoord, ic2Interface.get(i).zCoord) == 0) {

                ic2Interface.remove(i);
            }
        }
        return ic2Interface;
    }

    public List<TileEntity> getOtherInterface() {

        for(int i = 0; i < otherInterface.size(); i++) {

            if(otherInterface.get(i) == null) { 

                otherInterface.remove(i);
            }

            if(worldObj == null){

                worldObj = otherInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(otherInterface.get(i).xCoord, otherInterface.get(i).yCoord, otherInterface.get(i).zCoord) == 0) {

                otherInterface.remove(i);
            }
        }
        return otherInterface;
    }

    public void addConductorsAround(TileEntity tile) {
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

                if(tileI instanceof TileTCConduit) {

                    if(((TileTCConduit) tileI).getNetwork() != null) {

                        if(((TileTCConduit)tileI).getNetwork() != this) {

                            if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                ((TileTCConduit)tileI).overrideNetwork(this);
                                this.addConductor((TileTCConduit) tileI);
                            }
                            else if(((IConduitInterface)tileI).getNetwork().getConductorSize() < this.getConductorSize()) {

                                ((TileTCConduit)tileI).overrideNetwork(this);
                                this.addConductor((TileTCConduit) tileI);
                            }
                        }                                
                    }
                    else {

                        ((TileTCConduit)tileI).overrideNetwork(this);
                        this.addConductor((TileTCConduit) tileI);
                    }
                }
            }
        }
    }

    public void addInterfacesAround(TileEntity tile) {

        addInterfacesAround(ForgeDirection.DOWN, tile);
        addInterfacesAround(ForgeDirection.UP, tile);
        addInterfacesAround(ForgeDirection.NORTH, tile);
        addInterfacesAround(ForgeDirection.SOUTH, tile);
        addInterfacesAround(ForgeDirection.WEST, tile);
        addInterfacesAround(ForgeDirection.EAST, tile);  
    }

    public void addInterfacesAround(ForgeDirection direction, TileEntity tile) {

        if(worldObj != null) {

            TileEntity tileI = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);

            if(tileI != null) {

                if(tileI instanceof IConduitInterface) {

                    if(((IConduitInterface) tileI).getNetwork() != null) {

                        if(((IConduitInterface)tileI).getNetwork() != this) {

                            if(((IConduitInterface)tileI).getNetwork().getAge() < this.getAge()) {

                                ((IConduitInterface)tileI).overrideNetwork(this);

                                switch(((IConduitInterface)tileI).getInterfaceType()) {

                                    case ITEM: itemInterface.add(tileI);
                                    break;

                                    case TCU: tcuInterface.add(tileI);
                                    break;

                                    case LIQUID: liquidInterface.add(tileI);
                                    break;

                                    case BCPOWER: bcInterface.add(tileI);
                                    break;

                                    case IC2POWER: ic2Interface.add(tileI);
                                    break;          

                                    case OTHER: otherInterface.add(tile);
                                    break;

                                    default:
                                        break;
                                }
                            }
                            else if(((IConduitInterface)tileI).getNetwork().getConductorSize() < this.getConductorSize()){

                                ((IConduitInterface)tileI).overrideNetwork(this);

                                switch(((IConduitInterface)tileI).getInterfaceType()) {

                                    case ITEM: itemInterface.add(tileI);
                                    break;

                                    case TCU: tcuInterface.add(tileI);
                                    break;

                                    case LIQUID: liquidInterface.add(tileI);
                                    break;

                                    case BCPOWER: bcInterface.add(tileI);
                                    break;

                                    case IC2POWER: ic2Interface.add(tileI);
                                    break;          

                                    case OTHER: otherInterface.add(tile);
                                    break;

                                    default:
                                        break;
                                }
                            }
                        }                                
                    }
                    else {

                        ((IConduitInterface)tileI).overrideNetwork(this);

                        switch(((IConduitInterface)tileI).getInterfaceType()) {

                            case ITEM: itemInterface.add(tileI);
                            break;

                            case TCU: tcuInterface.add(tileI);
                            break;

                            case LIQUID: liquidInterface.add(tileI);
                            break;

                            case BCPOWER: bcInterface.add(tileI);
                            break;

                            case IC2POWER: ic2Interface.add(tileI);
                            break;          

                            case OTHER: otherInterface.add(tile);
                            break;

                            default:
                                break;
                        }
                    }
                }
            }
        }
    }
}

