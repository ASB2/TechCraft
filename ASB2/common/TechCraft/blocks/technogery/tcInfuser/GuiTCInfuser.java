package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiTCInfuser extends TechCraftGui {

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
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();
        this.addPowerTank(posX + 8, posY + 6);
        this.scalePower(posX + 7, posY + 5, tileEntity.getPowerScaled(75));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        if(isPointInRegion(8, 6, 18, 71, mouseX, mouseY)) {

            drawBarTooltip("Energy:", "TCU", tileEntity.getPowerProvider().getPowerStored(), tileEntity.getPowerProvider().getPowerMax(), mouseX, mouseY);
        }
    }
}