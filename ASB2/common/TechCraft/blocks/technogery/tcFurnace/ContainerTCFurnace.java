package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;

public class ContainerTCFurnace extends TechCraftContainer{

    public ContainerTCFurnace(InventoryPlayer inventoryPlayer, TileTCFurnace tileEntity){ 
        super(inventoryPlayer, tileEntity);

        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 0, 56, 32)));        
        this.addSlotToContainer(this.addSlotToList(new Slot((IInventory)tileEntity, 1, 116, 32)));   
    }
}