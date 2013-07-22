package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiTCTeleporter extends TechCraftGui {

    private TileTCTeleporter tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCTeleporter(InventoryPlayer inventory, TileTCTeleporter tileEntity) {
        super(new ContainerTCTeleporter(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {

        if(tileEntity.teleporter != null && tileEntity.coordsSet) {

            String coords = "X: " + (int)tileEntity.x + " Y: " + (int)tileEntity.y + " Z: " + (int)tileEntity.z;
            fontRenderer.drawString(coords + " D-ID " + tileEntity.dimentionID, xSize / 2 - fontRenderer.getStringWidth(coords) / 2, 60, 4210752);
        }    
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();

        this.addPowerTank(posX + 9, posY + 7);
        this.scalePower(posX + 9, posY + 7, tileEntity.getPowerScaled(75));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        if(isPointInRegion(9, 7, 18, 71, mouseX, mouseY)) {

            drawBarTooltip("Energy", "TCU", tileEntity.getPowerProvider().getPowerStored(), tileEntity.getPowerProvider().getPowerMax(), mouseX, mouseY);
        }
    }
}