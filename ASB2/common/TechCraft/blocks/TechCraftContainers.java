package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.TechCraft;

public abstract class TechCraftContainers extends BlockContainer {

    public TechCraftContainers(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setCreativeTab(TechCraft.tabTechno);
        setHardness(100f);
        setResistance(100F);
    }
    
    public boolean canCreatureSpawn() {

        return false;
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:GearBlock");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
    {
        
        return false;
    }

    public void setColor(TileEntity tile, ItemStack stack) { 
        
        if(tile instanceof TechCraftTile)            
        ((TechCraftTile)tile).setColor(TechCraftTile.getItemColorValue(stack));
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, int metadata) {

        //TileEntity tile = world.getBlockTileEntity(x, y, z);

    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {

        //TileEntity tile = world.getBlockTileEntity(x, y, z);


        this.dropItems(world, x, y, z);
        super.onBlockDestroyedByPlayer(world, x, y, z, metaData);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {

        return sideHit;
    }

    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {

        //TileEntity tile = world.getBlockTileEntity(x, y, z);

        this.dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z) {

        Random prng = new Random();

        if(world.getBlockTileEntity(x, y, z) instanceof IInventory) {

            IInventory tileEntity = (IInventory)world.getBlockTileEntity(x, y, z);

            if(tileEntity == null)
                return;

            for(int slot = 0; slot < tileEntity.getSizeInventory(); slot++)
            {
                ItemStack item = tileEntity.getStackInSlot(slot);

                if(item != null && item.stackSize > 0)
                {
                    float rx = prng.nextFloat() * 0.8f + 0.1f;
                    float ry = prng.nextFloat() * 0.8f + 0.1f;
                    float rz = prng.nextFloat() * 0.8f + 0.1f;

                    EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, item.copy());
                    world.spawnEntityInWorld(entityItem);
                    item.stackSize = 0;
                }
            }
        }
    }
}
