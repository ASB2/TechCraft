package TechCraft.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class UtilBlock {

    public static void placeBlockInAir(World world, int x, int y, int z, int blockId, int metaData) {

        if(world.getBlockId( x, y , z)  == 0) {

            world.setBlock(x, y, z, blockId, metaData, 3);
        }
    }

    public static boolean setBlock(World world, int x, int y, int z, int blockId, int metaData) {

        if(world.blockExists(x, y, z)) {

            if(blockId == 0) {

                world.setBlockToAir(x, y, z);
                return true;
            }
            else {

                world.setBlockMetadataWithNotify(x, y, z, blockId, metaData);
                return true;
            }
        }
        return false;
    }

    public static boolean cycle2DBlock(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side, int radius, IBlockCycle cycle)
    {
        x += (side.offsetX == 0 ? radius / 2 : 0);
        y += (side.offsetY == 0 ? radius / 2 : 0);
        z += (side.offsetZ == 0 ? radius / 2 : 0);

        boolean isSuccessful = false;

        for (int r = 0; r < radius; r++) {

            for (int c = 0; c < radius; c++) {

                int i = side.offsetX == 0 ? r : 0;
                int j = side.offsetY == 0 ? c : side.offsetX != 0 ? r : 0;
                int k = side.offsetZ == 0 ? c : 0;

                if ((cycle.execute(player, world, x - i, y - j, z - k, side)) && (!isSuccessful)) {

                    isSuccessful = true;
                }
            }
        }
        return isSuccessful;
    }

    public static boolean cycle3DBlock(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side, int distance, int radius, IBlockCycle cycle)
    {
        boolean isSuccessful = false;

        for (int h = 0; h < distance; h++) {

            int i = side.offsetX * h;
            int j = side.offsetY * h;
            int k = side.offsetZ * h;

            if ((cycle2DBlock(player, world, x - i, y - j, z - k, side, radius, cycle)) && (!isSuccessful)) {

                isSuccessful = true;
            }
        }
        return isSuccessful;
    }
}
