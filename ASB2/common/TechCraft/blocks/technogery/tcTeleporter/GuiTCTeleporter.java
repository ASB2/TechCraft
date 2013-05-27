package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.lib.TEXTURES;

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
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        //GL11.glColor4f(1.0F, 0F, 0F, 1F);

        this.mc.renderEngine.bindTexture(TEXTURES.BASIC_RUNE_GUI);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        //This renders the energy gauge. Lower the last number to increase the energy displayed
        
        drawTexturedModalRect(posX+10,posY+20,200,42,21,59);
        int i1;
        i1 = tileEntity.getPowerScaled(59);
        drawTexturedModalRect(posX+10,posY+20,178,42,21,i1);
    }



}