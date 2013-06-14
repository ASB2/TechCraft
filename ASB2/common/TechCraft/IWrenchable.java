package TechCraft;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public interface IWrenchable {

    boolean breakBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z);
}
