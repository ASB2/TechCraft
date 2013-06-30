package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergyInfuser;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererInfuser implements IItemRenderer {
    
    private ModelEnergyInfuser modelInfuser = new ModelEnergyInfuser();

    public ItemRendererInfuser(){
        
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch(type)
        {
            case ENTITY:{
                renderTutBox(0f, 0f, 0f, .8f);
                return;
            }

            case EQUIPPED:{
                renderTutBox(0f, 1f, 1f, .8f);
                return;
            }

            case INVENTORY:{
                renderTutBox(0f, 0f, 0f, .8f);
                return;
            }

            default:return;
        }
    }

    private void renderTutBox(float x, float y, float z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(x,  y - 1,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.ENERGY_RELEASER);

        modelInfuser.renderWithRotation(x,y,z);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}