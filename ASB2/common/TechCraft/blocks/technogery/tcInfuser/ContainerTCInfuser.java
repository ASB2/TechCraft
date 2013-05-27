package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTCInfuser extends Container {

    public ContainerTCInfuser(InventoryPlayer par1InventoryPlayer, TileTCInfuser tileEntity) {
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 15,12));        
        this.addSlotToContainer(new Slot(tileEntity, 1, 33,12)); 
        this.addSlotToContainer(new Slot(tileEntity, 2, 51,12)); 
        
        this.addSlotToContainer(new Slot(tileEntity, 3, 107,12));        
        this.addSlotToContainer(new Slot(tileEntity, 4, 125,12)); 
        this.addSlotToContainer(new Slot(tileEntity, 5, 143,12));
        
        this.addSlotToContainer(new Slot(tileEntity, 6, 33,37));        
        this.addSlotToContainer(new Slot(tileEntity, 7, 80,39));

        this.addSlotToContainer(new Slot(tileEntity, 8, 126,37));
        
        this.addSlotToContainer(new Slot(tileEntity, 9, 62,38));        
        this.addSlotToContainer(new Slot(tileEntity, 10, 80,59)); 
        this.addSlotToContainer(new Slot(tileEntity, 11, 98,59));
        
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