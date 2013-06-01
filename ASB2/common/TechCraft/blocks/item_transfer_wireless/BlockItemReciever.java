package TechCraft.blocks.item_transfer_wireless;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockItemReciever extends TechCraftContainers {

    public BlockItemReciever(int par1, Material par2Material) {
        super(par1, par2Material);        
    }

    public boolean renderAsNormalBlock() {

        return false;
    }

    public boolean isOpaqueCube() {

        return false;
    }

    public int getRenderType()
    {
        return -1;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileItemReciever();
    }
}
