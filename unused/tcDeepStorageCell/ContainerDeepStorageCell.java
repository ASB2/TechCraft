package TechCraft.blocks.tcDeepStorageCell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDeepStorageCell extends Container {

    public ContainerDeepStorageCell(InventoryPlayer par1InventoryPlayer, TileDeepStorageCell tileEntity) {
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 81, 29));

        this.addSlotToContainer(new Slot(tileEntity, 1, 81, 8));
        this.addSlotToContainer(new Slot(tileEntity, 2, 81, 51));


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

        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
    {
        return null;
    }

}