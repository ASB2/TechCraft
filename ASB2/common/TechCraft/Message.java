package TechCraft;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Message {

    @SideOnly(Side.CLIENT)
    public static void sendToClient(String e) {       

        if(FMLClientHandler.instance().getSide() == Side.CLIENT) {
            
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(e);
        }
    }
}
