package TechCraft.blocks.technogery.tcGrinder;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.*;

public class GuiTCGrinder extends GuiContainer {

    private TileTCGrinder tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCGrinder(InventoryPlayer inventory, TileTCGrinder tileEntity){
        super(new ContainerTCGrinder(inventory, tileEntity));

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
        //This renders the energy gauge. Lower the last number to increase the energy displayed

        int i1 = tileEntity.getPowerScaled(75);

        drawTexturedModalRect(posX+5,posY+5,178,52,49,i1);
    }
}