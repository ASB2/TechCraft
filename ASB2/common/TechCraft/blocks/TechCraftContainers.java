package TechCraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;
import TechCraft.power.*;

public abstract class TechCraftContainers extends BlockContainer{

    public TechCraftContainers(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setCreativeTab(TechCraft.tabTechno);
        setHardness(3.5f);
        setTickRandomly(true);
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("TechCraft:GearBlock");
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {

        TileEntity tile = world.getBlockTileEntity(x, y, z);

        if(tile instanceof IPowerMisc) {

            IPowerMisc tile2 = ((IPowerMisc)tile);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);

        if(world.getBlockTileEntity(x, y, z) instanceof TechCraftTile) {

            ((TechCraftTile) world.getBlockTileEntity(x, y, z)).setOrientation(world.getBlockMetadata(x, y, z));
        }
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {

        return sideHit;
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileEntity tile = par1World.getBlockTileEntity(par2, par3, par4);

        if(tile instanceof IPowerMisc) {

            IPowerMisc tile2 = ((IPowerMisc)tile);

            if(tile2.getNetwork() != null) {

                if(tile2.outputPower() && !(tile2.recievePower())) {

                    tile2.getNetwork().removeSource(tile2);
                }

                if(tile2.recievePower() && !(tile2.outputPower())) {

                    tile2.getNetwork().removeSink(tile2);
                }

                if(tile2 instanceof TileMagicConduitMoving) {

                    TileMagicConduitMoving tile3 = (TileMagicConduitMoving)tile2;

                    tile3.getNetwork().removeConductor(tile3);
                }
            }
        }

        this.dropItems(par1World, par2, par3, par4);
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z)
    {
        Random prng = new Random();

        if(world.getBlockTileEntity(x, y, z) instanceof IInventory){
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
