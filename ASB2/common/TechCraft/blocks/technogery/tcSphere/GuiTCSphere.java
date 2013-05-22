package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiTCSphere extends GuiContainer {

    private TileTCEnergySphere tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCSphere(InventoryPlayer inventory, TileTCEnergySphere tileEntity) {        
        super(new ContainerTCSphere(inventory, tileEntity));

        this.tileEntity = tileEntity;

    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        
        fontRenderer.drawString(tileEntity.getPowerStored()+" / "+tileEntity.getPowerMax(),  posX-3,  posY + 5, 0xFF0000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/TechCraft/textures/gui/TechnoSphere.png");
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        //This renders the energy gauge. Lower the last number to increase the energy displayed

        int i3;
        i3 = tileEntity.getPowerScaled(69);
        drawTexturedModalRect(posX+99,posY+7,176,27,i3,30);

    }

}