package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.models.ModelEnergySphere;

public class TileEntityRendererMagicEnergySphere extends TileEntitySpecialRenderer{

    private ModelEnergySphere modelTutBox = new ModelEnergySphere();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        modelTutBox.render((TileTCEnergySphere)tileEntity, x, y, z);
    }   
    
    
    
    
}

