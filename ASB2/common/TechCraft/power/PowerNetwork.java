package TechCraft.power;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PowerNetwork {

    private HashMap<TileEntity, int[]> conductors = new HashMap<TileEntity, int[]>();

    private World worldObj;
    private TileEntity tile;
    
    public PowerNetwork(World world, TileEntity tile) {    
        
        worldObj = world;
        this.tile = tile;
    }
    
    public void updateNetwork() {
        
    }
}
