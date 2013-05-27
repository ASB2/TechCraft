package TechCraft.blocks.technogery.tcGrinder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTCGrinder extends Container{


    public ContainerTCGrinder(InventoryPlayer par1InventoryPlayer, TileTCGrinder tileEntity){
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 102, 11));
        this.addSlotToContainer(new Slot(tileEntity, 1, 120, 11));
        this.addSlotToContainer(new Slot(tileEntity, 2, 138, 11));
        
        this.addSlotToContainer(new Slot(tileEntity, 3, 138,52));
        
        this.addSlotToContainer(new Slot(tileEntity, 5, 102, 52));        
        this.addSlotToContainer(new Slot(tileEntity, 6, 120, 52));
        this.addSlotToContainer(new Slot(tileEntity, 7, 138,52));
        

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