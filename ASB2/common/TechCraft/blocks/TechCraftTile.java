package TechCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
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
import TechCraft.power.*;

public abstract class TechCraftTile extends TileEntity implements IPowerMisc, IWrenchable {

    protected PowerProvider powerProvider;
    protected ForgeDirection orientation;    
    protected EnumColor color;

    int powerStored = 0;
    int powerMax = 0;

    protected int ticks = 0;

    public TechCraftTile() {

        if(color == null)
            color = EnumColor.NONE;

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

        if(!(orientation == TechCraftTile.translateNumberToDirection(getBlockMetadata()))) {

            this.orientation = TechCraftTile.translateNumberToDirection(getBlockMetadata());
        }

        if(orientation == ForgeDirection.SOUTH) {
            return TechCraftTile.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.NORTH) {
            return TechCraftTile.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.UP) {
            return TechCraftTile.translateDirectionToOpposite(orientation);
        }
        if(orientation == ForgeDirection.DOWN) {
            return TechCraftTile.translateDirectionToOpposite(orientation);
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

    public static int translateColorToInt(EnumColor color) {

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

        if(item != null){

            if(item.getItem() != null) {

                Item itemI = item.getItem();

                if(itemI instanceof ItemDye){

                    switch(item.getItemDamage()) {

                        case 1: return EnumColor.RED;
                        case 2: return EnumColor.GREEN;
                        case 3: return EnumColor.BROWN;
                        case 4: return EnumColor.BLUE;
                        case 5: return EnumColor.PURPLE;
                        case 6: return EnumColor.CYAN;
                        case 7: return EnumColor.LIGHT_GREY;
                        case 8: return EnumColor.GRAY;
                        case 9: return EnumColor.PINK;
                        case 10: return EnumColor.LIME;
                        case 11: return EnumColor.YELLOW;
                        case 12: return EnumColor.LIGHT_BLUE;
                        case 13: return EnumColor.MAGENTA;
                        case 14: return EnumColor.ORANGE;
                        case 15: return EnumColor.WHITE;
                    }
                }
            }
        }
        return EnumColor.NONE;        
    }

    public void toggleDirection() {

        switch(getOrientation()) {

            case DOWN: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, TechCraftTile.translateDirectionToNumber(ForgeDirection.UP), 3);
                return;
            }

            case UP: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, TechCraftTile.translateDirectionToNumber(ForgeDirection.NORTH), 3);
                return;
            }

