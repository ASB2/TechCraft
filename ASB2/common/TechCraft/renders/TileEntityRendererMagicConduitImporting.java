package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.models.ModelMagicConduitImportingv2;

public class TileEntityRendererMagicConduitImporting extends TileEntitySpecialRenderer{

    private ModelMagicConduitImportingv2 model;

    public TileEntityRendererMagicConduitImporting(){
        model = new ModelMagicConduitImportingv2();
    }
    public void renderAModelAt(TileMagicConduitImporting tile, double d, double d1, double d2, float frame) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(0F, 0F, 0F, 0F);
        
        model.renderAll();
        
        if(tile.decideRender(ForgeDirection.DOWN)){
            model.renderBottom();
        }
        
        if(tile.decideRender(ForgeDirection.UP)){
            model.renderTop();
        }
        
        if(tile.decideRender(ForgeDirection.WEST)){
            model.renderLeft();
        }
        
        if(tile.decideRender(ForgeDirection.EAST)){
            model.renderRight();
        }
        
        if(tile.decideRender(ForgeDirection.SOUTH)){
            model.renderFront();
        }
        
        if(tile.decideRender(ForgeDirection.NORTH)){
            model.renderBack();
        }
        
        GL11.glPopMatrix();
    }



    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TileMagicConduitImporting)par1TileEntity, par2, par4, par6, par8);
    }    

}