package TechCraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.tcConduits.TileTCConduit;

public class ConduitNetwork {

    private List <TileTCConduit> conductors = new ArrayList<TileTCConduit>();

    private World worldObj;
    
    private int age = 0;

    private int conductorSize = 0;
    
    public ConduitNetwork(World world, TileEntity tile) {

        worldObj = world;

        if(tile instanceof TileTCConduit) {

            TileTCConduit tileI = (TileTCConduit)tile;

            this.addConductor(tileI);
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

            if(!(worldObj.getBlockId(conductors.get(i).xCoord, conductors.get(i).yCoord, conductors.get(i).zCoord) == BlockRegistry.BlockTCConduit.blockID)) {

                conductors.remove(i);
                return;
            }

            this.addConductorsAround(conductors.get(i));
        }
    }

    public void addConductor(TileTCConduit tile) {
        conductorSize++;
        conductors.add(tile);
    }

    public void removeConductor(TileTCConduit tile) {
        conductorSize--;
        conductors.remove(tile);
    }
    
    public int getAge() {
        
        return age;
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

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }

                    case EAST:{

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case NORTH: {

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case SOUTH: {

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                }                                
                            }
                        }
                        break;

                    }
                    case UP: {

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                }                                
                            }
                        }
                        break;
                    }
                    case WEST: {

                        if(tileI instanceof TileTCConduit) {

                            if(((TileTCConduit) tileI).getNetwork() != null) {

                                if(((TileTCConduit)tileI).getNetwork() != this) {

                                    if(((TileTCConduit)tileI).getNetwork().getAge() < this.getAge()) {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
                                    }
                                    else {

                                        ((TileTCConduit)tileI).overrideNetwork(this);
                                        this.addConductor((TileTCConduit) tileI);
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

    public int getConductorSize() {

        return this.conductorSize;
    }
}

