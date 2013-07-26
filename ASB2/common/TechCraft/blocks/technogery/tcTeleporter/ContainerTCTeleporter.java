package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import TechCraft.TechCraftContainer;

public class ContainerTCTeleporter extends TechCraftContainer {

    public ContainerTCTeleporter(InventoryPlayer inventoryPlayer, TileTCTeleporter tileEntity) {
        super(inventoryPlayer);
        
        this.addSlotToContainer(addSlotToList(new Slot(tileEntity, 0, 80,38)));        
    }
}