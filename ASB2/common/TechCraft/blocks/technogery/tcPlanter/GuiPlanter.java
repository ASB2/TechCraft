package TechCraft.blocks.technogery.tcPlanter;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiPlanter extends TechCraftGui {

    private TilePlanter tileEntity;

    public GuiPlanter(InventoryPlayer inventory, TilePlanter tileEntity) {
        super(new ContainerPlanter(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        drawTooltips(tileEntity, mouseX, mouseY, 9, 7, 18, 71);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();

        
        //Tank
        this.addTank(posX + 9 + 140, posY + 7);

        //Power

        this.addPowerTank(posX + 9, posY + 7);
        this.scalePower(posX + 9,  posY + 7, tileEntity.getPowerScaled(75));
    }
}