            case NORTH: {

                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, TechCraftTile.translateDirectionToNumber(ForgeDirection.SOUTH), 3);
                return;
            }

            case SOUTH: {
                this.setOrientation(ForgeDirection.WEST);
                return;
            }

            case WEST: {
                this.setOrientation(ForgeDirection.EAST);
                break;
            }

            case EAST: {
                this.setOrientation(ForgeDirection.DOWN);
                break;
            }

            default: //this.setOrientation(ForgeDirection.DOWN);
                break;

        }
    }

    public static int[] translateDirectionToCoords(ForgeDirection direction, TileEntity tile) {

        switch(direction) {

            case DOWN: {
                return new int[]{tile.xCoord,tile.yCoord-1,tile.zCoord};
            }
            case UP: {
                return new int[]{tile.xCoord,tile.yCoord+1,tile.zCoord};
            }
            case NORTH: {
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord-1};
            }
            case SOUTH: {
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord+1};
            }
            case WEST: {
                return new int[]{tile.xCoord-1,tile.yCoord,tile.zCoord};
            }
            case EAST: {
                return new int[]{tile.xCoord+1,tile.yCoord,tile.zCoord};
            }
            case UNKNOWN:{
                return new int[]{tile.xCoord,tile.yCoord,tile.zCoord};
            }
        }

        return new int[]{tile.xCoord,tile.yCoord,tile.zCoord};
    }

    public static ForgeDirection translateDirectionToOpposite(ForgeDirection direction) {

        switch(direction) {

            case DOWN: {
                return ForgeDirection.UP;
            }
            case UP: {
                return ForgeDirection.DOWN;
            }
            case NORTH: {
                return ForgeDirection.SOUTH;
            }
            case SOUTH: {
                return ForgeDirection.NORTH;
            }
            case WEST: {
                return ForgeDirection.EAST;
            }
            case EAST: {
                return ForgeDirection.WEST;
            }
            case UNKNOWN:{
                return ForgeDirection.UNKNOWN;
            }
        }

        return ForgeDirection.UNKNOWN;
    }

    public static int translateDirectionToNumber(ForgeDirection direction) {

        int var1 = -1;

        switch(direction) {

            case DOWN: {
                var1 = 0;
                return var1;
            }
            case UP: {
                var1 = 1;
                return var1;
            }
            case NORTH: {
                var1 = 2;
                return var1;
            }                       
            case SOUTH: {
                var1 = 3;
                return var1;
            }
            case WEST: {
                var1 = 5;
                return var1;
            }
            case EAST: {
                var1 = 4;
                return var1;
            }
            default:{
                return var1;
            }
        }
    }

    public static ForgeDirection translateNumberToDirection(int direction) {

        switch(direction) {

            case 0: {
                return ForgeDirection.DOWN;
            }
            case 1: {
                return ForgeDirection.UP;
            }
            case 2: {
                return ForgeDirection.NORTH;
            }
            case 3: {
                return ForgeDirection.SOUTH;
            }
            case 5: {
                return ForgeDirection.WEST;
            }
            case 4: {
                return ForgeDirection.EAST;
            }
            case -1: {
                return ForgeDirection.UNKNOWN;
            }
            default: {
                return ForgeDirection.UNKNOWN;
            }
        }
    }

    public static String translateDirectionToString(ForgeDirection direction) {

        switch(direction) {

            case DOWN: {
                return "Down";
            }
            case UP: {
                return "Up";
            }
            case NORTH: {
                return "North";
            }
            case SOUTH: {
                return "South";
            }
            case WEST: {
                return "West";
            }
            case EAST: {
                return "East";
            }
            default:{
                return "Unknown";
            }
        }
    }

    public static TileEntity[] getArrayTilesAround(World world, TileEntity tile) {

        return new TileEntity[] {
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.DOWN),
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.UP),
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.NORTH),
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.SOUTH),
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.WEST),
                TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.EAST)};
    }

    public static int getTilesNextTo(int x, int y, int z, World worldObj) {
        int numberNextTo = 0;
        //Bottom of Tile
        if(worldObj.getBlockTileEntity(x, y-1, z) instanceof IPowerMisc){
            numberNextTo++;
        }
        //top of Tile
        if(worldObj.getBlockTileEntity(x, y+1, z) instanceof IPowerMisc){
            numberNextTo++;
        }        
        //left
        if(worldObj.getBlockTileEntity(x, y, z-1) instanceof IPowerMisc){
            numberNextTo++;
        }
        //right
        if(worldObj.getBlockTileEntity(x, y, z+1) instanceof IPowerMisc){
            numberNextTo++;
        }
        //front
        if(worldObj.getBlockTileEntity(x+1, y, z) instanceof IPowerMisc){
            numberNextTo++;
        }
        //back
        if(worldObj.getBlockTileEntity(x-1, y, z) instanceof IPowerMisc){
            numberNextTo++;
        }
        return numberNextTo;
    }

    public static int getTilesNextTo(TileEntity tile, World worldObj) {
        int numberNextTo = 0;
        //Bottom of Tile
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord-1, tile.zCoord) instanceof TileEntity){
            numberNextTo++;
        }
        //top of Tile
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord+1, tile.zCoord) instanceof TileEntity){
            numberNextTo++;
        }        
        //left
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord-1) instanceof TileEntity){
            numberNextTo++;
        }
        //right
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord+1) instanceof TileEntity){
            numberNextTo++;
        }
        //front
        if(worldObj.getBlockTileEntity(tile.xCoord+1, tile.yCoord, tile.zCoord) instanceof TileEntity){
            numberNextTo++;
        }
        //back
        if(worldObj.getBlockTileEntity(tile.xCoord-1, tile.yCoord, tile.zCoord) instanceof TileEntity){
            numberNextTo++;
        }
        return numberNextTo;
    }

    public static TileEntity translateDirectionToTile(TileEntity tile, World world, ForgeDirection direction) {

        switch(direction) {

            case DOWN: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case UP: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case NORTH: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case SOUTH: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case WEST: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case EAST: {
                return world.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, tile)[0], TechCraftTile.translateDirectionToCoords(direction, tile)[1], TechCraftTile.translateDirectionToCoords(direction, tile)[2]);
            }
            case UNKNOWN:{
                return null;
            }
        }

        return null;
    }

    public void managePowerAll(TileEntity tile, boolean addPower) {

        int amountOfPower;

        if(tile instanceof IPowerMisc) {

            if(((IPowerMisc)tile).getPowerProvider() != null) {

                if(addPower) {

                    amountOfPower = ((IPowerMisc)tile).getPowerProvider().getOutput();

                    if(TechCraftTile.getTilesNextTo(tile.xCoord, tile.yCoord, tile.zCoord, worldObj) > 0){

                        amountOfPower = amountOfPower / TechCraftTile.getTilesNextTo(tile.xCoord, tile.yCoord, tile.zCoord, worldObj);
                    }        
                }

                else {

                    amountOfPower = ((IPowerMisc)tile).getPowerProvider().getInput();
                }
                transferPower(ForgeDirection.DOWN, tile, amountOfPower, addPower);
                transferPower(ForgeDirection.UP, tile, amountOfPower, addPower);
                transferPower(ForgeDirection.NORTH, tile, amountOfPower, addPower);
                transferPower(ForgeDirection.SOUTH, tile, amountOfPower, addPower);
                transferPower(ForgeDirection.WEST, tile, amountOfPower, addPower);
                transferPower(ForgeDirection.EAST, tile, amountOfPower, addPower);
            }
        }
    }

    public void transferPower(ForgeDirection direction, TileEntity tile, int amountOfPower, boolean addPower){

        int[] coords = TechCraftTile.translateDirectionToCoords(direction, this);

        if(worldObj.blockExists(coords[0], coords[1], coords[2])) {

            if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {

                IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                if(tileCallingMeathod.getPowerProvider() != null) {

                    if(addPower) {

                        if(tileCallingMeathod.getPowerProvider().canGainPower(amountOfPower) && tileToChange.getPowerProvider().canUsePower(amountOfPower))
                        {
                            if(tileCallingMeathod.getPowerProvider().outputPower() && tileToChange.getPowerProvider().recievePower()){

                                if(tileToChange.getPowerProvider().gainPower(amountOfPower, TechCraftTile.translateDirectionToOpposite(direction))) {

                                    tileCallingMeathod.getPowerProvider().usePower(amountOfPower, direction);
                                }
                            }
                        }        
                    }

                    else {

                        if(tileToChange.getPowerProvider().canUsePower(amountOfPower) && tileCallingMeathod.getPowerProvider().canGainPower(amountOfPower))
                        {
                            if(tileToChange.getPowerProvider().outputPower() && tileCallingMeathod.getPowerProvider().recievePower()){

                                if(tileCallingMeathod.getPowerProvider().gainPower(amountOfPower, direction)) {

                                    tileToChange.getPowerProvider().usePower(amountOfPower, TechCraftTile.translateDirectionToOpposite(direction));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPowerScaled(int scale) {

        int internal = (int)this.getPowerProvider().getPowerStored() * scale / (int)this.getPowerProvider().getPowerMax();
        if(internal > scale){
            internal = scale;
        }
        return internal;
    }    

    public int getAmountScaled(int scale, int amount, int max) {

        int internal = amount * scale / max;

        if(internal > scale) {

            internal = scale;
        }
        return internal;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Not Set";
    }

    @Override
    public int[] getPosition() {

        return new int[] {this.xCoord, this.yCoord, this.zCoord};
    }

    @Override
    public boolean renderByDirection(ForgeDirection direction) {

        switch(direction){
            case DOWN: return true;
            case EAST: return true;
            case NORTH: return true;
            case SOUTH: return true;
            case UP: return true;
            case WEST: return true;
            default: return true;
        }
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
            color = TechCraftTile.translateNumberToColor(tag.getInteger("Color"));
        
        if(this.getPowerProvider() != null)
            this.getPowerProvider().setPower(tag.getInteger("power"));
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag); 

        if(color != EnumColor.NONE)
            tag.setInteger("Color", TechCraftTile.translateColorToInt(this.getColorEnum()));

        if(this.getPowerProvider() != null)
            tag.setInteger("power", this.getPowerProvider().getPowerStored());
    }
}
