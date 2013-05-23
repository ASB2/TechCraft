package TechCraft.renders;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergySphere;

public class TileEntityRendererMagicEnergySphere extends TileEntitySpecialRenderer{

    private ModelEnergySphere modelTutBox = new ModelEnergySphere();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {


        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);
        modelTutBox.render((TileTCEnergySphere)tileEntity, x, y, z);
    }   
    
    
    
    
}

