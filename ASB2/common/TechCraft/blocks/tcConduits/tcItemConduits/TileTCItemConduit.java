package TechCraft.blocks.tcConduits.tcItemConduits;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.ConduitNetwork;
import TechCraft.conduit.EnumContuitType;
import TechCraft.conduit.IConduitConductor;
import TechCraft.conduit.IConduitInterface;

public class TileTCItemConduit extends TechCraftTile implements IConduitConductor {

    ConduitNetwork network;

    public void updateEntity() {

        if(network == null) {

            network = new ConduitNetwork(worldObj, this, EnumContuitType.ITEM);
        }
        else {
            
            network.updateNetwork();
        }
    }

    @Override
    public String getName() {

        return "TC Item Conduit";
    }

    public ConduitNetwork getNetwork() {

        return network;
    }

    public void overrideNetwork(ConduitNetwork network) {

        this.network = network;
    }

    public boolean decideRender(ForgeDirection direction) {

        if(TechCraftTile.getTilesNextTo(this, worldObj) > 0) {

            if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) != null) {

                if(TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IConduitInterface || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof TileTCItemConduit || TechCraftTile.translateDirectionToTile(this, worldObj, direction) instanceof IInventory){

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public EnumContuitType getConductorType() {

        return EnumContuitType.ITEM;
    }

    @Override
    public boolean renderByDirection(ForgeDirection direction) {

        return true;
    }
}