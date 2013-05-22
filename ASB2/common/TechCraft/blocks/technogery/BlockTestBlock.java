package TechCraft.blocks.technogery;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;
public class BlockTestBlock extends TechCraftContainers{

    public BlockTestBlock(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(!world.isRemote){
            
            
        }
        return true;
    }   

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:BlockTestBlock");
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileTestBlock();
    }
    
}
