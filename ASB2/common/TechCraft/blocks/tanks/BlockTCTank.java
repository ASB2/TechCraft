package TechCraft.blocks.tanks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;

public class BlockTCTank extends TechCraftContainers{

    Icon top;
    Icon sides;
    Icon bottom;
    
    public BlockTCTank(int par1, Material par2Material) {
        super(par1, par2Material);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;

        player.openGui(TechCraft.instance, 8, world, x, y, z);
        return true;
    }
    
    public boolean renderAsNormalBlock() {

        return false;
    }
    
    public boolean isOpaqueCube() {

        return false;
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        top = iconRegister.registerIcon("TechCraft:ColoredBlack");
        sides = iconRegister.registerIcon("TechCraft:ColoredBlack");
        bottom = iconRegister.registerIcon("TechCraft:ColoredBlack");
    }
    
    @Override
    public Icon getIcon(int side, int metadata) {
        
        switch(side) {
            
            case 0:{
                return bottom;
            }
            case 1:{
                return top;
            }
            default: return sides;
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        
        return new TileTCTank();
    }

}
