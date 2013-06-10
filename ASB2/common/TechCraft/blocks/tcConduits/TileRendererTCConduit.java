package TechCraft.blocks.tcConduits;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitInterface;
import TechCraft.models.ModelPowerConduit;

public class TileRendererTCConduit extends TileEntitySpecialRenderer {

    private ModelPowerConduit modelMoving;

    public TileRendererTCConduit() {

        modelMoving = new ModelPowerConduit();
    }

    public void renderAModelAt(TileTCConduit tile, double d, double d1, double d2, float f) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(0F, 0F, 0F, 0F);

        modelMoving.renderAll();

        if(decideRender(ForgeDirection.DOWN, tile)){
            modelMoving.renderDOWN();
        }

        if(decideRender(ForgeDirection.UP, tile)){
            modelMoving.renderUP();
        }

        if(decideRender(ForgeDirection.WEST, tile)){
            modelMoving.renderWEST();
        }

        if(decideRender(ForgeDirection.EAST, tile)){
            modelMoving.renderEAST();
        }

        if(decideRender(ForgeDirection.SOUTH, tile)){
            modelMoving.renderSOUTH();
        }

        if(decideRender(ForgeDirection.NORTH, tile)){
            modelMoving.renderNORTH();
        }
        
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TileTCConduit)par1TileEntity, par2, par4, par6, par8);
    }    

    public boolean decideRender(ForgeDirection direction, TileEntity tileT) {

        World world = tileT.worldObj;

        TileEntity tile = world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tileT)[0], TechCraftTile.translateDirectionToCoords(direction, tileT)[1], TechCraftTile.translateDirectionToCoords(direction, tileT)[2]);

        if(tile != null){

            if(tile instanceof IConduitInterface) { 


                return ((IConduitInterface)tile).renderByDirection(direction);
            }
            return false;
        }
        return false;
    }
}