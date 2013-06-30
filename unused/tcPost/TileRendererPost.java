package TechCraft.blocks.technogery.tcPost;

import java.util.Random;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.Model16Post;
import TechCraft.models.Model8Post;
import TechCraft.models.ModelFlat;
import cpw.mods.fml.client.FMLClientHandler;

public class TileRendererPost extends TileEntitySpecialRenderer {

    private Model8Post model8Post = new Model8Post();
    private Model16Post model16Post = new Model16Post();
    private ModelFlat modelFlat = new ModelFlat();

    public TileRendererPost() {


    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double x, double y, double z, float frames){

        this.renderAModelAt(par1TileEntity, x, y, z, frames);
    } 

    public void renderAModelAt(TileEntity tile, double x, double y, double z, float frames) {

        if(tile instanceof TilePost) {
            TilePost tileC = (TilePost)tile;

            GL11.glPushMatrix();

            FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

            if(tileC.renderPlate(ForgeDirection.DOWN)) 
                this.renderByOrientation(x, y, z, ForgeDirection.DOWN);    
            modelFlat.renderAll();

            if(tileC.renderPlate(ForgeDirection.UP)) 
                this.renderByOrientation(x, y, z, ForgeDirection.UP);    
            modelFlat.renderAll();

            if(tileC.renderPlate(ForgeDirection.NORTH)) 
                this.renderByOrientation(x, y, z, ForgeDirection.NORTH);    
            modelFlat.renderAll();

            if(tileC.renderPlate(ForgeDirection.SOUTH)) 
                this.renderByOrientation(x, y, z, ForgeDirection.SOUTH);    
            modelFlat.renderAll();

            if(tileC.renderPlate(ForgeDirection.WEST)) 
                this.renderByOrientation(x, y, z, ForgeDirection.WEST);    
            modelFlat.renderAll();

            if(tileC.renderPlate(ForgeDirection.EAST)) 
                this.renderByOrientation(x, y, z, ForgeDirection.EAST);    
            modelFlat.renderAll();
            
            
            if(tileC.render16Post(ForgeDirection.DOWN)) 
                this.renderByOrientation(x, y, z, ForgeDirection.DOWN);    
            model16Post.renderAll();

            if(tileC.render16Post(ForgeDirection.UP)) 
                this.renderByOrientation(x, y, z, ForgeDirection.UP);    
            model16Post.renderAll();

            if(tileC.render16Post(ForgeDirection.NORTH)) 
                this.renderByOrientation(x, y, z, ForgeDirection.NORTH);    
            model16Post.renderAll();

            if(tileC.render16Post(ForgeDirection.SOUTH)) 
                this.renderByOrientation(x, y, z, ForgeDirection.SOUTH);    
            model16Post.renderAll();

            if(tileC.render16Post(ForgeDirection.WEST)) 
                this.renderByOrientation(x, y, z, ForgeDirection.WEST);    
            model16Post.renderAll();

            if(tileC.render16Post(ForgeDirection.EAST)) 
                this.renderByOrientation(x, y, z, ForgeDirection.EAST);    
            model16Post.renderAll();
            
            GL11.glPopMatrix();
        }
    }

    public float changeColor() {

        Random rand = new Random();
        return rand.nextFloat();
    }

    private void renderByOrientation(double x, double y, double z, ForgeDirection direction) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);

        switch (direction) {

            case UP: {//Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
            return;
            }            
            case DOWN: {//Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                return;
            }

            case SOUTH: {//South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                return;
            }
            case NORTH: {//North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case WEST: {//West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                return;
            }
            case EAST: {//East
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
