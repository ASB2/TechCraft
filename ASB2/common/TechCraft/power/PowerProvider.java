package TechCraft.power;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class PowerProvider {

    TileEntity tile;

    protected int powerStored;
    protected int powerMax;
    protected int powerInput;
    protected int powerOutput;
    protected boolean recievePower;
    protected boolean outputPower;

    public PowerProvider(TileEntity tile, int powerMax, int powerInput, int powerOutput, boolean outputPower, boolean recevePower) {

        this.tile = tile;
        this.powerMax = powerMax;
        this.powerInput = powerInput;
        this.powerOutput = powerOutput;
        this.recievePower = recevePower;
        this.outputPower = outputPower;
    }

    /**
     * Get the amount of power stored in the block
     * @return Amount of power stored
     */
    public int getPowerStored() {

        return powerStored;
    }

    /**
     * Get maximum power capacity of the block
     */
    public int getPowerMax() {

        return powerMax;
    }

    public boolean recievePower() {

        return this.recievePower;
    }

    public boolean outputPower() {

        return this.outputPower;
    }

    public boolean gainPower(int PowerGained, ForgeDirection direction) {

        if(this.getPowerMax() - this.getPowerStored() >= PowerGained) {

            this.powerStored = this.getPowerStored() + PowerGained;
            
            return true;
        }
        return false;
    }

    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        if(this.getPowerStored() >= PowerUsed) {

            powerStored = this.getPowerStored() - PowerUsed;

            return true;
        }
        return false;
    }

    public void setPower(int newPower) {

        if(newPower >= 0) {
            
            this.powerStored = newPower;
        }
    }
    
    public int getOutput() {

        return powerOutput;
    }

    public int getInput() {

        return powerInput;
    }

    public boolean requestingPower(ForgeDirection direction) {

        if(getPowerStored() < getPowerMax())
            return true;

        return false;
    }

    public boolean outputtingPower(ForgeDirection direction) {

        if(getPowerStored() > 0)
            return true;

        return false;
    }

    public boolean canGainPower(int power) {

        if(getPowerMax() - getPowerStored() >= power) {

            return true;
        }

        else {
            return false; 
        }
    }

    public boolean canUsePower(int power) {

        if(getPowerStored() >= power) {

            return true;
        }
        else {

            return false;
        }
    }

    public void readFromNBT(NBTTagCompound tagCompound) {

        powerStored = tagCompound.getInteger("powerStored");
        
        powerMax = tagCompound.getInteger("powerMax");
        powerInput = tagCompound.getInteger("powerInput");
        powerOutput = tagCompound.getInteger("powerOutput");
        recievePower = tagCompound.getBoolean("recievePower");
        outputPower = tagCompound.getBoolean("outputPower");
    }

    public void writeToNBT(NBTTagCompound tagCompound) {

        tagCompound.setInteger("x", tile.xCoord);
        tagCompound.setInteger("y", tile.yCoord);
        tagCompound.setInteger("z", tile.zCoord);
        
        tagCompound.setInteger("powerStored", powerStored);
        tagCompound.setInteger("powerMax", powerMax);
        tagCompound.setInteger("powerInput", powerInput);
        tagCompound.setInteger("powerOutput", powerOutput);
        tagCompound.setBoolean("recievePower", recievePower);
        tagCompound.setBoolean("outputPower", outputPower);
    }
}
