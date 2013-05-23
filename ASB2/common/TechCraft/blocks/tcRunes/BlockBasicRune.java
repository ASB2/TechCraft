package TechCraft.blocks.tcRunes;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBasicRune extends BlockRuneBase{

    public BlockBasicRune(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {
        
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

}
