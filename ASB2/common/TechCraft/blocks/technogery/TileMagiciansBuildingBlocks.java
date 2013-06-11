package TechCraft.blocks.technogery;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSource;

public class TileMagiciansBuildingBlocks extends TechCraftTile implements IPowerSource {
    
    int powerStored = 0;
    int powerMax = 25;

    @Override
    public void updateEntity() {
        if(this.getPowerStored() > 0) {

            super.managePowerAll(this, powerOutput(),true);
        }

    }

    public void setPowerStored(int power) {

        if(power >= 0) {
            
            this.powerStored = power;       
        }
    }
    
    @Override
    public boolean outputPower() {

        return true;
    }

    @Override
    public boolean usePower(int PowerUsed, ForgeDirection direction) {

        if(this.powerStored>=PowerUsed){
            this.powerStored= powerStored-PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained, ForgeDirection direction) {

        if(this.powerMax - this.powerStored >= PowerGained){
            this.powerStored= powerStored + PowerGained;
            return true;
        }
        return false;
    }

    @Override
    public int powerOutput() {

        return 1;
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

        return "Magician's Building Block";
    }
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        powerStored = tagCompound.getInteger("powerStored");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("powerStored", powerStored);
    }
}
