package TechCraft.blocks.tcItemExtractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerItemExtractor extends Container {

    public ContainerItemExtractor(InventoryPlayer par1InventoryPlayer, TileItemExtractor tileEntity) {

        this.addSlotToContainer(new Slot(tileEntity, 0, 49, 32));        
        this.addSlotToContainer(new Slot(tileEntity, 1, 67, 32));        
        this.addSlotToContainer(new Slot(tileEntity, 2, 85, 32));        
        this.addSlotToContainer(new Slot(tileEntity, 3, 103, 32));
        
        this.addSlotToContainer(new Slot(tileEntity, 4, 49, 50));        
        this.addSlotToContainer(new Slot(tileEntity, 5, 67, 50));
        this.addSlotToContainer(new Slot(tileEntity, 6, 85, 50));        
        this.addSlotToContainer(new Slot(tileEntity, 7, 103, 50));
        
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