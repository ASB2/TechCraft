package TechCraft.blocks.tcConduits.tcItemConduits;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.IConduitNetwork;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelPowerConduit;
import TechCraft.power.IPowerMisc;

public class TileRendererTCItemConduit extends TileEntitySpecialRenderer {

    private ModelPowerConduit modelMoving;

    public TileRendererTCItemConduit() {

        modelMoving = new ModelPowerConduit();
    }

    public void renderAModelAt(TileTCItemConduit tile, double d, double d1, double d2, float f) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(0F, 0F, 0F, 0F);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_MOVING_ITEM);
        modelMoving.renderCenter();

        if(decideRenderWire(ForgeDirection.DOWN, tile)) {
            modelMoving.renderWireDOWN();
        }

        if(decideRenderWire(ForgeDirection.UP, tile)) {
            modelMoving.renderWireUP();
        }

        if(decideRenderWire(ForgeDirection.WEST, tile)) {
            modelMoving.renderWireWEST();
        }

        if(decideRenderWire(ForgeDirection.EAST, tile)) {
            modelMoving.renderWireEAST();
        }

        if(decideRenderWire(ForgeDirection.SOUTH, tile)) {
            modelMoving.renderWireSOUTH();
        }

        if(decideRenderWire(ForgeDirection.NORTH, tile)) {
            modelMoving.renderWireNORTH();
        }


        if(decideRenderRing(ForgeDirection.DOWN, tile)) {
            modelMoving.renderRingDOWN();
        }

        if(decideRenderRing(ForgeDirection.UP, tile)) {
            modelMoving.renderRingUP();
        }

        if(decideRenderRing(ForgeDirection.WEST, tile)) {
            modelMoving.renderRingWEST();
        }

        if(decideRenderRing(ForgeDirection.EAST, tile)) {
            modelMoving.renderRingEAST();
        }

        if(decideRenderRing(ForgeDirection.SOUTH, tile)) {
            modelMoving.renderRingSOUTH();
        }

        if(decideRenderRing(ForgeDirection.NORTH, tile)) {
            modelMoving.renderRingNORTH();
        }

        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TileTCItemConduit)par1TileEntity, par2, par4, par6, par8);
    }    

    public boolean decideRenderWire(ForgeDirection direction, TileEntity tileT) {

        World world = tileT.worldObj;

        TileEntity tile = world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tileT)[0], TechCraftTile.translateDirectionToCoords(direction, tileT)[1], TechCraftTile.translateDirectionToCoords(direction, tileT)[2]);

        if(tile != null){

            if(tile instanceof IConduitNetwork) {


                return ((IConduitNetwork)tile).renderByDirection(direction);
            }

            if(tile instanceof IPowerMisc) {

                if(((IPowerMisc)tile).outputPower() || ((IPowerMisc)tile).recievePower()) {

                    return ((IPowerMisc)tile).renderByDirection(direction);
                }
            }
            return false;
        }
        return false;
    }

    public boolean decideRenderRing(ForgeDirection direction, TileEntity tileT) {

        World world = tileT.worldObj;

        TileEntity tile = world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tileT)[0], TechCraftTile.translateDirectionToCoords(direction, tileT)[1], TechCraftTile.translateDirectionToCoords(direction, tileT)[2]);

        if(tile != null) {

            if(tile instanceof IPowerMisc) {

                if(((IPowerMisc)tile).outputPower() || ((IPowerMisc)tile).recievePower()) {

                    return ((IPowerMisc)tile).renderByDirection(direction);
                }
            }
            return false;
        }
        return false;
    }
}