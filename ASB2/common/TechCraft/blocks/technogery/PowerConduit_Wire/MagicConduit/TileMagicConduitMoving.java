package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.EnumPowerClass;
import TechCraft.interfaces.power.IPowerConductor;
import TechCraft.interfaces.power.IPowerMisc;

public class TileMagicConduitMoving extends TechCraftTile implements IPowerConductor{

    int powerMax = 10;
    int powerStored = 0;


    public void updateEntity() {
        updateEnergy();
    }

    private void updateEnergy(){

        if(TechCraftTile.getTilesNextTo(xCoord,yCoord,zCoord,worldObj)> 0){

            int magicDivided = this.getPowerStored() / TechCraftTile.getTilesNextTo(xCoord,yCoord,zCoord,worldObj);

            this.addSideTop(xCoord, yCoord, zCoord, worldObj, this, magicDivided);
            this.addSideBottom(xCoord, yCoord, zCoord, worldObj, this, magicDivided);
            this.addSideLeft(xCoord, yCoord, zCoord, worldObj, this, magicDivided);
            this.addSideRight(xCoord, yCoord, zCoord, worldObj, this, magicDivided);
            this.addSideFront(xCoord, yCoord, zCoord, worldObj, this, magicDivided);
            this.addSideBack(xCoord, yCoord, zCoord, worldObj, this, magicDivided);

        }
    }

    @Override
    public int getOutputMin() {

        return 1;
    }


    public void addSideTop(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y+1, z);

        if(mTile != null && mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile) world.getBlockTileEntity(x, y+1, z);
            
                this.logicI(mTile2,pnet,powertoMove);
            
        }
    }

    public void addSideBottom(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y-1, z);

        if(mTile != null & mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile) world.getBlockTileEntity(x, y-1, z);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideLeft(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x-1, y, z);

        if(mTile != null & mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile) world.getBlockTileEntity(x-1, y, z);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideRight(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x+1, y, z);

        if(mTile != null & mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile) world.getBlockTileEntity(x+1, y, z);

            this.logicI(mTile2,pnet,powertoMove);            
        }
    }

    public void addSideFront(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y, z+1);

        if(mTile != null & mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile) world.getBlockTileEntity(x, y, z+1);

            this.logicI(mTile2,pnet,powertoMove);

        }
    }

    public void addSideBack(int x,int y,int z,World world,TechCraftTile pnet, int powertoMove){

        TileEntity mTile = world.getBlockTileEntity(x, y, z-1);

        if(mTile != null & mTile instanceof TileMagicConduitMoving || mTile instanceof TileMagicConduitExporting){

            TechCraftTile mTile2 = (TechCraftTile)world.getBlockTileEntity(x, y, z-1);
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
    public void usePower(int PowerUsed) {

        if(this.powerStored >= PowerUsed) {

            this.powerStored = this.powerStored - PowerUsed;
        }
    }

    @Override
    public void gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            powerStored = powerStored + PowerGained;
        }
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

    public boolean getRenderBottom(){
        if(worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    public boolean getRenderTop(){
        if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    public boolean getRenderLeft(){
        if(worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    public boolean getRenderRight(){
        if(worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    public boolean getRenderBack(){
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    public boolean getRenderFront(){
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1) instanceof TileMagicConduitImporting || (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1) instanceof TileMagicConduitExporting)|| (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1) instanceof TileMagicConduitMoving)){

            return true;  
        }

        else{
            return false;
        }
    }

    @Override
    public EnumPowerClass getPowerClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getRange() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int[] getPosition() {
        // TODO Auto-generated method stub
        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }

    @Override
    public int getPrecentFilled() {
        // TODO Auto-generated method stub
        return 0;
    }
}