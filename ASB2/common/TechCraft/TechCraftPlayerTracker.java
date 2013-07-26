package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import TechCraft.utils.UtilPlayers;
import cpw.mods.fml.common.IPlayerTracker;

public class TechCraftPlayerTracker implements IPlayerTracker {

    @Override
    public void onPlayerLogin(EntityPlayer player) {

        if(UtilPlayers.isSpecialPlayer(player.username)) {
            
            //player.sendChatToPlayer("Welcome " + player.username);
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
