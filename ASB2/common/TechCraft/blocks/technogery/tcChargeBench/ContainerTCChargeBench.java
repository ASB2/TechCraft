package TechCraft.blocks.technogery.tcChargeBench;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;
import TechCraft.TechCraftGui;

public class ContainerTCChargeBench extends TechCraftContainer {


    public ContainerTCChargeBench(InventoryPlayer inventoryPlayer, TileTCChargeBench tileEntity){
        super(inventoryPlayer, tileEntity);
    }

    public void finishConstructing(TechCraftGui gui) {
        super.finishConstructing(gui);

        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 0, 102, 11)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 1, 120, 11)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 2, 138, 11)));  

        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 3, 102, 52)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 4, 120, 52)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 5, 138, 52)));  
    }
}