package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerConductor;
import TechCraft.power.PowerNetwork;

public class TilePowerConduitMoving extends TechCraftTile implements IPowerConductor {

    PowerNetwork network;
    
    public void updateEntity() {
        
        super.updateEntity();
        
        if(network != null) {
            
           network.updateNetwork();
        }
        else {
            network = new PowerNetwork(worldObj, this);
        }
    }
    
    @Override
    public String getName() {

        return "TechCraft Conduit(Moving)";
    }

    
    @Override
    public int[] getPosition() {

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }


    public PowerNetwork getNetwork() {

        return network;
    }


    public void overrideNetwork(PowerNetwork network) {

        this.network = network;
    }
    
    public boolean decideRender(ForgeDirection direction) {

        TileEntity tile = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);

        if(tile != null) {

            switch(direction) {

                case DOWN: {

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

                        return true;
                    }
                    break;
                }

                case EAST:{

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

                        return true;
                    }
                    break;

                }
                case UP: {

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

                        return true;
                    }
                    break;
                }
                case WEST: {

                    if( tile instanceof TilePowerConduitImporting || tile instanceof TilePowerConduitMoving || tile instanceof TilePowerConduitExporting) {

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