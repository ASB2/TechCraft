package TechCraft.blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockFreezingFlower extends BlockFlower {

    public BlockFreezingFlower(int par1, Material par3Material) {
        super(par1, par3Material);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockFreezingFlower");
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        par5Entity.setInWeb();
    }
}