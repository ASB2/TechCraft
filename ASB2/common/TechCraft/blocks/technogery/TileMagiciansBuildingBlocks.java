package TechCraft.blocks.technogery;

import net.minecraft.nbt.NBTTagCompound;
import TechCraft.blocks.TechCraftTile;

public class TileMagiciansBuildingBlocks extends TechCraftTile {

    TechCraftTile pNet;    

    int powerStored = 0;
    int powerMax = 50;

    @Override
    public void updateEntity() {
        if(this.getPowerStored() > 0){
            super.managePowerAll(this, getOutputMin(),true);
        }
        
    }

    @Override
    public void usePower(int PowerUsed) {
        
        if(this.powerStored>=PowerUsed){
            this.powerStored= powerStored-PowerUsed;
        }
    }

    @Override
    public void gainPower(int PowerGained) {

        if(this.powerMax - this.powerStored >= PowerGained){
            this.powerStored= powerStored + PowerGained;
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
    public boolean recievePower() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean outputPower() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public int getOutputMax() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public int getOutputMin() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
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
