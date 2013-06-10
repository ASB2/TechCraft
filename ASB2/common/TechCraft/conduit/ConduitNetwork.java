package TechCraft.conduit;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
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

    private World worldObj;

    private int age = 0;

    public ConduitNetwork(World world, TileEntity tile) {

        worldObj = world;

        if(tile instanceof IConduitInterface) {

            if(tile instanceof TileTCConduit) {

                TileTCConduit tileI = (TileTCConduit)tile;

                this.addConductor(tileI);
            }

            if(((IConduitInterface)tile).getInterfaceType() != ConduitInterfaceType.OTHER) {

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

        for(int i = 0; i < itemInterface.size(); i++) {

            if(itemInterface.get(i) instanceof IConduitInterface && itemInterface.get(i) instanceof IInventory) {

                if(itemInterface.get(i) == null) {

                    itemInterface.remove(i);
                    return;
                }

                if(worldObj == null) {

                    worldObj = itemInterface.get(i).worldObj;
                }

                if(worldObj.getBlockId(itemInterface.get(i).xCoord, itemInterface.get(i).yCoord, itemInterface.get(i).zCoord) == 0) {

                    itemInterface.remove(i);
                    return;
                }

                if(((IConduitInterface)itemInterface.get(i)).importingToNetwork()) {

                    for(int z = 0; z < itemInterface.size(); z++) {

                        if(itemInterface.get(z) instanceof IConduitInterface && itemInterface.get(z) instanceof IInventory) {

                            if(itemInterface.get(z) == null) {

                                itemInterface.remove(i);
                                return;
                            }

                            if(worldObj == null) {

                                worldObj = itemInterface.get(z).worldObj;
                            }

                            if(worldObj.getBlockId(itemInterface.get(z).xCoord, itemInterface.get(z).yCoord, itemInterface.get(z).zCoord) == 0) {

                                itemInterface.remove(i);
                                return;
                            }

                            if(!(itemInterface.get(z) == itemInterface.get(i))) {

                                if(!((IConduitInterface)itemInterface.get(z)).importingToNetwork()) {

                                    this.moveInventory((IInventory)itemInterface.get(i), (IInventory)itemInterface.get(z));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveInventory(IInventory from, IInventory to) {

        for(int i = 0; i < from.getSizeInventory(); i++) {

            if(from.getStackInSlot(i) != null) {

                for(int z = 0; z < to.getSizeInventory(); z++) {

                    if(to.getStackInSlot(z) != null) {

                        
                    }
                    else {

                        to.setInventorySlotContents(z, from.getStackInSlot(i));
                        from.setInventorySlotContents(i, null);

                    }
                }
            }
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
                            else {

                                ((TileTCConduit)tileI).overrideNetwork(this);
                                this.addConductor((TileTCConduit) tileI);
                            }
                        }                                
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

                            default:
                                break;

                        }
                    }
                }
            }
        }
    }
}

