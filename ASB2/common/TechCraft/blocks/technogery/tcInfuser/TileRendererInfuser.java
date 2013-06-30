package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergyInfuser;
import cpw.mods.fml.client.FMLClientHandler;

public class TileRendererInfuser extends TileEntitySpecialRenderer{

    private ModelEnergyInfuser modelInfuser = new ModelEnergyInfuser();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        if(tileEntity instanceof TileTCInfuser) {

            GL11.glPushMatrix();

            FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.ENERGY_RELEASER);
            modelInfuser.renderWithRotation((float)x, (float)y, (float)z);

            GL11.glPopMatrix();
        }
    }   
}