package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;

public class TileTestBlock extends TechCraftTile {

    int powerStored = 1000;
    int powerMax = 1000;

    public void updateEntity(){
        this.managePowerAll(this, true);
        
    }

    @Override
    public String getName() {

        return "Test Block";
    }
}
