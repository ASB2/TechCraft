package TechCraft.blocks.tcRunes;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import TechCraft.TechCraft;

public class BlockBasicRune extends BlockRuneBase {

    TileBasicRune tile;

    public BlockBasicRune(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;

        player.openGui(TechCraft.instance, 4, world, x, y, z);
        return true;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec)
    {
        if(tile != null) {
            
            switch (tile.getOrientation()) {

                case DOWN: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case UP: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case NORTH: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case SOUTH: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case EAST: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case WEST: {
                    this.setBlockBounds(0, 0, 0, 1, 1, 1);
                }
                case UNKNOWN: {
                }
            }
        }
        return super.collisionRayTrace(world, x, y, z, startVec, endVec);
    }


    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {
        if(tile != null) {

            tile.onEntityEnterBlock(par1World, par2, par3, par4, par5Entity);
        }        
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        tile = new TileBasicRune();
        return tile;
    }

}
