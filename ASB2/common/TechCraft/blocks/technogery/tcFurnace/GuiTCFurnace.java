package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;

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
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(TEXTURES.TC_FURNACE);
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        //This renders the energy gauge. Lower the last number to increase the energy displayed

        if(tileEntity.isBurning) {

            int i3;
            i3 = tileEntity.getPowerScaled(69);
            drawTexturedModalRect(posX+99,posY+7,176,27,i3,30);
        }
    }

}
