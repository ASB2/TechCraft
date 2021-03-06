package TechCraft.blocks.tanks;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import TechCraft.lib.GUI;

public class GuiTCTank extends GuiContainer {

    private TileTCTank tileEntity;

    public final int xSizeOfTexture = 176;
    public final int ySizeOfTexture = 166;

    public GuiTCTank(InventoryPlayer inventory, TileTCTank tileEntity) {
        super(new ContainerTCTank(inventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {

        if(tileEntity.liquid != null) {

            Icon texture = tileEntity.tank.getLiquid().getRenderingIcon();
            
            this.mc.renderEngine.bindTexture(tileEntity.tank.getLiquid().getTextureSheet());

            fontRenderer.drawString(tileEntity.tank.getLiquidName(), xSize / 2 - fontRenderer.getStringWidth(tileEntity.tank.getLiquidName()) / 2, 6, 4210752);
            
            this.drawTexturedModelRectFromIcon(9, 10, texture, 53, 66);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y){

        GL11.glColor4f(1F, 1F, 1F, 1F);

        this.mc.renderEngine.bindTexture(GUI.GUI_DEFAULT);

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        //Slots
        drawTexturedModalRect(posX + 100, posY + 20, 176, 32, 18, 18);

        //Tank
        drawTexturedModalRect(posX+9,posY+10, 0, 167, 53, 66);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks) {
        super.drawScreen(mouseX, mouseY, gameTicks);

        //if(isPointInRegion(9, 10, 53, 66, mouseX, mouseY)) {

            if(tileEntity.liquid != null) {

                drawBarTooltip(tileEntity.getTank().getLiquidName(), "mB", tileEntity.getTank().getLiquid().amount, tileEntity.getTank().getCapacity(), mouseX, mouseY);
            }
            else {
                drawBarTooltip("Empty ", "mB", 0, tileEntity.getTank().getCapacity(), mouseX, mouseY);
            }
       // }
    }

    protected void drawBarTooltip(String name, String unit, int value, int max, int x, int y)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_LIGHTING);

        List<String> stringList = new LinkedList<String>();
        stringList.add(name);
        stringList.add(value + " / " + max + " " + unit);

        int tooltipWidth = 0;
        int tempWidth;
        int xStart;
        int yStart;

        for(int i = 0; i < stringList.size(); i++)
        {
            tempWidth = this.fontRenderer.getStringWidth(stringList.get(i));

            if(tempWidth > tooltipWidth)
            {
                tooltipWidth = tempWidth;
            }
        }

        xStart = x + 12;
        yStart = y - 12;
        int tooltipHeight = 8;

        if(stringList.size() > 1)
        {
            tooltipHeight += 2 + (stringList.size() - 1) * 10;
        }

        if(this.guiTop + yStart + tooltipHeight + 6 > this.height)
        {
            yStart = this.height - tooltipHeight - this.guiTop - 6;
        }

        this.zLevel = 300.0F;
        itemRenderer.zLevel = 300.0F;
        int color1 = -267386864;
        this.drawGradientRect(xStart - 3, yStart - 4, xStart + tooltipWidth + 3, yStart - 3, color1, color1);
        this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 4, color1, color1);
        this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color1, color1);
        this.drawGradientRect(xStart - 4, yStart - 3, xStart - 3, yStart + tooltipHeight + 3, color1, color1);
        this.drawGradientRect(xStart + tooltipWidth + 3, yStart - 3, xStart + tooltipWidth + 4, yStart + tooltipHeight + 3, color1, color1);
        int color2 = 1347420415;
        int color3 = (color2 & 16711422) >> 1 | color2 & -16777216;
        this.drawGradientRect(xStart - 3, yStart - 3 + 1, xStart - 3 + 1, yStart + tooltipHeight + 3 - 1, color2, color3);
        this.drawGradientRect(xStart + tooltipWidth + 2, yStart - 3 + 1, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3 - 1, color2, color3);
        this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart - 3 + 1, color2, color2);
        this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 2, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color3, color3);

        for(int stringIndex = 0; stringIndex < stringList.size(); ++stringIndex)
        {
            String line = stringList.get(stringIndex);

            if(stringIndex == 0)
            {
                line = "\u00a7" + Integer.toHexString(15) + line;
            }
            else
            {
                line = "\u00a77" + line;
            }

            this.fontRenderer.drawStringWithShadow(line, xStart, yStart, -1);

            if(stringIndex == 0)
            {
                yStart += 2;
            }

            yStart += 10;
        }

        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        this.zLevel = 0.0F;
        itemRenderer.zLevel = 0.0F;
    }
}