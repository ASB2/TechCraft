package TechCraft.conduit;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.utils.UtilDirection;

public class ConduitNetwork {

    private List <TileEntity> conductors = new ArrayList<TileEntity>();
    private List <TileEntity> itemInterface = new ArrayList<TileEntity>();
    private List <TileEntity> tcuInterface = new ArrayList<TileEntity>();
    private List <TileEntity> liquidInterface = new ArrayList<TileEntity>();
    private List <TileEntity> otherInterface = new ArrayList<TileEntity>();

    private World worldObj;
    private EnumContuitType networkType;

    int age = 0;
    /**
     * 
     * @param World
     * @param TileEntity
     * @param EnumContuitType
     */
    public ConduitNetwork(World world, TileEntity tile, EnumContuitType networkType) {

        this.networkType = networkType;
        worldObj = world;

        if(tile instanceof IConduitConductor) {

            this.addConductor(tile);
        }

    }

    public void updateNetwork() {
        age++;
        
        this.getConductors();
        this.getItemInterface();
        this.getTcuInterface();
        this.getLiquidInterface();
        this.getOtherInterface();

        this.addAdjacentInterfaces();
    }

    public void addAdjacentInterfaces() {

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
            this.addInterfacesAround(conductors.get(i), networkType);
        }
        
        for(int i = 0; i < itemInterface.size(); i++) {

            if(itemInterface.get(i) == null) { 

                itemInterface.remove(i);
                return;
            }

            if(worldObj == null){

                worldObj = itemInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(itemInterface.get(i).xCoord, itemInterface.get(i).yCoord, itemInterface.get(i).zCoord) == 0) {

                itemInterface.remove(i);
                return;
            }

            this.addConductorsAround(itemInterface.get(i));
            this.addInterfacesAround(itemInterface.get(i), networkType);
        }

        for(int i = 0; i < tcuInterface.size(); i++) {

            if(tcuInterface.get(i) == null) { 

                tcuInterface.remove(i);
                return;
            }

            if(worldObj == null){

                worldObj = tcuInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(tcuInterface.get(i).xCoord, tcuInterface.get(i).yCoord, tcuInterface.get(i).zCoord) == 0) {

                tcuInterface.remove(i);
                return;
            }

            this.addConductorsAround(tcuInterface.get(i));
            this.addInterfacesAround(tcuInterface.get(i), networkType);
        }

        for(int i = 0; i < liquidInterface.size(); i++) {

            if(liquidInterface.get(i) == null) { 

                liquidInterface.remove(i);
                return;
            }

            if(worldObj == null){

                worldObj = liquidInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(liquidInterface.get(i).xCoord, liquidInterface.get(i).yCoord, liquidInterface.get(i).zCoord) == 0) {

                liquidInterface.remove(i);
                return;
            }

            this.addConductorsAround(liquidInterface.get(i));
            this.addInterfacesAround(liquidInterface.get(i), networkType);
        }

