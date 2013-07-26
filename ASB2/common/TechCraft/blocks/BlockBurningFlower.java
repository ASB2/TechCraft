package TechCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import TechCraft.utils.UtilPlayers;

public class BlockBurningFlower extends TechCraftFlower {

    public BlockBurningFlower(int par1, Material par3Material) {
        super(par1, par3Material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockBurningFlower");
    }	

    public boolean canBlockStay(World world, int x, int y, int z) {

        return world.getBlockId(x, y - 1, z) == Block.grass.blockID || world.getBlockId(x, y - 1, z) == Block.dirt.blockID;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity) {

        if(entity instanceof EntityPlayer) {

            if(!(UtilPlayers.isSpecialPlayer(((EntityPlayer)entity).username))) {

                entity.attackEntityFrom(DamageSource.onFire, 1); 
            }
        }
        else {
            entity.attackEntityFrom(DamageSource.onFire, 1); 
        }
    }
}