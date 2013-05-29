package TechCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.lib.MODELS;
import TechCraft.lib.TEXTURES;
import cpw.mods.fml.client.FMLClientHandler;

public class ModelGear extends ModelBase{

    private IModelCustom modelTutBox;

    public ModelGear() {

        modelTutBox = AdvancedModelLoader.loadModel(MODELS.GEAR);
    }

    public void render() {

        modelTutBox.renderAll();
    }

    int rotate = 1;
    int updown = 0;

    public void render(TileMagicConduitImporting box, double x, double y, double z) {

        GL11.glPushMatrix();

        GL11.glTranslatef((float)x + 0.4f, (float)y + 0.1f, (float)z + 0.7f);

        GL11.glScalef(0.05f, 0.05f, 0.05f);

        GL11.glRotatef(0F, 180F, 0F, 0F);

        this.render();

        GL11.glPopMatrix();
    }

    public int rotate() {

        if(rotate < 360) {
            rotate++;
        }
        else{
            rotate = 0;
        }
        return rotate;
    }

    public void renderDown(double x, double y, double z) {

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        GL11.glScalef(0.03f, 0.03f, 0.03f);

        GL11.glTranslatef((float) x + 0F, (float) y + 45F, (float) z + 0F); 

        this.render();  
    }

    public void renderUp(double x, double y, double z) {
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        GL11.glScalef(0.03f, 0.03f, 0.03f);

        GL11.glTranslatef((float) x + 0F, (float) y + 45F, (float) z + 0F); 

        this.render();  

    }

    public void renderWest(double x, double y, double z) {
        modelTutBox.renderAll();
        GL11.glTranslatef((float) x + 13F, (float) y + 7F, (float) z + .5F);
        GL11.glRotatef(90F, 0F, 0F, 1F);        
    }

    public void renderEast(double x, double y, double z) {
        modelTutBox.renderAll();
        GL11.glTranslatef((float) x - 8F, (float) y + 13F - 1.8F, (float) z + .5F);
        GL11.glRotatef(-90F, 0F, 0F, 1F);        
    }

    public void renderSouth(double x, double y, double z) {
        modelTutBox.renderAll();
        GL11.glTranslatef((float) x + 0F, (float) y + 5F, (float) z - 14F);
        GL11.glRotatef(90F, 1F, 0F, 0F);

    }

    public void renderNorth(double x, double y, double z) {
        modelTutBox.renderAll();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 12F, (float) z + 7F);
        GL11.glRotatef(-90F, 1F, 0F, 0F);        
    }

}

