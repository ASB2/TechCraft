package TechCraft.blocks.technogery.farms.BasicFarm;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiBasicFarm extends GuiContainer{

    @SuppressWarnings("unused")
    private TileBasicFarm tileEntity;
    
    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiBasicFarm(InventoryPlayer inventory,TileBasicFarm tileEntity){
        super(new ContainerBasicFarm(inventory, tileEntity));
        this.tileEntity = tileEntity;

    }

    protected void drawGuiContainerForegroundLayer(int x, int y){
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){
       
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.renderEngine.bindTexture("/mods/TechCraft/textures/gui/TechCraftFarms.png");
        
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;
        //This draws the entire gui        
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        //This renders the energy gauge. Lower the last number to increase the energy displayed
        //int i1;
        //i1 = tileEntity.getMagicStoredScaled(66);
        drawTexturedModalRect(posX+9,posY+8,176,66,52,0);
    }

    

}
