package TechCraft.blocks.technogery.tcEnergyConstructor;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;

public class ContainerTCEnergyConstructor extends TechCraftContainer{


    public ContainerTCEnergyConstructor(InventoryPlayer inventoryPlayer, TileTCEnergyConstructor tileEntity){
        super(inventoryPlayer);
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 0, 102, 16)));  

        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 1, 78, 38)));  

        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 2, 60, 57)));  
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 3, 78, 57)));  
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 4, 96, 57)));  
    }
}