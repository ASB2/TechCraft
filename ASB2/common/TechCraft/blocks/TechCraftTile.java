package TechCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.EnumColor;
import TechCraft.IWrenchable;
import TechCraft.conduit.EnumContuitType;
import TechCraft.conduit.EnumInterfaceType;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerProvider;
import TechCraft.utils.UtilDirection;

public abstract class TechCraftTile extends TileEntity implements IPowerMisc, IWrenchable {

    protected PowerProvider powerProvider;
    protected ForgeDirection orientation;    
    protected EnumColor color;

    protected boolean shouldWork;

    protected int ticks = 0;

    public TechCraftTile() {
        
        if(color == null)
            color = EnumColor.WHITE;

        if(orientation == null)
            orientation = ForgeDirection.DOWN;
        
    }
    
    public boolean breakBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z,int side) {

        if(world.getBlockId(x,y,z) != 0) {       

            world.playAuxSFX(2001, x, y, z, world.getBlockId(x,y,z) + (world.getBlockMetadata(x, y, z) << 12));
            Block.blocksList[world.getBlockId(x,y,z)].dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);

            return true;
        }
        return false;
    }

    public void triggerBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z, int side ) {

    }

    public TechCraft.power.PowerProvider getPowerProvider() {

        return powerProvider;
    }

    public int[] getPosition() {

        return new int[] {this.xCoord, this.yCoord, this.zCoord};
    }
    public static EnumInterfaceType translateConduitTypeToInterfaceType(EnumContuitType cType){

        switch(cType){

            case ITEM: return EnumInterfaceType.ITEM;

            case LIQUID: return EnumInterfaceType.LIQUID;

            case TCU: return EnumInterfaceType.TCU;

            default: return EnumInterfaceType.OTHER;            
        }
    }

    public static EnumContuitType translateInterfaceTypeToConduitType(EnumInterfaceType cType){

        switch(cType){

            case ITEM: return EnumContuitType.ITEM;

            case LIQUID: return EnumContuitType.LIQUID;

            case TCU: return EnumContuitType.TCU;

            default: return EnumContuitType.OTHER;            
        }
    }

    public ForgeDirection getOrientation() {

        if(!(orientation == UtilDirection.translateNumberToDirection(getBlockMetadata()))) {

            this.orientation = UtilDirection.translateNumberToDirection(getBlockMetadata());
        }

        if(orientation == ForgeDirection.SOUTH) {
            return UtilDirection.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.NORTH) {
            return UtilDirection.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.UP) {
            return UtilDirection.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.DOWN) {
            return UtilDirection.translateDirectionToOpposite(orientation);
        }
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int id) {

        this.orientation = ForgeDirection.getOrientation(id);
    }

    public static EnumColor translateNumberToColor(int numb) {

        switch(numb) {

            case 0: return EnumColor.WHITE;
            case 1:return EnumColor.ORANGE;
            case 2:return EnumColor.MAGENTA;
            case 3:return EnumColor.LIGHT_BLUE;
            case 4:return EnumColor.YELLOW;
            case 5:return EnumColor.LIME;
            case 6:return EnumColor.PINK;
            case 7:return EnumColor.GRAY;
            case 8:return EnumColor.LIGHT_GREY;
            case 9:return EnumColor.CYAN;
            case 10:return EnumColor.PURPLE;
            case 11:return EnumColor.BLUE;
            case 12:return EnumColor.BROWN;
            case 13:return EnumColor.GREEN;
            case 14:return EnumColor.RED;
            case 15:return EnumColor.BLACK;
            default: return EnumColor.NONE;
        }
    }

    public static int translateColorToNumber(EnumColor color) {

        switch(color) {

            case WHITE: return 0;       
            case ORANGE: return 1;                
            case MAGENTA: return 2;
            case LIGHT_BLUE: return 3;            
            case YELLOW: return 4;            
            case LIME: return 5;            
            case PINK: return 6;
            case GRAY: return 7;
            case LIGHT_GREY: return 8;
            case CYAN: return 9;                
            case PURPLE: return 10;                
            case BLUE: return 11;
            case BROWN: return 12;
            case GREEN: return 13;
            case RED: return 14;
            case BLACK: return 15;

            case NONE: return -1;
            default: return -1;
        }
    }

    public void setColor(int color) {

        switch(color) {

            case 0: this.color = EnumColor.WHITE;
            case 1: this.color = EnumColor.ORANGE;
            case 2: this.color = EnumColor.MAGENTA;
            case 3: this.color = EnumColor.LIGHT_BLUE;
            case 4: this.color = EnumColor.YELLOW;
            case 5: this.color = EnumColor.LIME;
            case 6: this.color = EnumColor.PINK;
            case 7: this.color = EnumColor.GRAY;
            case 8: this.color = EnumColor.LIGHT_GREY;
            case 9: this.color = EnumColor.CYAN;
            case 10: this.color = EnumColor.PURPLE;
            case 11: this.color = EnumColor.BLUE;
            case 12: this.color = EnumColor.BROWN;
            case 13: this.color = EnumColor.GREEN;
            case 14: this.color = EnumColor.RED;
            case 15: this.color = EnumColor.BLACK;
            default: this.color = EnumColor.NONE;
        }
    }

    public void setColorEnum(EnumColor color) {

        this.color = color;
    }

    public static EnumColor getItemColorValue(ItemStack item) {


        return EnumColor.getItemColorValue(item);
    }

    public void toggleDirection() {

        switch(this.getOrientation()) {

            case DOWN: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.EAST), 3);
                break;
            }

            case UP: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.DOWN), 3);
                break;  
            }

            case NORTH: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.UP), 3);
                break;
            }

            case SOUTH: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.NORTH), 3);
                break;
            }

            case WEST: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.SOUTH), 3);
                break;
            }

            case EAST: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.WEST), 3);
                break;
            }

            case UNKNOWN: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, UtilDirection.translateDirectionToNumber(ForgeDirection.EAST), 3);
                break;
            }
        }
    }

    public int getPowerScaled(int scale) {

        if(this.getPowerProvider() != null) {

            if(this.getPowerProvider().getPowerStored() != 0 && this.getPowerProvider().getPowerMax() != 0) {

                int internal = this.getPowerProvider().getPowerStored() * scale / this.getPowerProvider().getPowerMax();

                if(internal > scale) {

                    internal = scale;
                }
                return internal;
            }        
        }
        return 0;
    }    

    public int getAmountScaled(int scale, int amount, int max) {

        int internal = amount * scale / max;

        if(internal > scale) {

            internal = scale;
        }
        return 0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Not Set";
    }

    @Override
    public EnumColor getColorEnum() {

        return color;
    }

    @Override
    public void setColor(EnumColor color) {

        this.color = color;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        if(color == EnumColor.NONE || color == null)
            color = TechCraftTile.translateNumberToColor(tag.getInteger("color"));

        if(this.getPowerProvider() != null)
            this.getPowerProvider().setPower(tag.getInteger("powerStored"));
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag); 

        if(this.getColorEnum() != EnumColor.NONE)
            tag.setInteger("color", TechCraftTile.translateColorToNumber(this.getColorEnum()));

        if(this.getPowerProvider() != null)
            tag.setInteger("powerStored", this.getPowerProvider().getPowerStored());
    }
}
