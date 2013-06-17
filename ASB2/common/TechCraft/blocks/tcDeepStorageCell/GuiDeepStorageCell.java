package TechCraft.blocks.tcDeepStorageCell;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiDeepStorageCell extends GuiContainer {

    @SuppressWarnings("unused")
    private TileDeepStorageCell tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiDeepStorageCell(InventoryPlayer inventory, TileDeepStorageCell tileEntity) {
        super(new ContainerDeepStorageCell(inventory, tileEntity));

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
        
        drawTexturedModalRect(posX + 81 - 1, posY + 29 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 81 - 1, posY + 8 - 1, 176, 32, 18, 18);      
        drawTexturedModalRect(posX + 81 - 1, posY + 51 - 1, 176, 32, 18, 18);        
        
    }



}