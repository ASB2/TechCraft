package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.*;

public class GuiTCFurnace extends GuiContainer {

    private TileTCFurnace tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCFurnace(InventoryPlayer inventory,TileTCFurnace tileEntity) {        
        super(new ContainerTCFurnace(inventory, tileEntity));
        this.tileEntity=tileEntity;

    }

    protected void drawGuiContainerForegroundLayer(int x, int y){
        final String invTitle = "TC Furnace";
        fontRenderer.drawString(invTitle, xSize / 2 - fontRenderer.getStringWidth(invTitle) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        drawTexturedModalRect(posX + 56 - 1, posY + 32 - 1, 176, 32, 18, 18);
        drawTexturedModalRect(posX + 111, posY + 27, 226, 4, 26, 26);

        drawTexturedModalRect(posX + 79, posY + 32, 200, 14, 24, 17);
        //This renders the energy gauge. Lower the last number to increase the energy displayed

        drawTexturedModalRect(posX + 4, posY + 5, 178, 127, 48, 75);

            int i1 = tileEntity.getPowerScaled(75);

            drawTexturedModalRect(posX + 7, posY + 5, 176, 51, 18, 71);
            drawTexturedModalRect(posX + 7, posY + 5, 194, 51, 18, i1);
    }

}
