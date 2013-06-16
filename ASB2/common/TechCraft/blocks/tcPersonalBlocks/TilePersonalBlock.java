package TechCraft.blocks.tcPersonalBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import TechCraft.blocks.TechCraftTile;

public class TilePersonalBlock extends TechCraftTile {

    boolean playerSet;
    String playerName = "";

    public TilePersonalBlock(String player) {

        if(player.length() > 0) {

            playerName = player;
            playerSet = true;
        }
    }

    public void updateEntity() {}
    
    public boolean breakBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z) {

        if(world.getBlockId(x,y,z) != 0) {       

            if(player.username.equalsIgnoreCase(playerName)) {

                world.playAuxSFX(2001, x, y, z, world.getBlockId(x,y,z) + (world.getBlockMetadata(x, y, z) << 12));
                Block.blocksList[world.getBlockId(x,y,z)].dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);

                return true;
            }
        }
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        playerName = tag.getString("playerName");

    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag); 

        tag.setString("playerName", playerName);
    }
}