package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWrenchable {

    boolean breakBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z, int side);

    void triggerBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z, int side);
}
