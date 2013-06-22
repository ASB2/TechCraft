package TechCraft.blocks.item_transfer.item_SenderReciever;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;

public class BlockItemReciever extends TechCraftContainers {

    public BlockItemReciever(int par1, Material par2Material) {
        super(par1, par2Material);        
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
    {
        if(player.isSneaking())
            return false;

        player.openGui(TechCraft.instance, 9, world, x, y, z);
        return true;
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
