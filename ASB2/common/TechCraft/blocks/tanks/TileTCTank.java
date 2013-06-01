package TechCraft.blocks.tanks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import TechCraft.blocks.TechCraftTile;

public class TileTCTank extends TechCraftTile implements ITankContainer, IInventory {

    public LiquidTank tank;

    public TileTCTank() {

        tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 16);
        tank.setTankPressure(1);
    }

    public void updateEntity() {

    }

    public String getName() {

        return "TC Tank";
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

    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {

        return fill(0, resource, doFill);
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill) {

        if (tankIndex != 0 || resource == null) {
            return 0;
        }

        LiquidStack liquid = this.tank.getLiquid();

        if (liquid != null && liquid.amount > 0 && !liquid.isLiquidEqual(resource)) {
            return 0;
        }

        int totalUsed = 0;

        while (tank != null && resource.amount > 0) {

            int used = this.tank.fill(resource, doFill);
            resource.amount -= used;
            totalUsed += used;
        }
        return totalUsed;
    }

    @Override
    public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {

        return drain(0, maxEmpty, doDrain);
    }

    @Override
    public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) {

        return tank.drain(maxEmpty, doDrain);
    }

    @Override
    public ILiquidTank[] getTanks(ForgeDirection direction) {

        LiquidTank compositeTank = new LiquidTank(tank.getCapacity());

        int capacity = tank.getCapacity();

        if (tank.getLiquid() != null) {

            compositeTank.setLiquid(tank.getLiquid().copy());
        } 
        else {
            return new ILiquidTank[]{compositeTank};
        }

        LiquidStack liquid = tank.getLiquid();

        if (liquid == null || liquid.amount == 0) {

        } 
        else if (!compositeTank.getLiquid().isLiquidEqual(liquid)) {

        } 
        else {
            compositeTank.getLiquid().amount += liquid.amount;
        }

        capacity += tank.getCapacity();

        compositeTank.setCapacity(capacity);

        return new ILiquidTank[]{compositeTank};
    }    


    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {

        return tank;
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

        return this.getName();
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
