package TechCraft.renders;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import TechCraft.models.ModelPowerConduitImportingv2;

public class ItemRendererMagicConduitImporting implements IItemRenderer {

    private ModelPowerConduitImportingv2 modelTutBox;

    public ItemRendererMagicConduitImporting()
    {
        modelTutBox = new ModelPowerConduitImportingv2();
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
                renderTutBox(0f, 0f, 0f, 1f);
                return;
            }

            case EQUIPPED:{
                renderTutBox(0f, 0f, 1f, 1f);
                return;
            }

            case INVENTORY:{
                renderTutBox(0f, -1f, 0f, 1f);
                return;
            }
            case EQUIPPED_FIRST_PERSON:{
                renderTutBox(1f, -.2f, 1f, 1f);
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

        modelTutBox.renderAll();
        modelTutBox.renderTop();
        modelTutBox.renderBottom();
        //modelTutBox.renderRight();
        //modelTutBox.renderLeft();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}