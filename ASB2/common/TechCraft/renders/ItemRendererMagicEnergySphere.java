package TechCraft.renders;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelEnergySphere;

public class ItemRendererMagicEnergySphere implements IItemRenderer
{
    private ModelEnergySphere modelTutBox;

    public ItemRendererMagicEnergySphere()
    {
        modelTutBox = new ModelEnergySphere();
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
                renderTutBox(0f, 0f, 0f, 0.5f);
                return;
            }

            case EQUIPPED:{
                renderTutBox(0f, 1f, 1f, 0.5f);
                return;
            }

            case INVENTORY:{
                renderTutBox(0f, 0f, 0f, 0.5f);
                return;
            }

            default:return;
        }
    }

    private void renderTutBox(float x, float y, float z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);
        
        modelTutBox.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}