package TechCraft.interfaces.power;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class PowerNetwork {

    private final HashMap<TileEntity, int[]> conductors = new HashMap<TileEntity, int[]>();

    TileEntity powerNetworkStart;

    World worldObj;

    public PowerNetwork(TileEntity networkCore, World world){
        powerNetworkStart = networkCore;
        worldObj = world;
    }

    public void updateCore(){
        balanceEnergy();
    }
    public void balanceEnergy(){
        
    }
    /**
     *Adds Conductors to the hashMap
     */
    public void addConductor(TileEntity tile, World world){
        conductors.put(tile, new int[]{tile.xCoord,tile.yCoord,tile.zCoord});
    }

    public void removeConductor(TileEntity tile, World world){
        conductors.remove(tile);
    }

    /**
     *Gets Conductors and adds them to the Hashmap
     */
    public void getConductorsInRange(int xCoordtoCheck, int yCoordtoCheck, int zCoordtoCheck){


        //if(this.getDistance(powerNetworkStart.xCoord, powerNetworkStart.yCoord, powerNetworkStart.zCoord, xCoordtoCheck, yCoordtoCheck, zCoordtoCheck) <= 5){

        //}
    }

    /**
     * Gets the distance to the position. Args: First x, First y, First z, Last x, Last y, Last z
     */
    public double getDistance(double startX, double startY, double startZ,int endX,int endY,int endZ)
    {
        double d3 = endX - startX;
        double d4 = endY - startY;
        double d5 = endZ - startZ;
        return (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
    }
}
