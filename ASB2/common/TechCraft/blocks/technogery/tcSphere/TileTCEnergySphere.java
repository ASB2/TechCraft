package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.ItemRegistry;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.*;

public class TileTCEnergySphere extends TechCraftTile implements IPowerStorage {
    
    int powerStored;
    int powerMax = 1000;
    int color = 0;

    public void updateEntity() {
        this.managePowerAll(this, powerInput(), false);
        super.updateEntity();
    }    

    public void setColor(Item item) {

        if(item != null) {

            if(item == ItemRegistry.ItemAirCrystalShard) {
                color = 1;
            }

            if(item == ItemRegistry.ItemEarthCrystalShard) {
                color = 2;
            }

            if(item == ItemRegistry.ItemFireCrystalShard) {
                color = 3;
            }

            if(item == ItemRegistry.ItemWaterCrystalShard) {
                color = 4;
            }
        }
    }

    @Override
    public boolean outputPower() {

        return true;
    }

    @Override
    public boolean recievePower() {

        return true;
    }

    @Override
    public String getName() {

        return "Energy Sphere";
    }

    @Override
    public int getPowerStored() {

        return powerStored;
    }

    @Override
    public int getPowerMax() {

        return powerMax;
    }

    public int getColor(){

        return color;
    }

    @Override
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            this.powerStored = powerStored + PowerGained;

            return true;
        }

        return false;
    }

    @Override
    public boolean usePower(int PowerUsed) {

        if(powerStored >= PowerUsed) {

            powerStored = powerStored - PowerUsed;

            return true;
        }

        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);
        powerStored = par1NBTTagCompound.getInteger("powerStored");
        color = par1NBTTagCompound.getInteger("color");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("powerStored", powerStored);
        par1NBTTagCompound.setInteger("color", color);        
    }
}

