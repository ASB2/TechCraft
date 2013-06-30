package TechCraft.blocks.technogery.tcPost;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import TechCraft.lib.TEXTURES;
import TechCraft.models.Model8Post;
import cpw.mods.fml.client.FMLClientHandler;
import TechCraft.models.*;

public class ItemRendererPost implements IItemRenderer {

    private Model8Post modelPost = new Model8Post();
    private ModelFlat modelFlat = new ModelFlat();

    public ItemRendererPost() {

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
        GL11.glScalef(scale, scale, scale);

        GL11.glTranslatef(x + 0.5F, y + 2.5F, z + .5F);
        GL11.glRotatef(180F, 1F, 0F, 0F);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURES.BLANK);

        modelPost.renderAll();
        modelFlat.renderAll();
        
        GL11.glPopMatrix();
    }

}