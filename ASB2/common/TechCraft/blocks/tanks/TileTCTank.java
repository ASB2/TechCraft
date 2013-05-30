package TechCraft.blocks.tanks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import TechCraft.ITCTankContainer;
import TechCraft.blocks.TechCraftTile;

public class TileTCTank extends TechCraftTile implements ITCTankContainer, IInventory {

    public LiquidTank tank;

    public TileTCTank() {

        tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 16);
    }

    public void updateEntity() {
    }

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

    /* ITANKCONTAINER */
    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {

        return tank.fill(resource, doFill);
    }

    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack liquid) {

        if(liquid == tank.getLiquid()) {

            return tank;
        }

        if(tank == null){

            return tank;
        }

        return null;
    }


    @Override
    public LiquidTank[] getTank() {

        return new LiquidTank[] {tank};
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill) {

        if(tankIndex != 0) {

            return 0;
        }
        else {
            return tank.fill(resource, doFill);
        }
    }

    @Override
    public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {

        return tank.drain(maxEmpty, doDrain);
    }

    @Override
    public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) {

        if(tankIndex != 0)
            return null;

        return tank.drain(maxEmpty, doDrain);
    }

    @Override
    public LiquidTank[] getTanks(ForgeDirection direction) {

        return new LiquidTank[1];
    }

    @Override
    public int getSizeInventory() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void openChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return false;
    }

}
