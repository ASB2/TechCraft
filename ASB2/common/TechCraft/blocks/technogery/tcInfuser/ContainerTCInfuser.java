package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;

public class ContainerTCInfuser extends TechCraftContainer {

    public ContainerTCInfuser(InventoryPlayer inventoryPlayer, TileTCInfuser tileEntity) {
        super(inventoryPlayer, tileEntity);
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 0, 28, 64)));
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 1, 47 + 15, 14))); 
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 2, 65 + 15, 14)));         
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 3, 83 + 15, 14)));
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 4, 47 + 15, 32))); 
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 5, 65 + 15, 32)));        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 6, 83 + 15, 32))); 
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 7, 47 + 15, 50)));
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 8, 65 + 15, 50)));        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 9, 83 + 15 ,50)));
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 10, 83 + 60, 32)));
    }
}