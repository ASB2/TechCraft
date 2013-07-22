package TechCraft.blocks.technogery.tcEnergyConstructor;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiTCEnergyConstructor extends TechCraftGui {

    private TileTCEnergyConstructor tileEntity;

    public GuiTCEnergyConstructor(InventoryPlayer inventory, TileTCEnergyConstructor tileEntity){
        super(new ContainerTCEnergyConstructor(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();
        this.addPowerTank(posX + 21, posY + 7);
        this.scalePower(posX + 21, posY + 7, tileEntity.getPowerScaled(71));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        drawTooltips(tileEntity, mouseX, mouseY, 21, 7, 18, 71);
    }
}