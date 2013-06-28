package TechCraft.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.conduit.EnumContuitType;
import TechCraft.conduit.IConduitConductor;
import TechCraft.power.IPowerMisc;
import TechCraft.power.TransferMode;

public class UtilPower {

    public static int LOW_POWER = 1;
    public static int MID_POWER = 10;
    public static int HIGH_POWER = 100;
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

                            if(((IPowerMisc)tilesAround[i]).getPowerProvider().getTransferMode() == TransferMode.SOURCE) {

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

                            if(((IPowerMisc)tilesAround[i]).getPowerProvider().getTransferMode() == TransferMode.SINK) {

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

    public static boolean transferPower(IPowerMisc powerSource, IPowerMisc powerSink) {

        int amountOfPower = 0;

        switch(powerSource.getPowerProvider().getPowerClass()) {

            case LOW: amountOfPower = LOW_POWER; break;
            case MID: amountOfPower = MID_POWER; break;
            case HIGH: amountOfPower = HIGH_POWER; break;
            default: amountOfPower = 1;
        }

        if (powerSink.getPowerProvider() != null && powerSource.getPowerProvider() != null) {

            if(powerSink.getPowerProvider().canGainPower(amountOfPower)) {

                if(powerSource.getPowerProvider().canUsePower(amountOfPower)) {
                    
                    if(powerSink.getPowerProvider().gainPower(amountOfPower, UtilDirection.translateDirectionToOpposite(powerSource.getOrientation()))) {

                        powerSource.getPowerProvider().usePower(amountOfPower, powerSource.getOrientation());

                        return true;
                    }
                }
            }
        }
        return false;
    }
}
