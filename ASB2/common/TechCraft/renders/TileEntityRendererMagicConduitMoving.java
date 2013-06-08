package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.TechCraftTile;
import TechCraft.blocks.technogery.power_Conduit.TilePowerConduitMoving;
import TechCraft.models.ModelGear;
import TechCraft.models.ModelPowerConduit;
import TechCraft.models.ModelPowerConduitExportingv2;
import TechCraft.models.ModelPowerConduitImportingv2;
import TechCraft.power.IPowerMisc;

public class TileEntityRendererMagicConduitMoving  extends TileEntitySpecialRenderer{

    private ModelPowerConduit modelMoving;
    private ModelPowerConduitImportingv2 modelImporting;
    private ModelPowerConduitExportingv2 modelExporting;
    @SuppressWarnings("unused")
    private ModelGear modelGear;

    public TileEntityRendererMagicConduitMoving() {

        modelMoving = new ModelPowerConduit();
        modelImporting = new ModelPowerConduitImportingv2();
        modelExporting = new ModelPowerConduitExportingv2();
        modelGear = new ModelGear();
    }

    public void renderAModelAt(TilePowerConduitMoving tile, double d, double d1, double d2, float f) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(0F, 0F, 0F, 0F);

        modelMoving.renderAll();

        if(tile.decideRender(ForgeDirection.DOWN)){
            modelMoving.renderDOWN();
            //modelGear.renderDown(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.UP)){
            modelMoving.renderUP();
            // modelGear.renderUp(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.WEST)){
            modelMoving.renderWEST();
            //modelGear.renderWest(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.EAST)){
            modelMoving.renderEAST();
            //modelGear.renderEast(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.SOUTH)){
            modelMoving.renderSOUTH();
            // modelGear.renderSouth(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.NORTH)){
            modelMoving.renderNORTH();
            //modelGear.renderNorth(d,d1,d2);
        }

        decideRender(ForgeDirection.DOWN, tile);
        decideRender(ForgeDirection.UP, tile);
        decideRender(ForgeDirection.WEST, tile);
        decideRender(ForgeDirection.EAST, tile);
        decideRender(ForgeDirection.SOUTH, tile);
        decideRender(ForgeDirection.NORTH, tile);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TilePowerConduitMoving)par1TileEntity, par2, par4, par6, par8);
    }    

    public boolean decideRender(ForgeDirection direction, TileEntity tileT) {

        World world = tileT.worldObj;

        TileEntity tile = world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tileT)[0], TechCraftTile.translateDirectionToCoords(direction, tileT)[1], TechCraftTile.translateDirectionToCoords(direction, tileT)[2]);

        if(tile != null){

            if(tile instanceof IPowerMisc) { 

                IPowerMisc tileI = (IPowerMisc) tile;

                if(tileI.powerByDirection(TechCraftTile.translateDirectionToOpposite(direction))) {

                    switch(direction) {

                        case DOWN: {

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderBottom();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderBottom();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderDOWN();
                            }
                            return true;
                        }
                        case EAST: {                  

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderRight();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderRight();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderEAST();
                            }
                            return true;
                        }
                        case NORTH: {

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderBack();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderBack();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderNORTH();
                            }
                            return true;
                        }
                        case SOUTH: {

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderFront();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderFront();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderSOUTH();
                            }
                            return true;
                        }
                        case WEST: {

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderLeft();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderLeft();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderWEST();
                            }
                            return true;
                        }
                        case UP: {

                            if(tileI.outputPower() && !(tileI.recievePower())) {

                                modelImporting.renderTop();
                            }

                            if(tileI.recievePower() && !(tileI.outputPower())) {
                                modelExporting.renderTop();
                            }

                            if(tileI.outputPower() && tileI.recievePower()) {

                                modelMoving.renderUP();
                            }
                            return true;
                        }
                        case UNKNOWN:
                            return false;

                        default:
                            return false;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
