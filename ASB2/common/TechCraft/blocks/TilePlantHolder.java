package TechCraft.blocks;

import net.minecraft.tileentity.TileEntity;

public class TilePlantHolder extends TechCraftTile {

    TileEntity farmCore;
    
    public TilePlantHolder(TileEntity tile){
        farmCore = tile;
    }

    public TilePlantHolder(){

    }
}
