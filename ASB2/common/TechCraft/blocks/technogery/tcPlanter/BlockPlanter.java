package TechCraft.blocks.technogery.tcPlanter;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlanter extends TechCraftContainers {

    //private Icon top;
    //private Icon side;

    public BlockPlanter(int par1, Material par2Material) {
        super(par1, par2Material);        
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;

        super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
        player.openGui(TechCraft.instance, 0, world, x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        super.registerIcons(par1IconRegister);
        //top = par1IconRegister.registerIcon("TechCraft:BlockTeleporterTop");  
        //side = par1IconRegister.registerIcon("TechCraft:ColoredBlack");
    }

    @Override
    public Icon getIcon(int side, int metadata) {

        return super.getIcon(side, metadata);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TilePlanter();
    }

}
