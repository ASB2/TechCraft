package TechCraft.items.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import TechCraft.items.ItemEnhancedDestructionCatalyst;
import TechCraft.lib.GUI;

public class GuiEnchancedDestructionCatalyst extends GuiContainer {

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 88;

    EntityPlayer player;

    public GuiEnchancedDestructionCatalyst(EntityPlayer player) {
        super(new ContainerEnchancedDestructionCatalyst(player));

        this.player = player;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        this.mc.renderEngine.bindTexture(GUI.GUI_SMALL_BLANK);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture); 

    }

    public void actionPerformed(GuiButton button) {

        switch(button.id) {

            case 0: this.decrementLength();
            break;

            case 1: this.incrementLength();
            break;

            case 2: this.mc.thePlayer.closeScreen(); break;
            default: 
        }
    }

    public void decrementLength() {

        if(player.inventory.getCurrentItem().getItem() instanceof ItemEnhancedDestructionCatalyst) {

            ItemEnhancedDestructionCatalyst item = (ItemEnhancedDestructionCatalyst)player.inventory.getCurrentItem().getItem();

            item.setLenght(player.inventory.getCurrentItem(), item.getLength(player.inventory.getCurrentItem()) - 1);
        }
    }

    public void incrementLength() {

        if(player.inventory.getCurrentItem().getItem() instanceof ItemEnhancedDestructionCatalyst) {

            ItemEnhancedDestructionCatalyst item = (ItemEnhancedDestructionCatalyst)player.inventory.getCurrentItem().getItem();

            item.setLenght(player.inventory.getCurrentItem(), item.getLength(player.inventory.getCurrentItem()) + 1);
        }
    }

    @SuppressWarnings("unchecked")
    public void initGui() {

        this.buttonList.clear();

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        this.buttonList.add(new GuiButton(0, posX+ 10, posY + 60, 100, 20, "Decrement Length"));
        this.buttonList.add(new GuiButton(1, posX+ 10, posY + 10, 100, 20, "Increment Length"));
        this.buttonList.add(new GuiButton(2, posX+ 120, posY + 10, 50, 20, "close"));

    }
}