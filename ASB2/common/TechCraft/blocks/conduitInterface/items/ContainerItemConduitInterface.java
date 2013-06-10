package TechCraft.blocks.conduitInterface.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerItemConduitInterface extends Container {

    public ContainerItemConduitInterface(InventoryPlayer par1InventoryPlayer, TileItemConduitInterface tileEntity) {

        this.addSlotToContainer(new Slot(tileEntity, 0, 23, 35));
        this.addSlotToContainer(new Slot(tileEntity, 1, 137, 35));

        this.addSlotToContainer(new Slot(tileEntity, 2, 45, 13));        
        this.addSlotToContainer(new Slot(tileEntity, 3, 62, 13));        
        this.addSlotToContainer(new Slot(tileEntity, 4, 79, 13));        
        this.addSlotToContainer(new Slot(tileEntity, 5, 95, 13));        
        this.addSlotToContainer(new Slot(tileEntity, 6, 112, 13));

        this.addSlotToContainer(new Slot(tileEntity, 7, 45, 30));        
        this.addSlotToContainer(new Slot(tileEntity, 8, 62, 30));        
        this.addSlotToContainer(new Slot(tileEntity, 9, 79, 30));
        this.addSlotToContainer(new Slot(tileEntity, 10, 95, 30));
        this.addSlotToContainer(new Slot(tileEntity, 11, 112, 30));  

        this.addSlotToContainer(new Slot(tileEntity, 12, 45, 47));        
        this.addSlotToContainer(new Slot(tileEntity, 13, 62, 47));
        this.addSlotToContainer(new Slot(tileEntity, 14, 79, 47));
        this.addSlotToContainer(new Slot(tileEntity, 15, 95, 47));
        this.addSlotToContainer(new Slot(tileEntity, 16, 112, 47));

        this.addSlotToContainer(new Slot(tileEntity, 17, 45, 64));
        this.addSlotToContainer(new Slot(tileEntity, 18, 62, 64));
        this.addSlotToContainer(new Slot(tileEntity, 19, 79, 64));
        this.addSlotToContainer(new Slot(tileEntity, 20, 95, 64));
        this.addSlotToContainer(new Slot(tileEntity, 21, 112, 64));

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