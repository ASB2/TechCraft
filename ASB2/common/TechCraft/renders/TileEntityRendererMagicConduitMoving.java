package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.power_Conduit.TilePowerConduitMoving;
import TechCraft.models.ModelGear;
import TechCraft.models.ModelPowerConduitExportingv2;
import TechCraft.models.ModelPowerConduitImportingv2;
import TechCraft.models.ModelPowerConduitMovingv2;
import TechCraft.power.IPowerMisc;
import TechCraft.power.IPowerStorage;

public class TileEntityRendererMagicConduitMoving  extends TileEntitySpecialRenderer{

    private ModelPowerConduitMovingv2 modelMoving;
    private ModelPowerConduitImportingv2 modelImporting;
    private ModelPowerConduitExportingv2 modelExporting;
    @SuppressWarnings("unused")
    private ModelGear modelGear;
    
    public TileEntityRendererMagicConduitMoving() {

        modelMoving = new ModelPowerConduitMovingv2();
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
            modelMoving.renderBottom();
            //modelGear.renderDown(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.UP)){
            modelMoving.renderTop();
           // modelGear.renderUp(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.WEST)){
            modelMoving.renderLeft();
            //modelGear.renderWest(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.EAST)){
            modelMoving.renderRight();
            //modelGear.renderEast(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.SOUTH)){
            modelMoving.renderFront();
           // modelGear.renderSouth(d,d1,d2);
        }

        if(tile.decideRender(ForgeDirection.NORTH)){
            modelMoving.renderBack();
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

        TileEntity tile = world.getBlockTileEntity(this.translateDirectionToCoords(direction, tileT)[0], this.translateDirectionToCoords(direction, tileT)[1], this.translateDirectionToCoords(direction, tileT)[2]);

        if(tile != null){

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderBottom();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderBottom();
                        }
                        if(tile instanceof IPowerStorage) {
                            
                            modelMoving.renderBottom();
                        }
                        return true;
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderRight();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderRight();
                        }
                        if(tile instanceof IPowerStorage){
                            modelMoving.renderRight();
                        }
                        return true;
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderBack();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderBack();
                        }
                        if(tile instanceof IPowerStorage){
                            modelMoving.renderBack();
                        }
                        return true;
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderFront();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderFront();
                        }
                        if(tile instanceof IPowerStorage){
                            modelMoving.renderFront();
                        }
                        return true;
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderLeft();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderLeft();
                        }
                        if(tile instanceof IPowerStorage){
                            modelMoving.renderLeft();
                        }
                        return true;
                    }
                    break;
                }                
                case UP: {
                    
                    if(tile instanceof IPowerMisc) {                        

                        IPowerMisc tileI = (IPowerMisc) tile;

                        if(tileI.outputPower() && !(tile instanceof IPowerStorage)) {
                            modelImporting.renderTop();
                        }

                        if(tileI.recievePower() && !(tile instanceof IPowerStorage)) {
                            modelExporting.renderTop();
                        }
                        if(tile instanceof IPowerStorage){
                            modelMoving.renderTop();
                        }
                        return true;
                    }
                    break;
                }
                case UNKNOWN:
                    return false;

                default:
                    return false;
            }
        }
        return false;
    }

    public int[] translateDirectionToCoords(ForgeDirection direction, TileEntity tile) {

        switch(direction) {

            case DOWN: {
                return new int[]{tile.xCoord,tile.yCoord-1,tile.zCoord};
            }
            case UP: {
                return new int[]{tile.xCoord,tile.yCoord+1,tile.zCoord};
            }
            case NORTH: {
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord-1};
            }
            case SOUTH: {
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord+1};
            }
            case WEST: {
                return new int[]{tile.xCoord-1,tile.yCoord,tile.zCoord};
            }
            case EAST: {
                return new int[]{tile.xCoord+1,tile.yCoord,tile.zCoord};
            }
            case UNKNOWN:{
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord};
            }
        }

        return new int[]{tile.xCoord,tile.yCoord,tile.zCoord};
    }
}
