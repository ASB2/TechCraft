package TechCraft.blocks.technogery;

import TechCraft.blocks.TechCraftTile;

public class TileTestBlock extends TechCraftTile {

    int powerStored = 0;
    int powerMax = 0;
    
    public void onUpdateEntity(){

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

        return "Test Block";
    }
}
