package TechCraft.blocks.technogery.tcTeleporter;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;

public class BlockTCTeleporter extends TechCraftContainers {

    TileTCTeleporter tile;
    
    public BlockTCTeleporter(int par1, Material par2Material) {
        super(par1, par2Material);
        
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;
        
        player.openGui(TechCraft.instance, 6, world, x, y, z);
        return true;
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        
        if(tile != null) {
            
            tile.onEntityWalking(world, x, y, z, entity);
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {

        tile = new TileTCTeleporter();
        return tile;
    }

}
