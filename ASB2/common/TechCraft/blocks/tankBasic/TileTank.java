package TechCraft.blocks.tankBasic;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import TechCraft.power.TechCraftTile;

public class TileTank extends TechCraftTile implements ITankContainer {

    public final LiquidTank tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 16);

    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ILiquidTank[] getTanks(ForgeDirection direction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
        // TODO Auto-generated method stub
        return null;
    }





}