package TechCraft.blocks.plants.crystallineTree;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import TechCraft.BlockRegistry;
import TechCraft.Message;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftBlocks;
import TechCraft.utils.UtilBlock;

public class BlockCrystallineTreeSapling extends TechCraftBlocks implements IPlantable {

    public BlockCrystallineTreeSapling(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setTickRandomly(true);
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
        if(player.isSneaking()) {
            
            this.updateTick(world, x, y, z, new Random());
            if(!world.isRemote)
            Message.sendToClient(world.getBlockMetadata(x, y, z) + "");
            return true;
        }
        this.growTree(world, x, y, z);
        return true;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

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
        int idLeaves = BlockRegistry.BlockCrystallineTreeLeaves.blockID;

        world.setBlock(x, y, z, idLog);

        for(int i = 0; i < TechCraft.crystilineTreeHight; i++) {

            UtilBlock.placeBlockInAir(world, x, y + i, z, idLog, 0);
        }

        for(int i = 0; i < 10; i++) {

            if( i >= 4) {

                for(int a = -5; a < 6   ; a++) {

                    for (int m = -1; m <= 1; m++) {

                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + m, idLeaves,0);

                        UtilBlock.placeBlockInAir(world, x + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + m, y + i, z + a + m, idLeaves,0);

                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x + a + m, y + i, z + a + m, idLeaves,0);

                        UtilBlock.placeBlockInAir(world, x - a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x - a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x - a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x - a + m, y + i, z + a + m, idLeaves,0);
                        UtilBlock.placeBlockInAir(world, x - a + m, y + i, z + a + m, idLeaves,0);

                    }
                }
            }
        }
    }
}
