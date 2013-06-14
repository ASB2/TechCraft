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

import net.minecraft.block.*;

public class TileTCTank extends TechCraftTile implements ITankContainer, IInventory {

    public LiquidTank tank;
    public int renderOffset;
    
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
    public int fill (int tankIndex, LiquidStack resource, boolean doFill)
    {
        /*if (resource != null && resource.amount > 20 && counter == 0)
        {
            if (tank.getLiquid() == null)
            {
                renderLiquid = new LiquidStack(resource.itemID, 0, resource.itemMeta);
            }
            else
            {
                renderLiquid = tank.getLiquid();
            }
            counter = 24;
            updateAmount = resource.amount / 24;
            System.out.println("renderLiquid: "+renderLiquid.amount);           
        }*/
        //renderLiquid = tank.getLiquid();
        int amount = tank.fill(resource, doFill);
        if (amount > 0 && doFill)
        {
            renderOffset = resource.amount;
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

        //System.out.println("tankLiquid: "+tank.getLiquid().amount);   
        return amount;
    }
    @Override
    public LiquidStack drain (ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return drain(0, maxDrain, doDrain);
    }

    @Override
    public LiquidStack drain (int tankIndex, int maxDrain, boolean doDrain)
    {
        /*if (maxDrain > 20 && counter == 0)
        {
            renderLiquid = tank.getLiquid();
            counter = 24;
            updateAmount = -(maxDrain / 24);
        }*/


        LiquidStack amount = tank.drain(maxDrain, doDrain);
        if (amount != null && doDrain)
        {
            renderOffset = -maxDrain;
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
        return amount;
    }

    @Override
    public ILiquidTank[] getTanks (ForgeDirection direction)
    {
        return new ILiquidTank[] { tank };
    }

    @Override
    public ILiquidTank getTank (ForgeDirection direction, LiquidStack type)
    {
        return tank;
    }

    public float getLiquidAmountScaled ()
    {
        return (float) (tank.getLiquid().amount - renderOffset) / (float) (tank.getCapacity() * 1.01F);
    }

    public boolean containsLiquid ()
    {
        return tank.getLiquid() != null;
    }

    public int getBrightness ()
    {
        if (containsLiquid())
        {
            int id = tank.getLiquid().itemID;
            if (id < 4096)
            {
                return Block.lightValue[id];
            }
        }
        return 0;
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
