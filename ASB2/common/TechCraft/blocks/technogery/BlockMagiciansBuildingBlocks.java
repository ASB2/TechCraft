package TechCraft.blocks.technogery;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagiciansBuildingBlocks extends TechCraftContainers {

    public BlockMagiciansBuildingBlocks(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public int damageDropped (int metadata) {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings({ "rawtypes", "unchecked" })    
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 4; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }

    public int getRenderType()
    {
        return -1;
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