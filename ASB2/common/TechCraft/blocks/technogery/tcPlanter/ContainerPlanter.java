package TechCraft.blocks.technogery.tcPlanter;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;

public class ContainerPlanter extends TechCraftContainer {

    public ContainerPlanter(InventoryPlayer par1InventoryPlayer, TilePlanter tileEntity) {
        super(par1InventoryPlayer);
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 0, 79, 37)));  
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 1, 79, 37 - 18)));  
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 2, 79, 37 + 18)));  
       
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 3, 79 + 18, 37)));  
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 4, 79 - 18, 37))); 
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 5, 79 + 18, 37 + 18)));          
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 6, 79 + 18, 37 - 18)));  
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 7, 79 - 18, 37 - 18)));
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 8, 79 - 18, 37 + 18)));    
        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 9, 79 - 18 - 18 - 9, 37)));    
    }
}