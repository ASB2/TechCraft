package TechCraft.blocks.technogery;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.ItemRegistry;
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

    @Override
    public boolean outputPower() {

        return true;
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
    public boolean usePower(int PowerUsed) {

        if(this.powerStored>=PowerUsed){
            this.powerStored= powerStored-PowerUsed;
            return true;
        }
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {

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
