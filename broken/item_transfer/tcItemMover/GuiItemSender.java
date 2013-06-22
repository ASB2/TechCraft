package TechCraft.blocks.item_transfer.item_SenderReciever;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiItemSender extends GuiContainer {

    @SuppressWarnings("unused")
    private TileItemSender tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiItemSender(InventoryPlayer inventory, TileItemSender tileEntity) {
        super(new ContainerItemSender(inventory, tileEntity));

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
        
        drawTexturedModalRect(posX + 120, posY + 37, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 17 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 17 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 17 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 35 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 35 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 35 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 53 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 53 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 53 - 1, 176, 32, 18, 18);
    }



}