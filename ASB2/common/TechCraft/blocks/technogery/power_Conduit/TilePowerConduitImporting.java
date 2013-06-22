package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerSource;
import TechCraft.power.IPowerStorage;

public class TilePowerConduitImporting extends TechCraftTile {

    int powerMax = 10;
    int powerStored;

    @Override
    public void updateEntity() {
        super.updateEntity();        
    }

    @Override
    public String getName() {

        return "TechCraft Conduit(Importing)";
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);

        if(tile != null){

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerSource || tile instanceof IPowerStorage) {

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

