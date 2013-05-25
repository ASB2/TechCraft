package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergySphere;
import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityRendererMagicEnergySphere extends TileEntitySpecialRenderer{

    private ModelEnergySphere modelTutBox = new ModelEnergySphere();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        renderByOrientation(x,y,z,tileEntity.getBlockMetadata());

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        modelTutBox.render((TileTCEnergySphere)tileEntity, x, y, z);
    }   

    private void renderByOrientation(double x, double y, double z, int metadata) {

        switch (metadata) {

            case 0: {//Down
                GL11.glColor3f(0F, 0F, 0F); 
                break;
            }            
            case 1: {//Up
                GL11.glColor3f(1.0f, 1.0f, 0.0f);
                break;
            }

            case 2: {//South
                GL11.glColor3f(0, 1, 0); 
                break;
            }
            case 3: {//North
                GL11.glColor3f(1, 0, 0); 
                break;

            }
            case 4: {//East
                GL11.glColor3f(0, 0, 1); 
                break;

            }
            default: {//Other
                GL11.glColor3f(0F, 0F, 0F); 
                return;
            }
        }
    }

}