        for(int i = 0; i < otherInterface.size(); i++) {

            if(otherInterface.get(i) == null) { 

                otherInterface.remove(i);
                return;
            }

            if(worldObj == null){

                worldObj = otherInterface.get(i).worldObj;
            }

            if(worldObj.getBlockId(otherInterface.get(i).xCoord, otherInterface.get(i).yCoord, otherInterface.get(i).zCoord) == 0) {

                otherInterface.remove(i);
                return;
            }

            this.addConductorsAround(otherInterface.get(i));
            this.addInterfacesAround(otherInterface.get(i), networkType);
        }

    }

    public void addConductor(TileEntity tile) {

        conductors.add(tile);
    }

    public void removeConductor(TileEntity tile) {

        conductors.remove(tile);
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

    public int getOtherInterfaceSize() {

        return otherInterface.size();
    }

    public int getAge() {
        
        return age;
    }
    
    public List<TileEntity> getConductors() {

        this.checkNetwork(conductors);

        return conductors;
    }

    public List<TileEntity> getItemInterface() {

        this.checkNetwork(itemInterface);

        return itemInterface;
    }

    public List<TileEntity> getTcuInterface() {

        this.checkNetwork(tcuInterface);

        return tcuInterface;
    }

    public List<TileEntity> getLiquidInterface() {

        this.checkNetwork(liquidInterface);

        return liquidInterface;
    }

    public List<TileEntity> getOtherInterface() {

        this.checkNetwork(otherInterface);

        return otherInterface;
    }

    @SuppressWarnings("rawtypes")
    public void checkNetwork(List list) {

        for(int i = 0; i < list.size(); i++) {

            if(list.get(i) == null) { 

                list.remove(i);
            }

            if(list.get(i) instanceof TileEntity) {

                if(worldObj == null) {

                    worldObj = ((TileEntity)list.get(i)).worldObj;
                }

                if(worldObj.getBlockId(((TileEntity)list.get(i)).xCoord, ((TileEntity)list.get(i)).yCoord, ((TileEntity)list.get(i)).zCoord) == 0) {

                    list.remove(i);
                }
            }
        }
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

            TileEntity tileI = worldObj.getBlockTileEntity(UtilDirection.translateDirectionToCoords(direction, tile)[0], UtilDirection.translateDirectionToCoords(direction, tile)[1], UtilDirection.translateDirectionToCoords(direction, tile)[2]);

            if(tileI != null) {

                if(tileI instanceof IConduitConductor) {
                    IConduitConductor tileA = (IConduitConductor)tileI;

                    if(tileA.getConductorType() == this.networkType) {

                        if(tileA.getNetwork() != null) {

                            if(tileA.getNetwork() != this) {

                                if(tileA.getNetwork().getConductorSize() < this.getConductorSize()) {

                                    for(int i = 0; i < tileA.getNetwork().getConductorSize(); i++) {

                                        TileEntity tileB = tileA.getNetwork().getConductors().get(i);

                                        if(tileB instanceof IConduitConductor) {

                                            IConduitConductor tileC = (IConduitConductor)tileB;

                                            if(tileC.getConductorType() == this.networkType) {

                                                tileC.overrideNetwork(this);
                                                this.addConductor(tileB);
                                            }
                                        }
                                    }
                                    ((IConduitInterface)tileI).overrideNetwork(this);
                                    this.addConductor(tileI);

                                }
                                else if (tileA.getNetwork().getAge() < this.getAge()){

                                    tileA.overrideNetwork(this);
                                    this.addConductor((TileEntity) tileA);
                                }
                            }                                
                        }

                    }
                }
            }
        }
    }

    public void addInterfacesAround(TileEntity tile, EnumContuitType netType) {

        addInterfacesAround(ForgeDirection.DOWN, tile, netType);
        addInterfacesAround(ForgeDirection.UP, tile, netType);
        addInterfacesAround(ForgeDirection.NORTH, tile, netType);
        addInterfacesAround(ForgeDirection.SOUTH, tile, netType);
        addInterfacesAround(ForgeDirection.WEST, tile, netType);
        addInterfacesAround(ForgeDirection.EAST, tile, netType);  
    }

    public void addInterfacesAround(ForgeDirection direction, TileEntity tile, EnumContuitType netType) {

        if(worldObj != null) {

            TileEntity tileA = worldObj.getBlockTileEntity(UtilDirection.translateDirectionToCoords(direction, tile)[0], UtilDirection.translateDirectionToCoords(direction, tile)[1], UtilDirection.translateDirectionToCoords(direction, tile)[2]);

            if(tileA != null) {

                if(tileA instanceof IConduitInterface) {

                    IConduitInterface tileB = (IConduitInterface)tileA;

                    if(tileB.getNetwork() != null) {

                        if(tileB.getNetwork() != this) {

                            if(TechCraftTile.translateInterfaceTypeToConduitType(tileB.getInterfaceType()) == this.networkType) {

                                switch(tileB.getInterfaceType()) {

                                    case ITEM: this.itemInterface.add(tileA);
                                    break;
                                    case LIQUID: this.liquidInterface.add(tileA);
                                    break;
                                    case OTHER: this.otherInterface.add(tileA);
                                    break;
                                    case TCU: this.tcuInterface.add(tileA);
                                    break;

                                    default:
                                        break;

                                }
                            }
                        }                                
                    }

                    else {

                        tileB.overrideNetwork(this);

                        switch(tileB.getInterfaceType()) {

                            case ITEM: this.itemInterface.add(tileA);
                            break;
                            case LIQUID: this.liquidInterface.add(tileA);
                            break;
                            case OTHER: this.otherInterface.add(tileA);
                            break;
                            case TCU: this.tcuInterface.add(tileA);
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

