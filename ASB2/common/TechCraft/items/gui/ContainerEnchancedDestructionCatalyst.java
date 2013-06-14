package TechCraft.items.gui;

import net.minecraft.inventory.Container;

import net.minecraft.entity.player.EntityPlayer;

public class ContainerEnchancedDestructionCatalyst extends Container {

    EntityPlayer player;
    
    public ContainerEnchancedDestructionCatalyst(EntityPlayer player) {
        
    this.player = player;
    
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return true;
    }

}
