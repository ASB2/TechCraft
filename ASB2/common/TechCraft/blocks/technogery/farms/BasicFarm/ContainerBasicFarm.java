package TechCraft.blocks.technogery.farms.BasicFarm;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerBasicFarm extends Container{


    public ContainerBasicFarm(InventoryPlayer par1InventoryPlayer, TileBasicFarm tileEntity){
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 13,40));
        this.addSlotToContainer(new Slot(tileEntity, 1, 31,40));
        this.addSlotToContainer(new Slot(tileEntity, 2, 13,58));
        this.addSlotToContainer(new Slot(tileEntity, 3, 31,58));
        
        this.addSlotToContainer(new Slot(tileEntity, 4, 52,40));
        this.addSlotToContainer(new Slot(tileEntity, 5, 70,40));
        this.addSlotToContainer(new Slot(tileEntity, 6, 52,58));
        this.addSlotToContainer(new Slot(tileEntity, 7, 70,58));
        
        this.addSlotToContainer(new Slot(tileEntity, 8, 91,40));
        this.addSlotToContainer(new Slot(tileEntity, 9, 109,40));
        this.addSlotToContainer(new Slot(tileEntity, 10, 91,58));
        this.addSlotToContainer(new Slot(tileEntity, 11, 109,58));
        
        this.addSlotToContainer(new Slot(tileEntity, 12, 135,17));
        this.addSlotToContainer(new Slot(tileEntity, 13, 135,48));
        

        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
            addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {

        // TODO Auto-generated method stub
        return true;
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shifffffffffffft clicking.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(slotnumber);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotnumber == 2)
            {
                if (!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotnumber == 1 || slotnumber == 0)
            {
                if (!mergeItemStack(itemstack1, 3, 39, false))
                {
                    return null;
                }
            }
            else if (itemstack1.getItem() instanceof Item)
            {
                if (!mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }

            else if (slotnumber >= 3 && slotnumber < 30)
            {
                if (!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (slotnumber >= 30 && slotnumber < 39 && !mergeItemStack(itemstack1, 3, 30, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack);
        }

        return itemstack;
    }

}