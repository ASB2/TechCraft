package TechCraft.blocks.tcItemExtractor;

import net.minecraft.entity.player.InventoryPlayer;
import TechCraft.TechCraftGui;

public class GuiItemExtractor extends TechCraftGui {

    @SuppressWarnings("unused")
    private TileItemExtractor tileEntity;

    public GuiItemExtractor(InventoryPlayer inventory, TileItemExtractor tileEntity) {
        super(new ContainerItemExtractor(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        this.renderDefaultGui();
    }
}