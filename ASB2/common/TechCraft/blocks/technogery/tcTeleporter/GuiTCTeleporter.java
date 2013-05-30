package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.*;

public class GuiTCTeleporter extends GuiContainer {

    private TileTCTeleporter tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCTeleporter(InventoryPlayer inventory, TileTCTeleporter tileEntity) {
        super(new ContainerTCTeleporter(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
        
        if(tileEntity.teleporter != null && tileEntity.coordsSet) {
            
            String coords = "Destination" + " X: " + (int)tileEntity.x + " Y: " + (int)tileEntity.y + " Z: " + (int)tileEntity.z;
            fontRenderer.drawString(coords, xSize / 2 - fontRenderer.getStringWidth(coords) / 2, 6, 4210752);
        }    
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        drawTexturedModalRect(posX + 79, posY + 37, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 4, posY + 5, 178, 127, 48, 75);

        if(tileEntity.getPowerStored() > 0) {

            int i1 = tileEntity.getPowerScaled(75);
            drawTexturedModalRect(posX + 4, posY + 5, 178, 52, 49, i1);
        }
    }



}