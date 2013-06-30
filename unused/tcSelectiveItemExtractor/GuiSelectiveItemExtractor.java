package TechCraft.blocks.tcSelectiveItemExtractor;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiSelectiveItemExtractor extends GuiContainer {

    @SuppressWarnings("unused")
    private TileSelectiveItemExtractor tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiSelectiveItemExtractor(InventoryPlayer inventory, TileSelectiveItemExtractor tileEntity) {
        super(new ContainerSelectiveItemExtractor(inventory, tileEntity));

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

        drawTexturedModalRect(posX + 49 - 1, posY + 32 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 67 - 1, posY + 32 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 85 - 1, posY + 32 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 103 - 1, posY + 32 - 1, 176, 32, 18, 18);

        drawTexturedModalRect(posX + 49 - 1, posY + 50 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 67 - 1, posY + 50 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 85 - 1, posY + 50 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 103 - 1, posY + 50 - 1, 176, 32, 18, 18);  
    }
}