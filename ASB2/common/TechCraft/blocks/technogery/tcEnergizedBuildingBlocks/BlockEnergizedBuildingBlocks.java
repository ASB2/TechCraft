package TechCraft.blocks.technogery.tcEnergizedBuildingBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockEnergizedBuildingBlocks extends TechCraftContainers {

    public BlockEnergizedBuildingBlocks(int par1, Material par2Material) {
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
    public TileEntity createNewTileEntity(World world) {
	
        return new TileEnergizedBuildingBlocks();
    }

}