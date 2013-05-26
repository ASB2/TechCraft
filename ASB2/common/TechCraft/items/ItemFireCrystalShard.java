package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.BlockRegistry;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;

public class ItemFireCrystalShard extends TechCraftItems {

    public ItemFireCrystalShard(int par1) {
        super(par1);
    }

    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(world.getBlockId(x, y, z) == BlockRegistry.BlockTCEnergySphere.blockID && world.getBlockTileEntity(x, y, z) instanceof TileTCEnergySphere){
            TileTCEnergySphere tile = (TileTCEnergySphere)world.getBlockTileEntity(x, y, z);
            tile.setColor(this);
            return true;
        }
        return false;
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemFireCrystalShard");
    }
}
