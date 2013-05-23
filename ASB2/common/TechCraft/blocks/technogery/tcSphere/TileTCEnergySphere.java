package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.IPowerStorage;
import TechCraft.interfaces.power.PowerNetwork;

public class TileTCEnergySphere extends TechCraftTile implements IPowerStorage {

    int powerStored;
    int powerMax = 1000;

    PowerNetwork networkCore;
    
    public TileTCEnergySphere(){

        networkCore = new PowerNetwork(this,worldObj);
    }
    
    
    public void updateEntity(){
        super.managePowerAll(this,getOutputMin(),true);
        //super.takeEnergyFromAjacentTiles(this);
        networkCore.updateCore();
    }
    
    @Override
    public void updateConnections() {


    }

    public void addConductor(TileEntity tile, World world){
        if(networkCore != null){
            networkCore.addConductor(tile,world);
        }
    }
    
    @Override
    public int getOutputMin(){
        
        return 1;
    }
    
    public int getPowerScaled(int scale) {

        int internal = (int)this.powerStored * scale / (int)powerMax;
        if(internal > scale){
            internal = scale;
        }
        return internal;
    }
    
    @Override
    public String getName() {

        return "Energy Sphere";
    }
    
    @Override
    public boolean recievePower() {

        return true;
    }

    @Override
    public boolean outputPower() {

        return true;
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
    public void gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){
            this.powerStored= powerStored + PowerGained;
        }
    }
    @Override
    public void usePower(int PowerUsed) {
        if(powerStored >= PowerUsed){
            powerStored = powerStored - PowerUsed;
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("powerStored", powerStored);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);
        powerStored = par1NBTTagCompound.getInteger("powerStored");
    }
}

