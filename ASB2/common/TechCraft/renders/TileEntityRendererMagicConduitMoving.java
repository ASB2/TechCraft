package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;
import TechCraft.models.ModelMagicConduitMovingv2;

public class TileEntityRendererMagicConduitMoving  extends TileEntitySpecialRenderer{

    private ModelMagicConduitMovingv2 model;

    public TileEntityRendererMagicConduitMoving(){
        model = new ModelMagicConduitMovingv2();
    }
    public void renderAModelAt(TileMagicConduitMoving tile, double d, double d1, double d2, float f) {

        int rotation = 0;
        if(tile.worldObj != null)
        {
            rotation = tile.getBlockMetadata();
        }

        bindTextureByName("/mods/TechCraft/textures/blocks/ModelMagicConduitMovingv2.png"); //texture
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);

        if(tile.getRenderBottom()){
            model.renderBottom();
        }
        if(tile.getRenderTop()){
            model.renderTop();
        }
        if(tile.getRenderLeft()){
            model.renderLeft();
        }
        if(tile.getRenderRight()){
            model.renderRight();
        }
        if(tile.getRenderFront()){
            model.renderFront();
        }
        if(tile.getRenderBack()){
            model.renderBack();
        }

        model.renderAll();
        GL11.glPopMatrix(); //end
    }



    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TileMagicConduitMoving)par1TileEntity, par2, par4, par6, par8);
    }    
}

