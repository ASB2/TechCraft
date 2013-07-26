package TechCraft.blocks.tcPersonalBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;
import TechCraft.utils.UtilBlock;

public class TilePersonalBlock extends TechCraftTile {

    boolean playerSet;
    String playerName = "";

    public TilePersonalBlock() {
    }
    
    public TilePersonalBlock(String player) {

        if(player.length() > 0) {

            playerName = player;
            playerSet = true;
        }
    }

    public void updateEntity() {}
    
    public boolean breakBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z) {

        if(world.getBlockId(x,y,z) != 0) {       

            if(player.username.equalsIgnoreCase(playerName) || !playerSet) {

                UtilBlock.breakBlock(world, x, y, z);
                return true;
            }
        }
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        playerName = tag.getString("playerName");
        playerSet = tag.getBoolean("playerSet");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag); 

        tag.setString("playerName", playerName);
        tag.setBoolean("playerSet", playerSet);
    }
}