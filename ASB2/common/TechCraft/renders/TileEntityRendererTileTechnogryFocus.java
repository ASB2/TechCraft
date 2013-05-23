package TechCraft.renders;

import java.util.Random;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.TileTechnogryFocus;
import TechCraft.models.ModelTCEnergyFocus;

public class TileEntityRendererTileTechnogryFocus extends TileEntitySpecialRenderer {

    private ModelTCEnergyFocus model;

    public TileEntityRendererTileTechnogryFocus(){
        model = new ModelTCEnergyFocus();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double x, double y, double z, float frames){

        if(par1TileEntity instanceof TileTechnogryFocus) {

            this.renderAModelAt((TileTechnogryFocus)par1TileEntity, x, y, z, frames);
        }
    } 

    public void renderAModelAt(TileTechnogryFocus tile, double x, double y, double z, float frames) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);

        GL11.glPushMatrix();

        renderByOrientation(x, y, z, tile.getOrientation());

        GL11.glColor3f(changeColor(),changeColor(),changeColor());
        
        model.renderAll();


        GL11.glPopMatrix();
 
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }
    
    public float changeColor(){
        Random rand = new Random();
        return rand.nextFloat();
    }
    
    private void renderByOrientation(double x, double y, double z, ForgeDirection forgeDirection) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);

        switch (forgeDirection) {

            case DOWN: {
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
                return;
            }            
            case UP: {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                return;
            }

            case NORTH: {
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                return;
            }
            case SOUTH: {
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case EAST: {
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                return;
            }
            case WEST: {
                GL11.glTranslatef((float) x - .5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
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

}