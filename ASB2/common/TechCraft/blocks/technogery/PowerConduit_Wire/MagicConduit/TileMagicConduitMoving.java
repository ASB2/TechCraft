package TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerConductor;

public class TileMagicConduitMoving extends TechCraftTile implements IPowerConductor {

    public void updateEntity() {
        super.updateEntity();
        
        if(network != null){
           // network.updateNetwork();
        }
    }
    
    @Override
    public String getName() {

        return "TechCraft Conduit(Moving)";
    }

    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if( tile instanceof TileMagicConduitImporting || tile instanceof TileMagicConduitMoving || tile instanceof TileMagicConduitExporting) {

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

    @Override
    public int[] getPosition() {

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }
}