package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class TechCraftForgeEvents {


    @ForgeSubscribe
    public void onEntityJoin(EntityJoinWorldEvent event) {

        if(event.entity != null) {

            if(event.entity instanceof EntityPlayer) {

                EntityPlayer player = (EntityPlayer)event.entity;

                if(player.username == "ASB2") {
                    
                    Messenger.displayInChat("Welcome ASB2");
                }
            }
        }
    }
}
