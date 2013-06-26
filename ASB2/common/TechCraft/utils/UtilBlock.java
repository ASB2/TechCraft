package TechCraft.utils;

import net.minecraft.world.World;

public class UtilBlock {

    public static void placeBlockInAir(World world, int x, int y, int z, int blockId, int metaData) {
        
        if(world.getBlockId( x, y , z)  == 0) {
            
            world.setBlock(x, y, z, blockId, metaData, 3);
        }
    }
}
