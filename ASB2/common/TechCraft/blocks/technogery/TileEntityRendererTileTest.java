package TechCraft.blocks.technogery;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.TechCraft;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelTest;

public class TileEntityRendererTileTest extends TileEntitySpecialRenderer{

    private ModelTest model;

    public TileEntityRendererTileTest(){
        model = new ModelTest();
    }
    
    public void renderAModelAt(TileEntity tile, double x, double y, double z, float frame) {

        TechCraft.proxy.renderTexture(TEXTURES.BLANK);
        
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
        
        model.attachment.render(0.0625F);
        model.post.render(0.0625F);
        model.stub.render(0.0625F);
        model.join.render(0.0625F);
        
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.1D, z + 0.5D);
        model.post.render(0.0625F);
        model.stub.render(0.0625F);
        model.join.render(0.0625F);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt(par1TileEntity, par2, par4, par6, par8);
    }
}