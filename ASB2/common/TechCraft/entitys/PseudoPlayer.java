package TechCraft.entitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class PseudoPlayer extends EntityPlayer {

    public PseudoPlayer(World world) {
        super(world, "PseudoPlayer");
    }

    @Override
    public boolean canCommandSenderUseCommand(int i, String s) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public ChunkCoordinates getPlayerCoordinates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) {
        // TODO Auto-generated method stub
        
    }
}
