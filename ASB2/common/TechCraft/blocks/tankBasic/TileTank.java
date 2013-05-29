package TechCraft.blocks.tankBasic;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import TechCraft.BlockRegistry;
import TechCraft.ITCTankContainer;
import TechCraft.blocks.TechCraftTile;

public class TileTank extends TechCraftTile implements ITCTankContainer {

    public final LiquidTank tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 16);

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);

        if (data.hasKey("stored") && data.hasKey("liquidId")) {
            LiquidStack liquid = new LiquidStack(data.getInteger("liquidId"), data.getInteger("stored"), 0);
            tank.setLiquid(liquid);
        } else {
            LiquidStack liquid = LiquidStack.loadLiquidStackFromNBT(data.getCompoundTag("tank"));
            if (liquid != null) {
                tank.setLiquid(liquid);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        if (tank.containsValidLiquid()) {
            data.setTag("tank", tank.getLiquid().writeToNBT(new NBTTagCompound()));
        }
    }

    public static TileTank getTankBelow(TileTank tile) {
        TileEntity below = tile.worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord - 1, tile.zCoord);
        if (below instanceof TileTank) {
            return (TileTank) below;
        } else {
            return null;
        }
    }

    public static TileTank getTankAbove(TileTank tile) {
        TileEntity above = tile.worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord + 1, tile.zCoord);
        if (above instanceof TileTank) {
            return (TileTank) above;
        } else {
            return null;
        }
    }

    public void moveLiquidBelow() {
        TileTank below = getTankBelow(this);
        if (below == null) {
            return;
        }

        int used = below.tank.fill(tank.getLiquid(), true);
        if (used > 0) {
            tank.drain(used, true);
        }
    }

    /* ITANKCONTAINER */
    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
        return fill(0, resource, doFill);
    }

    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
        if (direction == DOWN && worldObj != null && worldObj.getBlockId(xCoord, yCoord - 1, zCoord) != BlockRegistry.BlockTank.blockID) {
            return tank;
        }
        return null;
    }

    @Override
    public String getLiquidStackName() {

        return tank.getLiquidName();
    }

    @Override
    public int getCapasity() {

        return tank.getCapacity();
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill) {

        return fill(0, resource, doFill);
    }

    @Override
    public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {

        return drain(0, maxEmpty, doDrain);
    }

    @Override
    public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) {
        
        if(tankIndex != 0)
            return null;
        
        return tank.drain(maxEmpty, doDrain);
    }

    @Override
    public ILiquidTank[] getTanks(ForgeDirection direction) {

        return new ILiquidTank[1];
    }
}
