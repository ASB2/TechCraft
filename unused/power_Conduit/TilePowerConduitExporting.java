package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSink;
import TechCraft.power.IPowerStorage;
import TechCraft.utils.UtilDirection;

public class TilePowerConduitExporting extends TechCraftTile {

    @Override
    public void updateEntity() {
        
    }
    
    @Override
    public String getName() {

        return "TechCraft Conduit(Exporting)";
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(UtilDirection.translateDirectionToCoords(direction, this)[0], UtilDirection.translateDirectionToCoords(direction, this)[1], UtilDirection.translateDirectionToCoords(direction, this)[2]);
        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerSink || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case UNKNOWN:
                    return false;

                default:
                    return false;
            }
        }
        return false;
    }
}

