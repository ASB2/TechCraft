package TechCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelItemReciever extends ModelBase {

    ModelRenderer Bottom;
    ModelRenderer LevelTwo;
    ModelRenderer LevelThree;
    ModelRenderer LevelFour;
    ModelRenderer LevelFive;
    ModelRenderer Center;

    public ModelItemReciever() {

        textureWidth = 128;
        textureHeight = 64;

        Bottom = new ModelRenderer(this, 0, 0);
        Bottom.addBox(-8F, 0F, -8F, 16, 1, 16);
        Bottom.setRotationPoint(0F, 23F, 0F);
        Bottom.setTextureSize(128, 64);
        Bottom.mirror = true;
        setRotation(Bottom, 0F, 0F, 0F);
        LevelTwo = new ModelRenderer(this, 0, 18);
        LevelTwo.addBox(-6F, 0F, -6F, 12, 2, 12);
        LevelTwo.setRotationPoint(0F, 21F, 0F);
        LevelTwo.setTextureSize(128, 64);
        LevelTwo.mirror = true;
        setRotation(LevelTwo, 0F, 0F, 0F);
        LevelThree = new ModelRenderer(this, 0, 33);
        LevelThree.addBox(-4F, 0F, -4F, 8, 1, 8);
        LevelThree.setRotationPoint(0F, 20F, 0F);
        LevelThree.setTextureSize(128, 64);
        LevelThree.mirror = true;
        setRotation(LevelThree, 0F, 0F, 0F);
        LevelFour = new ModelRenderer(this, 0, 43);
        LevelFour.addBox(-3F, 0F, -3F, 6, 1, 6);
        LevelFour.setRotationPoint(0F, 19F, 0F);
        LevelFour.setTextureSize(128, 64);
        LevelFour.mirror = true;
        setRotation(LevelFour, 0F, 0F, 0F);
        LevelFive = new ModelRenderer(this, 0, 51);
        LevelFive.addBox(-2F, 0F, -2F, 4, 1, 4);
        LevelFive.setRotationPoint(0F, 18F, 0F);
        LevelFive.setTextureSize(128, 64);
        LevelFive.mirror = true;
        setRotation(LevelFive, 0F, 0F, 0F);
        Center = new ModelRenderer(this, 17, 56);
        Center.addBox(-1F, 0F, -1F, 2, 6, 2);
        Center.setRotationPoint(0F, 12F, 0F);
        Center.setTextureSize(128, 64);
        Center.mirror = true;
        setRotation(Center, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Bottom.render(f5);
        LevelTwo.render(f5);
        LevelThree.render(f5);
        LevelFour.render(f5);
        LevelFive.render(f5);
        Center.render(f5);
    }
    
    public void renderAll() {
        
        Bottom.render(0.0625F);
        LevelTwo.render(0.0625F);
        LevelThree.render(0.0625F);
        LevelFour.render(0.0625F);
        LevelFive.render(0.0625F);
        Center.render(0.0625F);
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

}
