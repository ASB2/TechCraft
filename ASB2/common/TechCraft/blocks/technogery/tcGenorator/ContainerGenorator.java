package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerGenorator extends Container{

    public ContainerGenorator(InventoryPlayer par1InventoryPlayer, TileGenorator tileEntity) {
        
        this.addSlotToContainer(new SlotGenorator(tileEntity, 0, 30,17));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 1, 48,17));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 2, 66,17));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 3, 30,35));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 4, 48,35));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 5, 66,35));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 6, 30,53));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 7, 48,53));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 8, 66,53));
        this.addSlotToContainer(new SlotGenorator(tileEntity, 9, 145,60));

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