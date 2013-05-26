package TechCraft.power;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PowerNetwork {

    private List myList = new ArrayList();
    
    private HashMap<TileEntity, int[]> conductors = new HashMap<TileEntity, int[]>();

    @SuppressWarnings("unused")
    private World worldObj;

    private TileEntity tileCore;

    int powerStored = 0;
    int powerMax = conductors.size() * ((IPowerMisc) tileCore).getPowerMax();
    
    public PowerNetwork(World world, TileEntity tile) {    

        worldObj = world;
        this.tileCore = tile;
    }

    public void updateNetwork() {

    }

    public void addConductor(TileEntity tile) {

        conductors.put(tile, new int[] {tile.xCoord, tile.yCoord, tile.zCoord});
    }
}
