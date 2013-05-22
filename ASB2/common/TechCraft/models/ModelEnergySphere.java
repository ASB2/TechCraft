package TechCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.lib.MODELS;
import TechCraft.lib.TEXTURES;
import cpw.mods.fml.client.FMLClientHandler;

public class ModelEnergySphere extends ModelBase{

    private IModelCustom modelTutBox;

    public ModelEnergySphere() {

        modelTutBox = AdvancedModelLoader.loadModel(MODELS.ENERGY_SPHERE_MODEL);
    }

    public void render() {
        modelTutBox.renderAll();
    }

    int rotate = 1;
    int updown = 0;

    public void render(TileTCEnergySphere box, double x, double y, double z) {

        GL11.glPushMatrix();

        GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f+updown, (float)z + 0.5f);

        GL11.glScalef(0.5f, 0.5f, 0.5f);

        GL11.glRotatef(rotate(box), rotate(box), rotate(box), rotate(box));

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        this.render();

        GL11.glPopMatrix();
    }

    public int rotate(TileTCEnergySphere tile) {

        if(rotate > 360) {

            rotate = 0;
        }

        rotate++;

        if(tile.getPowerStored() > 0){

            rotate = rotate * tile.getPowerStored();
        }
        return rotate;
    }
}

