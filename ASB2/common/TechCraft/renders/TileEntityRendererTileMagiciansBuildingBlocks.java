package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.TileMagiciansBuildingBlocks;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelBox;
import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityRendererTileMagiciansBuildingBlocks extends TileEntitySpecialRenderer {

    private ModelBox model;

    public TileEntityRendererTileMagiciansBuildingBlocks(){
        model = new ModelBox();
    }
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float frames) {

        if(tileentity instanceof TileMagiciansBuildingBlocks) {

            this.renderAModelAt((TileMagiciansBuildingBlocks)tileentity, x, y, z, frames);
        }

    }

    public void renderAModelAt(TileMagiciansBuildingBlocks tile, double x, double y, double z, float frames) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);

        GL11.glPushMatrix();

        this.renderByOrientation(x, y, z, tile.getBlockMetadata());

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BUILDING_BLOCKS);      

        model.render();

        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }

    private void renderByOrientation(double x, double y, double z, int metadata) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x + .5F, (float) y - .5F, (float) z + .5F);

        switch (metadata) {

            case 0: {//Down
                GL11.glColor3f(0F, 0F, 0F); 
                break;
            }            
            case 1: {//Up
                GL11.glColor3f(1.5F, 0F, 1.5F); 
                break;
            }

            case 2: {//South
                GL11.glColor3f(0, 1, 0); 
                break;
            }
            case 3: {//North
                GL11.glColor3f(1, 0, 0); 
                break;

            }
            case 4: {//East
                GL11.glColor3f(0, 0, 1); 
                break;

            }
            default: {//Other
                GL11.glColor3f(0F, 0F, 0F); 
                return;
            }
        }
    }

}
