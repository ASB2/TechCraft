package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.*;

public class TilePowerConduitExporting extends TechCraftTile implements IPowerConductor {
    
    
    int powerStored;
    int powerMax = 10;
    
    @Override
    public void updateEntity() {
        super.updateEntity();
        this.managePowerAll(this, powerOutput(), true);
    }

    @Override
    public boolean outputPower() {

        return true;
    }

    public int powerOutput(){

        return 10;
    }

    public int powerInput(){

        return 10;
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
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
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

            this.powerStored = this.powerStored + PowerGained;
            return true;
        }
        return false;
    }


    @Override
    public String getName() {

        return "TechCraft Conduit(Exporting)";
    }

    @Override
    public int[] getPosition() {

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);
        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

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
}

