package TechCraft.modes;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModelFreezing extends ModeBase{

    
    public void onRightClickOnBlock(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        //if(world.getBlockId(x, y, z) == Block.waterMoving.blockID || world.getBlockId(x, y, z) == Block.waterStill.blockID){
            
            world.setBlock(x, y, z, Block.waterMoving.blockID  );
       // }
    }
}
