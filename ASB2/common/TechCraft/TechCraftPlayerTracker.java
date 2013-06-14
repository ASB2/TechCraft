package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.*;
import TechCraft.utils.Utilities;

public class TechCraftPlayerTracker implements IPlayerTracker {

    @Override
    public void onPlayerLogin(EntityPlayer player) {

        if(Utilities.isSpecialPlayer(player.username)) {
            
            player.sendChatToPlayer("Welcome " + player.username);
        }
    }

    @Override
    public void onPlayerLogout(EntityPlayer player) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPlayerRespawn(EntityPlayer player) {
        // TODO Auto-generated method stub
        
    }

}
