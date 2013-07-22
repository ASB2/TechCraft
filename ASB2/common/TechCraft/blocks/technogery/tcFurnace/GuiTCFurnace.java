package TechCraft.blocks.technogery.tcFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiTCFurnace extends TechCraftGui {

    private TileTCFurnace tileEntity;

    public GuiTCFurnace(InventoryPlayer inventory, TileTCFurnace tileEntity) {        
        super(new ContainerTCFurnace(inventory, tileEntity));
        
        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
        final String invTitle = "TC Furnace";
        fontRenderer.drawString(invTitle, xSize / 2 - fontRenderer.getStringWidth(invTitle) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        this.renderDefaultGui();
        this.renderBigSlot(posX + 111, posY + 27);
        this.renderRightArrow(posX + 79, posY + 32);
        this.addPowerTank(posX + 7, posY + 5);
        this.scalePower(posX + 7, posY + 5, tileEntity.getPowerScaled(75));
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        drawTooltips(tileEntity, mouseX, mouseY, 21, 7, 18, 71);
    }
}
