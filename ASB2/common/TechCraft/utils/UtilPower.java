package TechCraft.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.conduit.EnumContuitType;
import TechCraft.conduit.IConduitConductor;
import TechCraft.power.IPowerMisc;

public class UtilPower {

    /**
     * The amount of ticks under a condution to gain power a power gen block will gain power    
     */
    public static int TICKSTOPOWER = 10;

    public static TileEntity getNearestPowerSource(World world, TileEntity tile) {

        if(UtilDirection.getArrayTilesAround(world, tile).length > 0) {

            int length = UtilDirection.getArrayTilesAround(world, tile).length;
            TileEntity[] tilesAround = UtilDirection.getArrayTilesAround(world, tile);

            for(int i = 0; i < length; i++) {

                if(tilesAround[i] != null) {

                    if(tilesAround[i] instanceof IPowerMisc) {

                        if(((IPowerMisc)tilesAround[i]).getPowerProvider() != null) {

                            if(((IPowerMisc)tilesAround[i]).getPowerProvider().outputPower()) {

                                return tile;
                            }
                        }
                    }

                    if(tilesAround[i] instanceof IConduitConductor) {

                        if(((IConduitConductor)tilesAround[i]).getConductorType() == EnumContuitType.TCU) {
                            
                            return UtilPower.getNearestPowerSource(world, tilesAround[i]);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static TileEntity getNearestPowerSink(World world, TileEntity tile) {

        if(UtilDirection.getArrayTilesAround(world, tile).length > 0) {

            int length = UtilDirection.getArrayTilesAround(world, tile).length;
            TileEntity[] tilesAround = UtilDirection.getArrayTilesAround(world, tile);

            for(int i = 0; i < length; i++) {

                if(tilesAround[i] != null) {

                    if(tilesAround[i] instanceof IPowerMisc) {

                        if(((IPowerMisc)tilesAround[i]).getPowerProvider() != null) {

                            if(((IPowerMisc)tilesAround[i]).getPowerProvider().recievePower()) {

                                return tile;
                            }
                        }
                    }

                    if(tilesAround[i] instanceof IConduitConductor) {

                        if(((IConduitConductor)tilesAround[i]).getConductorType() == EnumContuitType.TCU) {
                            
                            return UtilPower.getNearestPowerSource(world, tilesAround[i]);
                        }
                    }
                }
            }
        }
        return null;
    }
}
