package TechCraft.items;

import TechCraft.BlockRegistry;
import TechCraft.blocks.technogery.TileMagiciansBuildingBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFireCrystalShard extends TechCraftItems {

    public ItemFireCrystalShard(int par1) {
        super(par1);
    }

    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(world.getBlockId(x, y, z) == BlockRegistry.BlockMagiciansBuildingBlocks.blockID && world.getBlockTileEntity(x, y, z) instanceof TileMagiciansBuildingBlocks){
            TileMagiciansBuildingBlocks tile = (TileMagiciansBuildingBlocks)world.getBlockTileEntity(x, y, z);
            tile.setColor(this);
        }
        return true;
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemFireCrystalShard");
    }
}
