package TechCraft.blocks.technogery;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergyReleaser;
import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityRendererTileTest extends TileEntitySpecialRenderer{

    private ModelEnergyReleaser model;

    public TileEntityRendererTileTest(){
        model = new ModelEnergyReleaser();
    }
    
    public void renderAModelAt(TileEntity tile, double x, double y, double z, float frame) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);
        
        model.renderAll(tile, x, y, z);
    }



    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt(par1TileEntity, par2, par4, par6, par8);
    }    

}