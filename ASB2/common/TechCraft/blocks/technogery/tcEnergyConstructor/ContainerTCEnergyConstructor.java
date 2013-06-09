package TechCraft.blocks.technogery.tcEnergyConstructor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTCEnergyConstructor extends Container{


    public ContainerTCEnergyConstructor(InventoryPlayer par1InventoryPlayer, TileTCEnergyConstructor tileEntity){
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 102, 16));
        
        this.addSlotToContainer(new Slot(tileEntity, 1, 78, 38));
        
        this.addSlotToContainer(new Slot(tileEntity, 2, 60, 57));        
        this.addSlotToContainer(new Slot(tileEntity, 3, 78, 57));        
        this.addSlotToContainer(new Slot(tileEntity, 4, 96, 57));
        

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