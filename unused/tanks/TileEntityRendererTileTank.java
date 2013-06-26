package TechCraft.blocks.tanks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.liquids.LiquidDictionary;

import org.lwjgl.opengl.GL11;

import TechCraft.models.ModelFlat;

public class TileEntityRendererTileTank extends TileEntitySpecialRenderer {

    private ModelFlat model;

    public TileEntityRendererTileTank(){
        model = new ModelFlat();
    }

    public void renderAModelAt(TileEntity tile, double x, double y, double z, float frame) {

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);

        GL11.glPushMatrix();
        
        bindTextureByName(LiquidDictionary.getCanonicalLiquid("Water").getTextureSheet());

        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt(par1TileEntity, par2, par4, par6, par8);
    }    

    @SuppressWarnings("unused")
    private void renderAllOrientation(double x, double y, double z, int metadata) {
        
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        
        switch (metadata) {

            case 0: {//Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);                
                model.renderAll();
                break;
            }            
            case 1: {//Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                model.renderAll();
                break;
            }
            case 2: {//South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                model.renderAll();
                break;
            }
            case 3: {//North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                model.renderAll();
                break;
            }
            case 5: {//West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                model.renderAll();
                break;
            }
            case 4: {//East
                GL11.glTranslatef((float) x - .5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                model.renderAll();
                break;
            }
            default: {//Other
                return;
            }
        }
    }
}