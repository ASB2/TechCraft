package TechCraft.blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBurningFlower extends BlockFlower {


	public BlockBurningFlower(int par1, int par2, Material par3Material) {
		super(par1);
	}

	@Override
    public void registerIcons(IconRegister par1IconRegister) {
             this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockBurningFlower");
    }
	

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
	    
        par5Entity.attackEntityFrom(DamageSource.onFire, 1);
    }
}