package TechCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import TechCraft.utils.UtilPlayers;

public class BlockFreezingFlower extends TechCraftFlower {

    public BlockFreezingFlower(int par1, Material par3Material) {
        super(par1, par3Material);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockFreezingFlower");
    }
    
    public boolean canBlockStay(World world, int x, int y, int z) {

        return world.getBlockId(x, y - 1, z) == Block.grass.blockID || world.getBlockId(x, y - 1, z) == Block.dirt.blockID;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int x, int y, int z, Entity entity) {
       
        if(entity instanceof EntityPlayer) {

            if(!(UtilPlayers.isSpecialPlayer(((EntityPlayer)entity).username))) {

                entity.setInWeb();  
            }
        }
        else {
            entity.setInWeb();
        }
    }
}