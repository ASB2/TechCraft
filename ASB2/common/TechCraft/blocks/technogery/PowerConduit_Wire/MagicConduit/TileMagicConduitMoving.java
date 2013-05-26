package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerConductor;
import TechCraft.power.IPowerMisc;
import TechCraft.power.*;

public class TileMagicConduitMoving extends TechCraftTile implements IPowerConductor{

    PowerNetwork network;

    int powerMax = 10;
    int powerStored = 0;
    public int age = 0;

    public TileMagicConduitMoving(){

        network = new PowerNetwork(worldObj, this);
    }

    public void updateEntity() {
        age++;

        if(network != null) {

            network.updateNetwork();
        }
    }

    public int powerOutput(){

        return 10;
    }

    public int powerInput(){

        return 10;
    }

    public void addConductorsAround(){
        addConductorsAround(ForgeDirection.DOWN);
        addConductorsAround(ForgeDirection.UP);
        addConductorsAround(ForgeDirection.NORTH);
        addConductorsAround(ForgeDirection.SOUTH);
        addConductorsAround(ForgeDirection.WEST);
        addConductorsAround(ForgeDirection.EAST);
    }

    public void addConductorsAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
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

    public void addSourceAround(){
        addSourceAround(ForgeDirection.DOWN);
        addSourceAround(ForgeDirection.UP);
        addSourceAround(ForgeDirection.NORTH);
        addSourceAround(ForgeDirection.SOUTH);
        addSourceAround(ForgeDirection.WEST);
        addSourceAround(ForgeDirection.EAST);
    }

    public void addSourceAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }         
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
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

    public void addSinkAround(){
        addSinkAround(ForgeDirection.DOWN);
        addSinkAround(ForgeDirection.UP);
        addSinkAround(ForgeDirection.NORTH);
        addSinkAround(ForgeDirection.SOUTH);
        addSinkAround(ForgeDirection.WEST);
        addSinkAround(ForgeDirection.EAST);
    }

    public void addSinkAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
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
    
    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        powerStored = var1.getInteger("powerStored");
        age = var1.getInteger("age");
    }

    @Override
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setInteger("powerStored", powerStored);
        var1.setInteger("age", age);

    }

    @Override
    public boolean usePower(int PowerUsed) {

        if(this.powerStored >= PowerUsed) {

            this.powerStored = this.powerStored - PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            powerStored = powerStored + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
    }

    @Override
    public String getName() {

        return "TechCraft Conduit(Moving)";
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case UNKNOWN:
                    return false;

                default:
                    return false;
            }
        }

        return false;
    }

    @Override
    public int[] getPosition() {

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }

    @Override
    public PowerNetwork getNetwork() {

        return network;
    }

    @Override
    public void overrideNetwork(PowerNetwork network) {

        if(this.network != null) {

            this.network.removeConductor(this);
        }

        this.network = network;        
    }
}