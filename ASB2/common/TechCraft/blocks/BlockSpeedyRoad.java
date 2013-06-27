package TechCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.potion.*;

public class BlockSpeedyRoad extends TechCraftBlocks {

    private Icon top;
    private Icon side;

    public BlockSpeedyRoad(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        top = par1IconRegister.registerIcon("TechCraft:BlockSpeedyRoadTop");  
        side = par1IconRegister.registerIcon("TechCraft:BlockSpeedyRoadSide2");
    }

    @Override
    public Icon getIcon(int side, int metadata) {

        switch(side) {

            case 1: {
                return top;
            }
            default: return this.side;
        }

    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {

        if(!world.isBlockIndirectlyGettingPowered(x, y, z)) {
            
            if(entity instanceof EntityLiving) {

                ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 3));
                ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.jump.id, 10, 3));

                if(((EntityLiving)entity).isBurning()) {

                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 4));
                }

                if(((EntityLiving)entity).isBlocking()) {

                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 4));
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 4));
                }

                if(((EntityLiving)entity).isInWater()) {

                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10, 4));
                }
            }
        }
    }
}
