package TechCraft.blocks.technogery.tcPost;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftContainers;

public class BlockPost extends TechCraftContainers {

    public BlockPost(int par1, Material par2Material) {
        super(par1, par2Material);

        this.setTickRandomly(true);    
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {

        return true;
    }

    public boolean canBlockStayByDirection(World world, ForgeDirection side, int x, int y, int z) {

        return true;
    }
    
    public boolean canBlockStay(World world, int x, int y, int z) {
    
        return true;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TilePost();
    }
}
