package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.fx.FXBeam;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilPower;
import TechCraft.vector.Vector3;


public class TileTCEnergySphere extends TechCraftTile implements IPowerMisc {

    int distance = 50;
    FXBeam beam;

    public TileTCEnergySphere() {

        this.powerProvider = new PowerProviderTileEnergySphere(this, 1000, PowerClass.LOW);
    }

    public void updateEntity() {

        IPowerMisc tile;

        tile = findConductor(ForgeDirection.DOWN);
        if(tile != null) {
            renderBeam(tile);
        }

        tile = findConductor(ForgeDirection.UP);
        if(tile != null) {
            renderBeam(tile);
        }

        tile = findConductor(ForgeDirection.NORTH);
        if(tile != null) {
            renderBeam(tile);
        }

        tile = findConductor(ForgeDirection.SOUTH);
        if(tile != null) {
            renderBeam(tile);
        }

        tile = findConductor(ForgeDirection.EAST);
        if(tile != null) {
            renderBeam(tile);
        }

        tile = findConductor(ForgeDirection.WEST);
        if(tile != null) {
            renderBeam(tile);
        }

        if(getBlockMetadata() != 1) {
            int coords[] = UtilDirection.translateDirectionToCoords(this.getOrientation(), xCoord, yCoord, zCoord);
            TileEntity tileI = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);

            if(tileI == null) {

                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
            }
        }
    }

    public void renderBeam(IPowerMisc tile) {

        if(tile.getPowerProvider() != null) {

            int coords[] = tile.getPosition();

            int renderTime = 10;

            beam = new FXBeam(worldObj, new Vector3(this.xCoord + .5, this.yCoord + .5, this.zCoord + .5), new Vector3(coords[0] + .5, coords[1] + .5, coords[2] + .5), 1, 1, 1, renderTime, 20F);
            Minecraft.getMinecraft().effectRenderer.addEffect(beam);

            if(this.getPowerProvider().getCurrentState() == State.OTHER) {

                if(tile.getPowerProvider().getCurrentState() == State.OTHER) {

                    if(tile.getPowerProvider().requestingPower() && this.getPowerProvider().outputtingPower()) {

                        UtilPower.transferPower(this, tile);
                    }

                    if(tile.getPowerProvider().outputtingPower() && this.getPowerProvider().requestingPower()) {

                        UtilPower.transferPower(tile, this);
                    }
                }
                
                if(tile.getPowerProvider().getCurrentState() == State.SINK) {

                    UtilPower.transferPower(this, tile);
                }
                
                if(tile.getPowerProvider().getCurrentState() == State.SOURCE) {

                    UtilPower.transferPower(tile, this);
                }
            }
        }
    }

    public IPowerMisc findConductor(ForgeDirection side) {

        int x = xCoord ;
        int y = yCoord;
        int z = zCoord;

        for(int i = 0; i <= distance; i++) {

            if(!(side.offsetX == 0)) {

                if(side.offsetX > 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x + i, y, z);

                    if(tile != null && tile != this) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }  
                    }
                }

                if(side.offsetX < 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x - i, y, z);

                    if(tile != null && tile != this) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }  
                    }
                }
            }

            if(!(side.offsetY == 0)) {

                if(side.offsetY > 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x, y + i, z);

                    if(tile != null && tile != this) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }  
                    }
                }

                if(side.offsetY < 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x, y - i, z);

                    if(tile != null && tile != this) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }  
                    }
                }
            }

            if(!(side.offsetZ == 0)) {

                if(side.offsetZ > 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x, y, z + i);

                    if(tile != null) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }   
                    }
                }

                if(side.offsetZ < 0) {

                    TileEntity tile = worldObj.getBlockTileEntity(x, y, z - i);

                    if(tile != null) {

                        if(tile instanceof IPowerMisc && ((IPowerMisc)tile).getPowerProvider() != null && tile != this) {

                            return (IPowerMisc)tile;
                        }   
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {

        return "Energy Sphere";
    }
}

