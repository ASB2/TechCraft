package TechCraft.blocks.technogery.tcChargeBench;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.*;

public class GuiTCChargeBench extends GuiContainer {

    private TileTCChargeBench tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCChargeBench(InventoryPlayer inventory, TileTCChargeBench tileEntity){
        super(new ContainerTCChargeBench(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        
        drawTexturedModalRect(posX + 102 - 1, posY + 11 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 120 - 1, posY + 11 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 138 - 1, posY + 11 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 102 - 1, posY + 52 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 120 - 1, posY + 52 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 138 - 1, posY + 52 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 69, posY + 11, 200, 14, 24, 17);
        
        drawTexturedModalRect(posX + 69, posY + 51, 195, 32, 24, 17);
        //This renders the energy gauge. Lower the last number to increase the energy displayed

        int i1 = tileEntity.getPowerScaled(75);
        
        drawTexturedModalRect(posX + 4, posY + 5, 178, 127, 48, 75);
        drawTexturedModalRect(posX + 4, posY + 5, 178, 52, 49, i1);
    }
}