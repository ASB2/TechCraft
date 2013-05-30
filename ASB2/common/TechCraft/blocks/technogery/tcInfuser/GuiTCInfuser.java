package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.GUI;

public class GuiTCInfuser extends GuiContainer {

    private TileTCInfuser tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCInfuser(InventoryPlayer inventory, TileTCInfuser tileEntity) {
        super(new ContainerTCInfuser(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y){  
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        //GL11.glColor4f(1.0F, 0F, 0F, 1F);

        this.mc.renderEngine.bindTexture(GUI.TC_INFUSER);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        drawTexturedModalRect(posX + 4, posY + 5, 178, 127, 48, 75);

        if(tileEntity.getPowerStored() > 0) {

            int i1 = tileEntity.getPowerScaled(75);
            drawTexturedModalRect(posX + 4, posY + 5, 178, 52, 49, i1);
        }
    }



}