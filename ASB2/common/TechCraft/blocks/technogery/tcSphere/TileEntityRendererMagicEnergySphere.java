package TechCraft.blocks.technogery.tcSphere;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftTile;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergySphere;
import TechCraft.models.ModelFlat;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.UtilDirection;

public class TileEntityRendererMagicEnergySphere extends TileEntitySpecialRenderer{

    private ModelEnergySphere modelSphere = new ModelEnergySphere();
    private ModelFlat modelFlat = new ModelFlat();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        if(tileEntity instanceof TechCraftTile) {

            GL11.glPushMatrix();

            TechCraft.proxy.renderTexture(TEXTURES.BLACK);
            
            modelSphere.render((TileTCEnergySphere)tileEntity, x, y, z);

            int coords[] = UtilDirection.translateDirectionToCoords(((TechCraftTile) tileEntity).getOrientation(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
            TileEntity tile = tileEntity.worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);

            if(tileEntity.getBlockMetadata() != 1) {
                
                if(tile != null && tile instanceof IPowerMisc) {

                    if(((IPowerMisc)tile).getPowerProvider() != null) {

                        renderByOrientation(x, y, z, tileEntity.getBlockMetadata());
                        modelFlat.renderAll();
                    }
                }
            }
            else {
                renderByOrientation(x, y, z, tileEntity.getBlockMetadata());
                modelFlat.renderAll();
            }

            GL11.glPopMatrix();
        }
    }   

    private void renderByOrientation(double x, double y, double z, int metadata) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);

        switch (metadata) {

            case 0: {//Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
                return;
            }            
            case 1: {//Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                return;
            }

            case 2: {//South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                return;
            }
            case 3: {//North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                return;
            }
            case 5: {//West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                return;
            }
            case 4: {//East
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

