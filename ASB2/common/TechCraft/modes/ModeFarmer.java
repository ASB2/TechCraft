package TechCraft.modes;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ModeFarmer extends ModeBase {

    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        ForgeDirection face = ForgeDirection.getOrientation(side);

        if(face == ForgeDirection.UP){
            player.sendChatToPlayer("Help " + world.setBlock(x,y,z, Block.tilledField.blockID));
            world.setBlock(x,y,z, Block.tilledField.blockID);
        }

        return true;
    }

    public String getModeName(){
        return"Farmer Mode";
    }

    public void shiftCoords(World world,int x,int y, int z, ForgeDirection side, int radius){


        x += (side.offsetX == 0 ? radius / 2 : 0);
        y += (side.offsetY == 0 ? radius / 2 : 0);
        z += (side.offsetZ == 0 ? radius / 2 : 0);

        for (int r = 0; r < radius; r++) {
            
            for (int c = 0; c < radius; c++) {
                
                int i = side.offsetX == 0 ? r : 0;
                int j = side.offsetY == 0 ? c : side.offsetX != 0 ? r : 0;
                int k = side.offsetZ == 0 ? c : 0;

                this.hoe(world, x - i, y - j, z - k);             
            }            
        }
    }

    public boolean hoe(World world, int x,int y, int z){    

        Block block = Block.blocksList[world.getBlockId(x, y, z)];

        if((block == Block.grass || block == Block.dirt)) {
            
            world.setBlock(x,y,z, Block.tilledField.blockID);
            return true;
        }
        return false;
    }

    public void plant(){

    }

    public void harvest(){

    }

}
