package TechCraft.packets;

import net.minecraft.entity.player.EntityPlayer;
import TechCraft.power.IPowerMisc;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PowerPacket extends TechCraftPacketBase {

    int power;
    int x;
    int y;
    int z;    

    public PowerPacket(int power, int x, int y, int z) {

        this.power = power;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PowerPacket(){ };

    @Override
    protected void write(ByteArrayDataOutput out) {

        out.writeInt(this.power);

        out.writeInt(this.x);
        out.writeInt(this.y);
        out.writeInt(this.z);
    }

    @Override
    protected void read(ByteArrayDataInput in) throws ProtocolException {

        this.power = in.readInt();        

        this.x = in.readInt(); 
        this.y = in.readInt(); 
        this.z = in.readInt(); 
    }

    @Override
    protected void execute(EntityPlayer player, Side side) throws ProtocolException {

        if (side.isClient()) {

            if(player.worldObj.getBlockTileEntity(this.x, this.y, this.z) != null) {

                if(player.worldObj.getBlockTileEntity(this.x, this.y, this.z) instanceof IPowerMisc) {

                    IPowerMisc tile = (IPowerMisc) player.worldObj.getBlockTileEntity(this.x, this.y, this.z);
                    //tile.setPowerStored(power);
                    player.addChatMessage("Power packet sent to client power changed to " + power);
                }
            }
        }
        else {
            throw new ProtocolException("Cannot send this packet to the server!");
        }

    }
}
