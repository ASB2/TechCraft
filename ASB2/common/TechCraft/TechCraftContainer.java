package TechCraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class TechCraftContainer extends Container {

    protected TechCraftGui gui;

    InventoryPlayer inventory;
    List<Slot> slotList = new ArrayList<Slot>();
    
    public TechCraftContainer(InventoryPlayer inventory) {

        this.inventory = inventory;

        
        this.addInventorySlots();
    }

    public void finishConstructing(TechCraftGui gui) {

        this.gui = gui;
    }

    public void addInventorySlots() {        

        for (int i = 0; i < 3; i++) {

            for (int k = 0; k < 9; k++) {

                addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++) {

            addSlotToContainer(new Slot(inventory, j, 8 + j * 18, 142));
        }
    }

    public Slot addSlotToList(Slot slot) {

        slotList.add(slot);
        return slot;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber) {

        return null;
    }
}
