package TechCraft.models;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class ModelEnergyReleaser extends ModelBase {
    
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelEnergyReleaser() {
      
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-5F, 0F, -5F, 10, 16, 10);
      Shape1.setRotationPoint(0F, 8F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(-8F, 0F, -8F, 16, 4, 16);
      Shape2.setRotationPoint(0F, 20F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(-7.5F, 0F, -7.5F, 15, 2, 15);
      Shape3.setRotationPoint(0F, 10F, 0F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

  boolean finishProduct = false;
  
  int ticks;
  public void renderAll(TileEntity box, double x, double y, double z) {
      
      ticks++;
      
      GL11.glPushMatrix();
      
      GL11.glTranslatef((float)x + 0.5f, (float)y  + 1.5f, (float)z + 0.5f);
      
      GL11.glRotatef(180, 180, 1, 1);
      
      Shape1.render(0.0625F);
      Shape2.render(0.0625F);
      
     
      
      GL11.glPopMatrix();
      //
      GL11.glPushMatrix();
      
      GL11.glTranslatef((float)x + 0.5f, (float)y  + 1.5f, (float)z + 0.5f);
      
      Random rand = new Random();
      
      if(finishProduct)
      GL11.glRotatef(180, 180, 1, rand.nextInt(180));
      
      else {
          GL11.glRotatef(180, 180, 1, ticks);
      }
      Shape3.render(0.0625F);
      
      if(ticks > 180)
          ticks = 0;
      GL11.glPopMatrix();
  }
}
