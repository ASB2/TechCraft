package TechCraft.blocks.tcItemExtractor;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.TechCraft;
import TechCraft.TechCraftTileRenderer;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelConduitInterface;

public class TileRendererItemExtractor extends TechCraftTileRenderer {

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

        TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_NONE);
        
        renderByOrientation(x, y, z, tile.getBlockMetadata());

        switch(tile.getColorEnum()) {            
            
            case WHITE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_WHITE);
                break;
            case ORANGE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_ORANGE);
                break;
            case MAGENTA: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_MAGENTA);
                break;
            case LIGHT_BLUE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_LIGHT_BLUE);
                break;
            case YELLOW: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_YELLOW);
                break;
            case LIME: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_LIME);
                break;
            case PINK: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_PINK);
                break;
            case GRAY: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_GRAY);
                break;
            case LIGHT_GREY: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_LIGHT_GREY);
                break;
            case CYAN: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_CYAN);
                break;
            case PURPLE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_PURPLE);
                break;
            case BLUE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_BLUE);
                break;
            case BROWN: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_BROWN);
                break;
            case GREEN: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_GREEN);
                break;
            case RED: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_RED);
                break;
            case BLACK: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_BLACK);
                break;
            case NONE: TechCraft.proxy.renderTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_NONE);
                break;                
        }
        
        model.renderAll();


        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }
}
