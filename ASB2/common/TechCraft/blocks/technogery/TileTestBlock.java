package TechCraft.blocks.technogery;

import java.util.Random;

import TechCraft.blocks.TechCraftTile;

public class TileTestBlock extends TechCraftTile {

    int powerStored = 1000;
    int powerMax = 1000;

    public void updateEntity(){
        this.managePowerAll(this, true);
        

        Random rand = new Random();
        
        float f = (rand.nextFloat() - 0.5F) * 8.0F;
        float f1 = (rand.nextFloat() - 0.5F) * 4.0F;
        float f2 = (rand.nextFloat() - 0.5F) * 8.0F;
        
        worldObj.spawnParticle("hugeexplosion", this.xCoord + (double)f, this.yCoord + 2.0D + (double)f1, this.zCoord + (double)f2, 0D,0D,0D);

    }

    @Override
    public String getName() {

        return "Test Block";
    }
}
