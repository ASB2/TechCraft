package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TechCraft.TechCraftContainer;

public class ContainerGenorator extends TechCraftContainer {

    public ContainerGenorator(InventoryPlayer inventoryPlayer, TileGenorator tileEntity) {
        super(inventoryPlayer);
    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 0, 30, 17)));      
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 1, 48, 17)));    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 2, 66, 17)));    
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 3, 30, 35)));    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 4, 48, 35)));    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 5, 66, 35)));    
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 6, 30, 53)));    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 7, 48, 53)));    
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 8, 66, 53)));    
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 9, 145, 60)));  
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber) {
        
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