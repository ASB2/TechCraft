package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.EnumPowerClass;
import TechCraft.interfaces.power.IPowerConductor;

public class TileMagicConduitExporting extends TechCraftTile implements IPowerConductor{

    int powerStored;
    int powerMax = 10;
    

    @Override
    public void updateEntity() {
        super.managePowerAll(this,getOutputMin(),true);
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
    public int getOutputMin() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean outputPower() {
        return true;
    }

    @Override
    public int getPowerStored() {
        // TODO Auto-generated method stub
        return powerStored;
    }

    @Override
    public int getPowerMax() {
        // TODO Auto-generated method stub
        return powerMax;
    }

    @Override
    public void usePower(int PowerUsed) {
        if(this.powerStored >= PowerUsed){
            this.powerStored = this.powerStored - PowerUsed;
        }
    }

    @Override
    public void gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){
            this.powerStored = this.powerStored + PowerGained;
        }
    }


    @Override
    public String getName() {

        return "TechCraft Conduit(Exporting)";
    }

    @Override
    public EnumPowerClass getPowerClass() {

        return EnumPowerClass.Low;
    }

    @Override
    public double getRange() {

        return 0;
    }

    @Override
    public int[] getPosition() {

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }

    @Override
    public int getPrecentFilled() {
        // TODO Auto-generated method stub
        return (100/ this.getPowerMax()* this.getPowerStored());
    }
    
    public boolean getRenderBottom() {

        TileEntity tile = worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

    public boolean getRenderTop(){

        TileEntity tile = worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

    public boolean getRenderLeft(){

        TileEntity tile = worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

    public boolean getRenderRight(){

        TileEntity tile = worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

    public boolean getRenderBack(){

        TileEntity tile = worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

    public boolean getRenderFront(){

        TileEntity tile = worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.recievePower()){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            return false;
        }
    }

}

