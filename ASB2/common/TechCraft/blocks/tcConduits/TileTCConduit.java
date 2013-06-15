package TechCraft.blocks.tcConduits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.ConduitInterfaceType;
import TechCraft.conduit.ConduitNetwork;
import TechCraft.conduit.IConduitInterface;

public class TileTCConduit extends TechCraftTile implements IConduitInterface {

    ConduitNetwork network;

    public void updateEntity() {

        super.updateEntity();

        if(network != null) {

            network.updateNetwork();
        }
        else {
            network = new ConduitNetwork(worldObj, this);
        }
    }

    @Override
    public String getName() {

        return "TC Conduit";
    }

    public ConduitNetwork getNetwork() {

        return network;
    }

    public void overrideNetwork(ConduitNetwork network) {

        this.network = network;
    }

    public boolean decideRender(ForgeDirection direction) {

        switch(direction) {
            case DOWN: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }
            break;

            case EAST: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }
            break;

            case NORTH: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }
            break;

            case SOUTH: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }
            break;

            case UP: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }
            break;

            case WEST: {

                if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

                    if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null && TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCConduit) {

                        return true;
                    }                    

                }
            }            
            break;

            case UNKNOWN: {
                
                return false;
            }

            default: return false;

        }
        return false;
    }

    @Override
    public ConduitInterfaceType getInterfaceType() {
        
        return ConduitInterfaceType.OTHER;
    }

    @Override
    public boolean renderByDirection(ForgeDirection direction) {
        
        return true;
    }

    @Override
    public boolean importingToNetwork() {
        // TODO Auto-generated method stub
        return false;
    }
}