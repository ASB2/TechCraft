package TechCraft.blocks.technogery;

import net.minecraft.nbt.NBTTagCompound;
import TechCraft.blocks.TechCraftTile;
import TechCraft.interfaces.power.IPowerSink;

public class TileTechnogryFocus extends TechCraftTile implements IPowerSink{

    int powerStored = 0;
    int powerMax = 100;

    public TileTechnogryFocus(){
    }

    public void updateEntity() {

        //worldObj.setBlock(translateDirectionToCoords()[0], translateDirectionToCoords()[1], translateDirectionToCoords()[2], BlockRegistry.BlockAirCrystalOre.blockID);
        //worldObj.spawnEntityInWorld(new EntityTest(worldObj,translateDirectionToCoords()[0],translateDirectionToCoords()[1],translateDirectionToCoords()[2]));

    }

    @Override
    public String getName() {

        return "Technogry Focus";
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
        
        if(powerStored > PowerUsed) {

            powerStored = powerStored - PowerUsed;
        }
    }

    public boolean recievePower() {

        return true;
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);

    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);

    }
}
