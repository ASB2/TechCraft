package TechCraft.blocks.tcItemExtractor;

import java.util.Random;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelConduitInterface;
import cpw.mods.fml.client.FMLClientHandler;

public class TileRendererItemExtractor extends TileEntitySpecialRenderer {

    private ModelConduitInterface model;

    public TileRendererItemExtractor() {
        
        model = new ModelConduitInterface();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double x, double y, double z, float frames){

        if(par1TileEntity instanceof TileItemExtractor) {

            this.renderAModelAt((TileItemExtractor)par1TileEntity, x, y, z, frames);
        }
    } 

    public void renderAModelAt(TileItemExtractor tile, double x, double y, double z, float frames) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);

        GL11.glPushMatrix();

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_NONE);
        
        renderByOrientation(x, y, z, tile.getBlockMetadata());

        switch(tile.getColorEnum()) {            
            
            case WHITE: FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_WHITE);
                break;
            case ORANGE: FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_ORANGE);
                break;
            case MAGENTA:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_MAGENTA);
                break;
            case LIGHT_BLUE:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_LIGHT_BLUE);
                break;
            case YELLOW:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_YELLOW);
                break;
            case LIME:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_LIME);
                break;
            case PINK:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_PINK);
                break;
            case GRAY:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_GRAY);
                break;
            case LIGHT_GREY:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_LIGHT_GREY);
                break;
            case CYAN:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_CYAN);
                break;
            case PURPLE:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_PURPLE);
                break;
            case BLUE:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_BLUE);
                break;
            case BROWN:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_BROWN);
                break;
            case GREEN:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_GREEN);
                break;
            case RED:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_RED);
                break;
            case BLACK:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_INTERFACE_BLACK);
                break;
            case NONE:FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_NONE);
                break;                
        }
        
        model.renderAll();


        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }

    public float changeColor() {
        
        Random rand = new Random();
        return rand.nextFloat();
    }

    private void renderByOrientation(double x, double y, double z, int metadata) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);

        switch (metadata) {

            case 0: {//Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
                return;
            }            
            case 1: {//Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                return;
            }

            case 2: {//South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                return;
            }
            case 3: {//North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case 5: {//West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                return;
            }
            case 4: {//East
                GL11.glTranslatef((float) x - .5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                return;
            }
            default: {//Other
                return;
            }
        }
    }
}
