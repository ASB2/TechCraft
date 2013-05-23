package TechCraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.interfaces.power.TechCraftTile;

public abstract class TechCraftContainers extends BlockContainer{

    public TechCraftContainers(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setCreativeTab(TechCraft.tabTechno);
        setHardness(3.5f);
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:BlockTestBlock");
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
        
        ((TechCraftTile) world.getBlockTileEntity(x, y, z)).setOrientation(world.getBlockMetadata(x, y, z));

        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {

        return sideHit;
    }

}
