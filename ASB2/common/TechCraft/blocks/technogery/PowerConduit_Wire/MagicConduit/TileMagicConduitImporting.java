package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerConductor;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerNetwork;

public class TileMagicConduitImporting extends TechCraftTile implements IPowerConductor{

    int powerMax = 10;
    int powerStored;

    @Override
    public void updateEntity() {
        super.managePowerAll(this,powerInput(),false);
        this.updateEnergy();
    }

    @Override
    public boolean recievePower() {

        return true;
    }
    
    private void updateEnergy(){
        if(TechCraftTile.getTilesNextTo(xCoord,yCoord,zCoord,worldObj)> 0) {
            
            int var1 = this.getPowerStored () / TechCraftTile.getTilesNextTo(xCoord,yCoord,zCoord,worldObj);

            this.addSideTop(xCoord, yCoord, zCoord, worldObj, this, var1);
            this.addSideBottom(xCoord, yCoord, zCoord, worldObj, this, var1);
            this.addSideLeft(xCoord, yCoord, zCoord, worldObj, this, var1);
            this.addSideRight(xCoord, yCoord, zCoord, worldObj, this, var1);
            this.addSideFront(xCoord, yCoord, zCoord, worldObj, this, var1);
            this.addSideBack(xCoord, yCoord, zCoord, worldObj, this, var1);

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
    public int getPowerStored() {
        return powerStored;
    }

    @Override
    public int getPowerMax() {
        return powerMax;
    }

    @Override
    public boolean usePower(int PowerUsed) {

        if(this.powerStored >= PowerUsed){

            this.powerStored = this.powerStored - PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){

            powerStored = powerStored + PowerGained;
            return true;
        }
        return false;
    }

    public void addSideTop(int x,int y,int z,World world, TechCraftTile pnet,int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y+1, z);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x, y+1, z);

            this.logicI(mTile2,pnet,powertoMove);
        }
    }

    public void addSideBottom(int x,int y,int z,World world,TechCraftTile pnet,int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y-1, z);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x, y-1, z);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideLeft(int x,int y,int z,World world, TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x-1, y, z);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x-1, y, z);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideRight(int x,int y,int z, World world, TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x+1, y, z);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x+1, y, z);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideFront(int x,int y,int z,World world,TechCraftTile pnet,int powertoMove ){

        TileEntity mTile = world.getBlockTileEntity(x, y, z+1);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x, y, z+1);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideBack(int x,int y,int z,World world,TechCraftTile pnet,int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y, z-1);

        if(mTile != null && mTile instanceof TileMagicConduitMoving) {

            IPowerMisc mTile2 = (IPowerMisc) world.getBlockTileEntity(x, y, z-1);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void logicI(IPowerMisc tiletoAdd, IPowerMisc tiletoSubtract, int amountToSubtract){

        if(tiletoAdd instanceof IPowerMisc && tiletoSubtract instanceof IPowerMisc) {

            IPowerMisc tiletoAddI = (IPowerMisc) tiletoAdd;
            IPowerMisc tiletoSubtractI = (IPowerMisc) tiletoSubtract;

            if(tiletoSubtractI.getPowerStored() >= amountToSubtract && tiletoAddI.getPowerMax() - tiletoAddI.getPowerStored() >= amountToSubtract){

                tiletoAddI.gainPower(amountToSubtract);
                tiletoSubtractI.usePower(amountToSubtract);
            }        
        }
    }

    @Override
    public String getName() {

        return "TechCraft Conduit(Importing)";
    }

    public boolean getRenderBottom() {

        TileEntity tile = worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord);

        if(tile instanceof TechCraftTile & !(tile instanceof IPowerConductor)) {

            TechCraftTile tile2 = (TechCraftTile)tile;

            if(tile2.outputPower()){
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

            if(tile2.outputPower()){
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

            if(tile2.outputPower()){
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

            if(tile2.outputPower()){
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

            if(tile2.outputPower()){
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

            if(tile2.outputPower()){
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

