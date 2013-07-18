package TechCraft.entitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class PseudoPlayer extends EntityPlayer {

    public PseudoPlayer(World world) {
        super(world);
        this.username = "PseudoPlayer";
    }

    @Override
    public void sendChatToPlayer(String s) {
        
        System.out.println(s);        
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
}
