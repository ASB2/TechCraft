package TechCraft.blocks.tcDeepStorageCell;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;

public class BlockDeepStorageCell extends TechCraftContainers {

    Icon top;
    Icon sides;
    
    public BlockDeepStorageCell(int par1, Material par2Material) {
        super(par1, par2Material);        
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
    {
        if(player.isSneaking())
            return false;

        super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
        
        player.openGui(TechCraft.instance, 15, world, x, y, z);
        return true;
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        top = iconRegister.registerIcon("TechCraft:BlockDeepStorageCellTop");
        sides = iconRegister.registerIcon("TechCraft:ColoredBlack");
    }
    
    @Override
    public Icon getIcon(int side, int metadata) {
        
        switch(side) {
            
            case 1:{
                return top;
            }
            default: return sides;
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileDeepStorageCell();
    }
}
