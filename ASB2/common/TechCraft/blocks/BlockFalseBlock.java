package TechCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import TechCraft.utils.UtilPlayers;

public class BlockFalseBlock extends TechCraftBlocks {

    public BlockFalseBlock(int par1, Material par3Material) {
        super(par1, par3Material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:stone");
    }

    public boolean canCreatureSpawn() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    public boolean renderAsNormalBlock() {

        return false;
    }

    public boolean isOpaqueCube() {

        return false;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity) {

        if(entity instanceof EntityPlayer) {

            if((UtilPlayers.isSpecialPlayer(((EntityPlayer)entity).username))) {

                entity.extinguish();
            }
            
            else {
                entity.setInWeb();
            }
        }
        else {
            entity.setInWeb();
        }
    }
}
