package TechCraft.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.power.EnumPowerClass;
import TechCraft.power.IPowerMisc;

public class TechCraftTile extends TileEntity implements IPowerMisc {

    protected ForgeDirection orientation;

    public TechCraftTile() {

        orientation = ForgeDirection.DOWN;
    }

    public ForgeDirection getOrientation() {

        if(!(orientation == this.translateNumberToDirection(getBlockMetadata()))) {

            this.orientation = this.translateNumberToDirection(getBlockMetadata());
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

    public void toggleDirection() {

        switch(getOrientation()) {

            case DOWN: {
                this.setOrientation(ForgeDirection.UP);
                worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, TechCraftTile.translateDirectionToNumber(TechCraftTile.translateDirectionToOpposite(getOrientation())), 3);
                break;
            }

            case UP: {
                this.setOrientation(ForgeDirection.NORTH);
                break;
            }

            case NORTH: {
                this.setOrientation(ForgeDirection.SOUTH);
                break;
            }

            case SOUTH: {
                this.setOrientation(ForgeDirection.WEST);
                break;
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

    public ForgeDirection translateNumberToDirection(int direction) {

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

    public String translateDirectionToString() {

        switch(getOrientation()) {

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

    public void managePowerAll(TileEntity tile, int amountOfPower, boolean addPower) {

        if(TechCraftTile.getTilesNextTo(tile.xCoord, tile.yCoord, tile.zCoord, worldObj) > 0){
            amountOfPower = amountOfPower / TechCraftTile.getTilesNextTo(tile.xCoord, tile.yCoord, tile.zCoord, worldObj);
        }        

        transferPower(ForgeDirection.DOWN, tile, amountOfPower, addPower);
        transferPower(ForgeDirection.UP, tile, amountOfPower, addPower);
        transferPower(ForgeDirection.NORTH, tile, amountOfPower, addPower);
        transferPower(ForgeDirection.SOUTH, tile, amountOfPower, addPower);
        transferPower(ForgeDirection.WEST, tile, amountOfPower, addPower);
        transferPower(ForgeDirection.EAST, tile, amountOfPower, addPower);
    }

    public void transferPower(ForgeDirection direction, TileEntity tile, int amountOfPower, boolean addPower){

        int[] coords = TechCraftTile.translateDirectionToCoords(direction, this);

        if(worldObj.blockExists(coords[0], coords[1], coords[2])) {

            switch(direction) {

                case DOWN: {


                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {

                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }
                    break;
                }
                case UP: {

                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {

                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }    
                    break;
                }
                case NORTH: {

                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {

                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }
                    break;
                }
                case SOUTH: {

                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {

                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }
                    break;
                }
                case WEST: {

                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {

                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }
                    break;
                }
                case EAST: {
                    
                    if(worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]) instanceof IPowerMisc && tile instanceof IPowerMisc) {
                        IPowerMisc tileToChange = (IPowerMisc) worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
                        IPowerMisc tileCallingMeathod = (IPowerMisc) tile;

                        if(addPower) {

                            if(tileCallingMeathod.getPowerStored() >= amountOfPower && tileToChange.getPowerMax() - tileToChange.getPowerStored() >= amountOfPower){

                                if(tileCallingMeathod.outputPower() && tileToChange.recievePower()){

                                    tileToChange.gainPower(amountOfPower);
                                    tileCallingMeathod.usePower(amountOfPower);

                                }
                            }        
                        }

                        else {
                            if(tileToChange.getPowerStored() >= amountOfPower && tileCallingMeathod.getPowerMax() - tileCallingMeathod.getPowerStored() >= amountOfPower)
                            {
                                if(tileToChange.outputPower() && tileCallingMeathod.recievePower()){

                                    tileCallingMeathod.gainPower(amountOfPower);
                                    tileToChange.usePower(amountOfPower);

                                }
                            }
                        }
                    }
                }

                default:
                    break;
            }
        }
    }


    protected long ticks = 0;

    public void updateEntity() {

        ticks++;
        if(ticks == 20){
            updatePerSecond();
            ticks = 0;
        }

    }

    public void updatePerSecond(){

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
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord-1, tile.zCoord) instanceof IPowerMisc){
            numberNextTo++;
        }
        //top of Tile
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord+1, tile.zCoord) instanceof IPowerMisc){
            numberNextTo++;
        }        
        //left
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord-1) instanceof IPowerMisc){
            numberNextTo++;
        }
        //right
        if(worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord+1) instanceof IPowerMisc){
            numberNextTo++;
        }
        //front
        if(worldObj.getBlockTileEntity(tile.xCoord+1, tile.yCoord, tile.zCoord) instanceof IPowerMisc){
            numberNextTo++;
        }
        //back
        if(worldObj.getBlockTileEntity(tile.xCoord-1, tile.yCoord, tile.zCoord) instanceof IPowerMisc){
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

    public int getPowerScaled(int scale) {

        int internal = (int)this.getPowerStored() * scale / (int)getPowerMax();
        if(internal > scale){
            internal = scale;
        }
        return internal;
    }


    @Override
    public int getPowerStored() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPowerMax() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean recievePower() {

        return false;
    }

    @Override
    public boolean outputPower() {

        return false;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Not Set";
    }

    @Override
    public EnumPowerClass getPowerClass() {

        return EnumPowerClass.LOW;
    }

    @Override
    public boolean usePower(int PowerUsed) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean gainPower(int PowerGained) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int powerOutput() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int powerInput() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean requestingPower() {

        if(getPowerStored() < getPowerMax())
            return true;

        return false;
    }

    @Override
    public boolean outputtingPower() {

        if(getPowerStored() > 0)
            return true;

        return false;
    }

    @Override
    public boolean canGainPower(int power) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canUsePower(int power) {
        // TODO Auto-generated method stub
        return false;
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
            case UNKNOWN: return true;
            case UP: return true;
            case WEST: return true;
            default: return true;

        }
    }

}
