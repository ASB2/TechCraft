package TechCraft.blocks.technogery.tcEnergySender;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftTile;
import TechCraft.fx.FXBeam;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;
import TechCraft.utils.IBlockCycle;
import TechCraft.utils.UtilBlock;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilPower;

public class TileEnergySender extends TechCraftTile implements IPowerMisc, IBlockCycle {

    int distance = 50;
    FXBeam beam;
    boolean forceRenderBeam = false;

    public TileEnergySender() {

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
    }

    public void updateEntity() {
        
        if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {

            if(getOrientation() == ForgeDirection.DOWN) {

                UtilBlock.cycle3DBlock(null, worldObj, xCoord, yCoord, zCoord, ForgeDirection.DOWN, 10, this);
            }

            IPowerMisc tile;
            tile = UtilDirection.findConductor(UtilDirection.translateDirectionToOpposite(this.getOrientation()), worldObj, distance, xCoord, yCoord, zCoord);

            if(tile != null) {

                movePower(tile);
            }
        }
    }

    public void movePower(IPowerMisc tile) {

        if(tile.getPowerProvider() != null) {

            if(this.getPowerProvider().getPowerStored() > 0) {

                if(tile.getPowerProvider().getCurrentState() == State.SINK) {

                    if(UtilPower.transferPower(this, tile)) 
                        TechCraft.proxy.renderBeam(this, tile, 20);
                }

                if(tile.getPowerProvider().getCurrentState() == State.OTHER) {

                    if(UtilPower.transferPower(this, tile)) 
                        TechCraft.proxy.renderBeam(this, tile, 20);
                }
            }

            if(forceRenderBeam) {

                if(tile.getPowerProvider().getCurrentState() == State.SINK || tile.getPowerProvider().getCurrentState() == State.OTHER)
                    TechCraft.proxy.renderBeam(this, tile, 10);
            }
        }
    }

    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side) {

        TileEntity tile = world.getBlockTileEntity(x, y, z);

        if(tile != null && tile instanceof IPowerMisc) {

            movePower((IPowerMisc)tile);
            return true;
        }
        return false;
    }

    public void triggerBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z, int side ) {

        if(forceRenderBeam == true) {

            forceRenderBeam = false;
            return;
        }

        if(forceRenderBeam == false) {

            forceRenderBeam = true;
            return;
        }
    }

    @Override
    public String getName() {

        return "Energy Sender";
    }
}

