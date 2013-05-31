package TechCraft.blocks.tanks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import TechCraft.ITCTankContainer;
import TechCraft.blocks.*;
import TechCraft.*;

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

    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
        
        return fill(0, resource, doFill);
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
        
        if (tankIndex != 0 || resource == null) {
            return 0;
        }

        resource = resource.copy();
        int totalUsed = 0;
        
        TileTCTank tankToFill = this;

        LiquidStack liquid = tankToFill.tank.getLiquid();
        if (liquid != null && liquid.amount > 0 && !liquid.isLiquidEqual(resource)) {
            return 0;
        }

        while (tankToFill != null && resource.amount > 0) {
            int used = tankToFill.tank.fill(resource, doFill);
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
        TileTCTank bottom = this;
        
        return bottom.tank.drain(maxEmpty, doDrain);
    }

    @Override
    public ILiquidTank[] getTanks(ForgeDirection direction) {
        LiquidTank compositeTank = new LiquidTank(tank.getCapacity());

        TileTCTank tile = this;

        int capacity = tank.getCapacity();

        if (tile != null && tile.tank.getLiquid() != null) {
            compositeTank.setLiquid(tile.tank.getLiquid().copy());
        } else {
            return new ILiquidTank[]{compositeTank};
        }

        tile = this;

        while (tile != null) {

            LiquidStack liquid = tile.tank.getLiquid();
            if (liquid == null || liquid.amount == 0) {
                // NOOP
            } else if (!compositeTank.getLiquid().isLiquidEqual(liquid)) {
                break;
            } else {
                compositeTank.getLiquid().amount += liquid.amount;
            }

            capacity += tile.tank.getCapacity();
            tile = this;
        }

        compositeTank.setCapacity(capacity);
        return new ILiquidTank[]{compositeTank};
    }

    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
        
        if (direction == ForgeDirection.DOWN && worldObj != null && worldObj.getBlockId(xCoord, yCoord - 1, zCoord) != BlockRegistry.BlockTCTank.blockID) {
            
            return tank;
        }
        return null;
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

    @Override
    public LiquidTank[] getTank() {

        return new LiquidTank[]{tank};
    }


}
