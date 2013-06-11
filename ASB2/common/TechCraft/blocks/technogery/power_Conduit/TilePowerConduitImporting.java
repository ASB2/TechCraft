package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSource;
import TechCraft.power.IPowerStorage;

public class TilePowerConduitImporting extends TechCraftTile {

    int powerMax = 10;
    int powerStored;

    @Override
    public void updateEntity() {
        super.updateEntity();
        this.managePowerAll(this,powerInput(),false);
        
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    public int powerOutput(){

        return 10;
    }

    public int powerInput(){

        return 10;
    }

    @Override
    public String getName() {

        return "TechCraft Conduit(Importing)";
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
    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        if(this.powerStored >= PowerUsed){

            this.powerStored = this.powerStored - PowerUsed;

            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained, ForgeDirection direction) {

        if(this.powerMax - this.powerStored >= PowerGained){

            powerStored = powerStored + PowerGained;

            return true;
        }
        return false;
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);

        if(tile != null){

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

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

