package TechCraft.blocks.item_transfer.item_SenderReciever;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerItemSender extends Container {

    public ContainerItemSender(InventoryPlayer par1InventoryPlayer, TileItemSender tileEntity) {
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 121, 38));

        this.addSlotToContainer(new Slot(tileEntity, 1, 30,17));
        this.addSlotToContainer(new Slot(tileEntity, 2, 48,17));
        this.addSlotToContainer(new Slot(tileEntity, 3, 66,17));
        this.addSlotToContainer(new Slot(tileEntity, 4, 30,35));
        this.addSlotToContainer(new Slot(tileEntity, 5, 48,35));
        this.addSlotToContainer(new Slot(tileEntity, 6, 66,35));
        this.addSlotToContainer(new Slot(tileEntity, 7, 30,53));
        this.addSlotToContainer(new Slot(tileEntity, 8, 48,53));
        this.addSlotToContainer(new Slot(tileEntity, 9, 66,53));


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