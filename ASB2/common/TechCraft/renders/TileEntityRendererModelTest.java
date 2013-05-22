package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelTCEnergyFocus;
import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityRendererModelTest extends TileEntitySpecialRenderer{

    private ModelTCEnergyFocus model;

    public TileEntityRendererModelTest(){
        model = new ModelTCEnergyFocus();
    }

    public void renderAModelAt(TileTestBlock tile, double x, double y, double z, float frames) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        renderByOrientation(x, y, z, tile.getOrientation());

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        model.renderAll();

        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }
    
    private void renderByOrientation(double x, double y, double z, ForgeDirection forgeDirection) {

        switch (forgeDirection) {
            case DOWN: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 0.0F, (float) y + 2.0F, (float) z + 0.0F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                return;
            }
            case UP: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 0.0F, (float) y + -1.0F, (float) z + 1.0F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case NORTH: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 1.0F, (float) y + 0.0F, (float) z + 2.0F);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                return;
            }
            case SOUTH: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + -1.0F);
                return;
            }
            case EAST: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + -1.0F, (float) y + 1.0F, (float) z + 1.0F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case WEST: {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 2.0F, (float) y + 0.0F, (float) z + 1.0F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case UNKNOWN: {
                return;
            }
            default: {
                return;
            }
        }
    }
    
    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){
        if(par1TileEntity instanceof TileTestBlock) {

            TileTestBlock testTile = (TileTestBlock) par1TileEntity;
            this.renderAModelAt(testTile, par2, par4, par6, par8);
        }        
    }    


}