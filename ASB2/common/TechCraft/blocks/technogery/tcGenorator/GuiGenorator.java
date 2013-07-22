package TechCraft.blocks.technogery.tcGenorator;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import TechCraft.TechCraftGui;
import TechCraft.lib.GUI;

public class GuiGenorator extends TechCraftGui {

    private TileGenorator tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiGenorator(InventoryPlayer inventory, TileGenorator tileEntity){
        super(new ContainerGenorator(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y){
        final String invTitle = "TC Genorator";

        fontRenderer.drawString(invTitle, xSize / 2 - fontRenderer.getStringWidth(invTitle)+8 / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        this.renderDefaultGui();
        
        this.renderFlame(posX + 146, posY + 41);
        this.scaleBurningFlame(posX+146, posY+41, tileEntity.getBurnTimeScaled(12));
        
        this.mc.renderEngine.bindTexture(GUI.TC_GENORATOR);
        drawTexturedModalRect(posX + 98, posY + 6, 0, 0, 71, 32);
        
        int i3 = tileEntity.getPowerScaled(71);
        drawTexturedModalRect(posX + 98 + 71 - i3, posY + 6, 0, 33, i3, 32);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        if(isPointInRegion(99, 6, 71, 32, mouseX, mouseY)) {

            drawBarTooltip("Energy", "TCU", tileEntity.getPowerProvider().getPowerStored(), tileEntity.getPowerProvider().getPowerMax(), mouseX, mouseY);
        }
    }
}