package TechCraft.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.lib.TEXTURES;
import TechCraft.models.*;

public class TileEntityRendererMagicConduitImporting extends TileEntitySpecialRenderer{

    private ModelGrinder model;

    public TileEntityRendererMagicConduitImporting(){
        model = new ModelGrinder();
    }
    public void renderAModelAt(TileMagicConduitImporting tile, double x, double y, double z, float frame) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);
        
        model.render(tile, x, y, z);
    }



    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){

        this.renderAModelAt((TileMagicConduitImporting)par1TileEntity, par2, par4, par6, par8);
    }    

}