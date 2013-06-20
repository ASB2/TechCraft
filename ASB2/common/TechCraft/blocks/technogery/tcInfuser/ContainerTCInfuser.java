package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTCInfuser extends Container {

    public ContainerTCInfuser(InventoryPlayer par1InventoryPlayer, TileTCInfuser tileEntity) {
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 28, 64));
        
        this.addSlotToContainer(new Slot(tileEntity, 1, 32 + 15, 14)); 
        this.addSlotToContainer(new Slot(tileEntity, 2, 65 + 15, 14));         
        this.addSlotToContainer(new Slot(tileEntity, 3, 83 + 15, 14));
        
        this.addSlotToContainer(new Slot(tileEntity, 4, 47 + 15, 32)); 
        this.addSlotToContainer(new Slot(tileEntity, 5, 65 + 15, 32));        
        this.addSlotToContainer(new Slot(tileEntity, 6, 83 + 15, 32)); 
        
        this.addSlotToContainer(new Slot(tileEntity, 7, 47 + 15, 50));
        this.addSlotToContainer(new Slot(tileEntity, 8, 65 + 15, 50));        
        this.addSlotToContainer(new Slot(tileEntity, 9, 83 + 15,50));
        
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