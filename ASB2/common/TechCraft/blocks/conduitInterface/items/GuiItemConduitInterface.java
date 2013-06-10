package TechCraft.blocks.conduitInterface.items;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiItemConduitInterface extends GuiContainer {

    @SuppressWarnings("unused")
    private TileItemConduitInterface tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiItemConduitInterface(InventoryPlayer inventory, TileItemConduitInterface tileEntity) {
        super(new ContainerItemConduitInterface(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        drawTexturedModalRect(posX + 23 - 1, posY + 35 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 137 - 1, posY + 35 - 1, 176, 32, 18, 18);

        drawTexturedModalRect(posX + 45 - 1, posY + 13 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 62 - 1, posY + 13 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 79 - 1, posY + 13 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 95 - 1, posY + 13 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 112 - 1, posY + 13 - 1, 176, 32, 17, 17);

        drawTexturedModalRect(posX + 45 - 1, posY + 30 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 62 - 1, posY + 30 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 79 - 1, posY + 30 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 95 - 1, posY + 30 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 112 - 1, posY + 30 - 1, 176, 32, 17, 17);

        drawTexturedModalRect(posX + 45 - 1, posY + 47 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 62 - 1, posY + 47 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 79 - 1, posY + 47 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 95 - 1, posY + 47 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 112 - 1, posY + 47 - 1, 176, 32, 17, 17);

        drawTexturedModalRect(posX + 45 - 1, posY + 64 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 62 - 1, posY + 64 - 1, 176, 32, 17, 17);        
        drawTexturedModalRect(posX + 79 - 1, posY + 64 - 1, 176, 32, 17, 17);   
        drawTexturedModalRect(posX + 95 - 1, posY + 64 - 1, 176, 32, 17, 17);
        drawTexturedModalRect(posX + 112 - 1, posY + 64 - 1, 176, 32, 17, 17);   
    }
}