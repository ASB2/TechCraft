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

    public TileMagicConduitMoving(){

        network = new PowerNetwork(worldObj, this);
    }

    public void updateEntity() {
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

    public void addConductor(TileEntity tile) {
        network.addConductor(tile);
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
    }

    @Override
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setInteger("powerStored", powerStored);

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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }
}