package TechCraft.blocks.tcToolManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiToolManager extends GuiContainer {

    @SuppressWarnings("unused")
    private TileToolManager tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiToolManager(InventoryPlayer inventory, TileToolManager tileEntity) {
        super(new ContainerToolManager(inventory, tileEntity));

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
        drawTexturedModalRect(posX + 61 - 1, posY + 29 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 101 - 1, posY + 29 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 81 - 1, posY + 51 - 1, 176, 32, 18, 18);        
        
    }



}