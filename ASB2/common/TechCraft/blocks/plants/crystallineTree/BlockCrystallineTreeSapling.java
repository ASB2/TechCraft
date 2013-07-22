package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import TechCraft.BlockRegistry;
import TechCraft.Message;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftFlower;
import TechCraft.utils.*;

public class BlockCrystallineTreeSapling extends TechCraftFlower implements IPlantable, IBlockCycle {

    public BlockCrystallineTreeSapling(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    public void registerIcons(IconRegister par1IconRegister) {

        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockCrystillineSapling");
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {

        return EnumPlantType.Plains;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {

        return BlockRegistry.BlockCrystallineTreeSapling.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z) {

        return world.getBlockMetadata(x, y, z);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
    {        
        if(TechCraft.testingMode) {

            if(player.isSneaking()) {

                this.updateTick(world, x, y, z, new Random());

                if(!world.isRemote)
                    Message.sendToClient(world.getBlockMetadata(x, y, z) + "");
                return true;
            }

            this.growTree(world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

        this.managGrowth(world, x, y, z, random);
    }

    public void managGrowth(World world, int x, int y, int z, Random random) {

        Message.sendToClient(world.getBlockMetadata(x, y, z) + "");

        if(world.getBlockMetadata(x, y, z) >= 5) {

            Message.sendToClient(world.getBlockMetadata(x, y, z) + "");

            this.growTree(world, x, y, z);
            return;
        }

        if(random.nextInt(100) + 1 >= 90) {

            world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
        }
    }

    public void growTree(World world , int x, int y, int z) {

        int idLog = BlockRegistry.BlockCrystallineTreeLog.blockID;

        world.setBlock(x, y, z, idLog);

        for(int i = 0; i < TechCraft.crystilineTreeHight; i++) {

            UtilBlock.placeBlockInAir(world, x, y + i, z, idLog, 0);
        }
        UtilBlock.cycle3DBlock(null, world, x, y + TechCraft.crystilineTreeHight, z, ForgeDirection.DOWN, 2, this, 0);
    }

    @Override
    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side, int id) {

        int idLeaves = BlockRegistry.BlockCrystallineTreeLeaves.blockID;
        return UtilBlock.placeBlockInAir(world, x, y , z , idLeaves,0);
    }
}
