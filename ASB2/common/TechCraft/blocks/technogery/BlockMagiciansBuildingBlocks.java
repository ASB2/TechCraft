package TechCraft.blocks.technogery;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockMagiciansBuildingBlocks extends TechCraftContainers {

    public BlockMagiciansBuildingBlocks(int par1, Material par2Material) {
        super(par1, par2Material);
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:BlockMagiciansBuildingBlocks");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(player.isSneaking())
            return false;
        
        return false;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {

        return metaData;
    }

    public void breakBlock(World world, int x, int y, int z, int par5, int par6){
        super.breakBlock(world, x, y, z, par5, par6);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new TileMagiciansBuildingBlocks();
    }

}