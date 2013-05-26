package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerConductor;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerNetwork;

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

        updateEnergy();
    }

    private void updateEnergy() {

        int powerDivided = powerOutput();

        if(super.getTilesNextTo(this.xCoord, this.yCoord, this.zCoord, worldObj) > 0) {

            powerDivided =  powerDivided / super.getTilesNextTo(this.xCoord, this.yCoord, this.zCoord, worldObj);
        }

        transferEnergy(ForgeDirection.DOWN, powerDivided);
        transferEnergy(ForgeDirection.UP, powerDivided);
        transferEnergy(ForgeDirection.NORTH, powerDivided);
        transferEnergy(ForgeDirection.SOUTH, powerDivided);
        transferEnergy(ForgeDirection.WEST, powerDivided);
        transferEnergy(ForgeDirection.EAST, powerDivided);
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

    public void addImportingAround(){
        addImportingAround(ForgeDirection.DOWN);
        addImportingAround(ForgeDirection.UP);
        addImportingAround(ForgeDirection.NORTH);
        addImportingAround(ForgeDirection.SOUTH);
        addImportingAround(ForgeDirection.WEST);
        addImportingAround(ForgeDirection.EAST);
    }

    public void addImportingAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }


                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }


                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }


                    }            
                    break;
                }
                case SOUTH: {

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }


                    }
                    break;

                }
                case UP: {

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }


                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof TileMagicConduitImporting) {

                        if(((TileMagicConduitImporting)tile).network == null) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
                        }

                        else if(((TileMagicConduitImporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitImporting)tile).overrideNetwork(network);
                            network.addImporting((TileMagicConduitImporting) tile);
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

    public void addExportingAround(){
        addExportingAround(ForgeDirection.DOWN);
        addExportingAround(ForgeDirection.UP);
        addExportingAround(ForgeDirection.NORTH);
        addExportingAround(ForgeDirection.SOUTH);
        addExportingAround(ForgeDirection.WEST);
        addExportingAround(ForgeDirection.EAST);
    }

    public void addExportingAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }


                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }


                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }


                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }


                    }
                    break;

                }
                case UP: {

                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }


                    }
                    break;
                }
                case WEST: {
                    if(tile instanceof TileMagicConduitExporting) {

                        if(((TileMagicConduitExporting)tile).network == null) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
                        }

                        else if(((TileMagicConduitExporting)tile).network.getAge() < this.network.getAge()) {

                            ((TileMagicConduitExporting)tile).overrideNetwork(network);
                            network.addExporting((TileMagicConduitExporting) tile);
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

    public void transferEnergy(ForgeDirection direction, int amount) {

        TileEntity tile = worldObj.getBlockTileEntity(super.translateDirectionToCoords(direction)[0], super.translateDirectionToCoords(direction)[1], super.translateDirectionToCoords(direction)[2]);

        switch(direction) {

            case DOWN: {

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
                        }
                    }
                }
                break;
            }

            case EAST:{

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
                        }
                    }
                }
                break;
            }
            case NORTH: {

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
                        }
                    }
                }
                break;
            }
            case SOUTH: {

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
                        }
                    }
                }
                break;

            }
            case UP: {

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
                        }
                    }
                }
                break;
            }
            case WEST: {

                if(tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                    if(this.getPowerStored() >= amount && ((IPowerMisc) tile).getPowerMax() - ((IPowerMisc) tile).getPowerStored() >= amount){

                        if(((IPowerMisc) tile).gainPower(amount)) {

                            this.usePower(amount);
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