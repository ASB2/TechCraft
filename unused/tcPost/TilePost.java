package TechCraft.blocks.technogery.tcPost;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPostAttachment;
import TechCraft.power.IPostStructure;
import TechCraft.utils.UtilDirection;

public class TilePost extends TechCraftTile implements IPostStructure {

    public void updateEntity() {

        if(!this.hasSupport()) {

        }
    }

    public boolean renderPlate(ForgeDirection direction) {

        if(UtilDirection.translateDirectionToIsBlockSolid(worldObj, direction, xCoord, yCoord, zCoord)) {

            return true;
        }
        return false;
    }

    public boolean render8Post(ForgeDirection direction) {

        TileEntity tile = UtilDirection.translateDirectionToTile(this, worldObj, direction);
        
        if(tile != null) {

            if(tile instanceof IPostStructure) {
                
                return true;
            }
        }

        return false;
    }
    
    public boolean render16Post(ForgeDirection direction) {

        TileEntity tile = UtilDirection.translateDirectionToTile(this, worldObj, direction);
        
        if(tile != null) {

            if(tile instanceof IPostAttachment) {
                
                return true;
            }
        }

        return false;
    }
    public String getName() {

        return "Post";
    }

    @Override
    public boolean hasSupport() {
        // TODO Auto-generated method stub
        return true;
    }
}
