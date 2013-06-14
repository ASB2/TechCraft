package TechCraft.blocks.tcPersonalGlass;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftContainers;

public class BlockPersonalGlass extends TechCraftContainers {

    public BlockPersonalGlass(int par1, Material par2Material) {
        super(par1, par2Material);
        setBlockUnbreakable();
    }

    String playerName = "";
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {

        if(entityLiving instanceof EntityPlayer) {
            
            playerName =  ((EntityPlayer)entityLiving).username;
        }
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:BlockPersonalGlass");
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TilePersonalGlass(playerName);
    }
}