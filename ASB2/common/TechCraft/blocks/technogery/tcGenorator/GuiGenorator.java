package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import TechCraft.lib.*;

public class GuiGenorator extends GuiContainer {

    private TileGenorator tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiGenorator(InventoryPlayer inventory, TileGenorator tileEntity){
        super(new ContainerGenorator(inventory, tileEntity));

        this.tileEntity=tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y){
        final String invTitle = "TC Genorator";

        fontRenderer.drawString(invTitle, xSize / 2 - fontRenderer.getStringWidth(invTitle)+8 / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(GUI.TC_GENORATOR);
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 17 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 17 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 17 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 35 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 35 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 35 - 1, 176, 32, 18, 18);
        
        drawTexturedModalRect(posX + 30 - 1, posY + 53 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 48 - 1, posY + 53 - 1, 176, 32, 18, 18);        
        drawTexturedModalRect(posX + 66 - 1, posY + 53 - 1, 176, 32, 18, 18);

        //This renders the energy gauge. Lower the last number to increase the energy displayed

        if(tileEntity.isBurning) {
            int i1;
            i1 = tileEntity.getBurnTimeScaled(12);
            drawTexturedModalRect(posX+146,posY+41,176,0,14,i1);

            int i3;
            i3 = tileEntity.getMagicScaled(69);
            drawTexturedModalRect(posX+99, posY + 7, 55, 169, i3, 30);
        }
    }

}