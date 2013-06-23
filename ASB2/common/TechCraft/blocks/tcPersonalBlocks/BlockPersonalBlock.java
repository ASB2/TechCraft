package TechCraft.blocks.tcPersonalBlocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPersonalBlock extends TechCraftContainers {

    public BlockPersonalBlock(int par1, Material par2Material) {
        super(par1, par2Material);
        setBlockUnbreakable();
    }

    Icon personalStone;
    Icon personalGlass;

    String playerName = "";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
        
            subItems.add(new ItemStack(this, 1, 0));
            subItems.add(new ItemStack(this, 1, 1));
    }
    
    @Override
    public int damageDropped (int metadata) {
        
        return metadata;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {
        
        return metaData;
    }

    @Override
    public boolean isOpaqueCube() {
        
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        
        personalGlass = iconRegister.registerIcon("TechCraft:BlockPersonalGlass");
        personalStone = iconRegister.registerIcon("TechCraft:BlockSpeedyRoadTop");
    }

    @Override
    public Icon getIcon(int side, int metadata) {

        switch(metadata) {

            case 0: return personalGlass;
            case 1: return personalStone;

            default: return blockIcon;
        }
    }

    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {

        switch(world.getBlockMetadata(x, y, z)) {
            
            case 0 : return true;
            case 1: return true;
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {

        if(entityLiving instanceof EntityPlayer) {

            playerName =  ((EntityPlayer)entityLiving).username;
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TilePersonalBlock(playerName);
    }
}