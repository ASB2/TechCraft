package TechCraft.blocks.technogery.tcChargeBench;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiTCChargeBench extends TechCraftGui {

    private TileTCChargeBench tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCChargeBench(InventoryPlayer inventory, TileTCChargeBench tileEntity){
        super(new ContainerTCChargeBench(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();

        this.addPowerTank(posX + 45, posY + 7);
        this.scalePower(posX + 45, posY + 7, tileEntity.getPowerScaled(71));

        this.renderRightArrow(posX + 69, posY + 11);
        this.renderLeftArrow(posX + 69, posY + 51);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        drawTooltips(tileEntity, mouseX, mouseY, 45, 7, 18, 71);
    }
}