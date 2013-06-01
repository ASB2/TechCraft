package TechCraft.blocks.tanks;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.GUI;

public class GuiTCTank extends GuiContainer {

    private TileTCTank tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCTank(InventoryPlayer inventory, TileTCTank tileEntity) {
        super(new ContainerTCTank(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {

        if(tileEntity.tank.getLiquid() != null) {

            Icon texture = tileEntity.tank.getLiquid().getRenderingIcon();
            this.mc.renderEngine.bindTexture(tileEntity.tank.getLiquid().getTextureSheet());

            fontRenderer.drawString(tileEntity.tank.getLiquidName(), xSize / 2 - fontRenderer.getStringWidth(tileEntity.tank.getLiquidName()) / 2, 6, 4210752);
            this.drawTexturedModelRectFromIcon(9, 10, texture, 53, 66);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1F, 1F, 1F, 1F);

        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        //Slots
        drawTexturedModalRect(posX + 100, posY + 20, 176, 32, 18, 18);

        //Tank
        drawTexturedModalRect(posX+9,posY+10, 0, 167, 53, 66);
    }
}