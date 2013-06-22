package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.ItemRegistry;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerStorage;
import TechCraft.power.PowerProvider;

public class TileTCEnergySphere extends TechCraftTile implements IPowerStorage {
    
    int color = 0;

    public TileTCEnergySphere() {
    
        this.powerProvider = new PowerProvider(this, 1000, 1, 1, true, true);
    }
    
    public void updateEntity() {
        
        this.managePowerAll(this, false);
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
    public String getName() {

        return "Energy Sphere";
    }

    public int getColor(){

        return color;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
        super.readFromNBT(par1NBTTagCompound);
        
        color = par1NBTTagCompound.getInteger("color");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
        super.writeToNBT(par1NBTTagCompound);

        par1NBTTagCompound.setInteger("color", color);        
    }
}

