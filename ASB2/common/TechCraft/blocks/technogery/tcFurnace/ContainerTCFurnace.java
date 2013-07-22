package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;
import TechCraft.TechCraftGui;

public class ContainerTCFurnace extends TechCraftContainer{

    public ContainerTCFurnace(InventoryPlayer inventoryPlayer, TileTCFurnace tileEntity){ 
        super(inventoryPlayer, tileEntity);
    }

    public void finishConstructing(TechCraftGui gui) {

        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 0, 56, 32)));        
        this.addSlotToContainer(this.addSlotToList(gui, new Slot((IInventory)tileEntity, 1, 116, 32)));         
    }
}