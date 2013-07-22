package TechCraft.blocks.tcItemExtractor;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;
import TechCraft.TechCraftGui;

public class ContainerItemExtractor extends TechCraftContainer {

    public ContainerItemExtractor(InventoryPlayer inventoryPlayer, TileItemExtractor tileEntity) {
        super(inventoryPlayer, tileEntity);

    }

    @Override
    public void finishConstructing(TechCraftGui gui) {
        super.finishConstructing(gui);

        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 0, 49, 32)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 1, 67, 32)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 2, 85, 32)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 3, 103, 32)));  

        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 4, 49, 50)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 5, 67, 50)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 6, 85, 50)));  
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 7, 103, 50)));
    }
}