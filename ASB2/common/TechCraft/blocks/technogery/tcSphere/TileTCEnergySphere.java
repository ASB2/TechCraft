package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.ItemRegistry;
import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.IPowerStorage;

public class TileTCEnergySphere extends TechCraftTile implements IPowerStorage {

    int powerStored;
    int powerMax = 1000;

    public void updateEntity() {
        if(getPowerStored() >= getOutputMax()) {

            super.managePowerAll(this, getOutputMax(), false);        
        }
        else{
            super.managePowerAll(this, getOutputMin(), false);    
        }
    }    

    public void setColor(Item item) {

        if(item != null) {

            if(item == ItemRegistry.ItemAirCrystalShard) {
                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);
            }

            if(item == ItemRegistry.ItemEarthCrystalShard) {
                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 2, 3);
            }

            if(item == ItemRegistry.ItemFireCrystalShard) {
                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 3, 3);
            }

            if(item == ItemRegistry.ItemWaterCrystalShard) {
                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 4, 3);
            }
        }
    }

    @Override
    public int getOutputMax() {
        return 10;
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

