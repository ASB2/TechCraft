package TechCraft.modes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModeTest extends ModeBase{

    public void onRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
        player.sendChatToPlayer("You are NOT shift clicking");
    }

    public void onShiftClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
        player.sendChatToPlayer("You are ARE shift clicking");
    }
    
    public String getModeName(){
        return "Mode Test";
    }

}
