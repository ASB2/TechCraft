package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.ItemRegistry;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerStorage;

public class TileTCEnergySphere extends TechCraftTile implements IPowerStorage {

    int powerStored;
    int powerMax = 1000;

    public void updateEntity() {

        super.managePowerAll(this, powerInput(), false);
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

    @Override
    public boolean gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained) {

            this.powerStored= powerStored + PowerGained;

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

