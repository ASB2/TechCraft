package TechCraft.blocks.conduitInterface.items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.ModelConduitInterface;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererItemConduitInterface implements IItemRenderer {

    private ModelConduitInterface model;

    public ItemRendererItemConduitInterface()
    {
        model = new ModelConduitInterface();
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
                render(0f, 0f, 0f, 1f);
                return;
            }

            case EQUIPPED:{
                render(0f, 0f, 1f, 1f);
                return;
            }

            case INVENTORY:{
                render(0f, -1f, 0f, 1f);
                return;
            }
            case EQUIPPED_FIRST_PERSON:{
                //render(-.5f, -.1f, 1f, 1f);
            }

            default:return;
        }
    }

    private void render(float x, float y, float z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);

        GL11.glTranslatef(x + 0.5F, y + 2.5F, z + .5F);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.CONDUIT_ITEM_INTERFACE_NONE);

        model.renderAll();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
