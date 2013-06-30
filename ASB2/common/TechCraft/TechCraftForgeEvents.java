package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent.Load;
import net.minecraftforge.event.world.WorldEvent.Unload;
import TechCraft.power.PowerManager;

public class TechCraftForgeEvents {


    @ForgeSubscribe
    public void onEntityJoin(EntityJoinWorldEvent event) {

        if(event.entity != null) {

            if(event.entity instanceof EntityPlayer) {

                EntityPlayer player = (EntityPlayer)event.entity;

                if(player.username == "ASB2") {
                    
                    Message.sendToClient("Welcome ASB2");
                }
            }
        }
    }
    
    @ForgeSubscribe
    public void worldChange(Load event) {
        
        PowerManager.getInstance().readFromNBT(PowerManager.getInstance().stackTagCompound);
    }
    
    @ForgeSubscribe
    public void worldChange(Unload event) {
        
        PowerManager.getInstance().writeToNBT(PowerManager.getInstance().stackTagCompound);
    }
}
