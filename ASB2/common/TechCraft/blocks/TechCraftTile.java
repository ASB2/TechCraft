package TechCraft.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;
import TechCraft.power.EnumPowerClass;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerNetwork;

public class TechCraftTile extends TileEntity implements IPowerMisc {

    protected ForgeDirection orientation;
    protected PowerNetwork network;

    public TechCraftTile() {

        network = new PowerNetwork(worldObj, this);

        orientation = ForgeDirection.DOWN;
    }

    public ForgeDirection getOrientation() {

        if(!(orientation == this.translateNumberToDirection(getBlockMetadata()))) {

            this.orientation = this.translateNumberToDirection(getBlockMetadata());
        }

        return this.orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int id) {

        this.orientation = ForgeDirection.getOrientation(id);
    }

    public void toggleDirection(){

        switch(getOrientation()) {

            case DOWN: {
                this.setOrientation(ForgeDirection.UP);
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

            default: this.setOrientation(ForgeDirection.DOWN);
            break;

        }
    }

    public int[] translateDirectionToCoords(ForgeDirection direction) {

        switch(direction) {

            case DOWN: {
                return new int[]{this.xCoord,this.yCoord-1,this.zCoord};
            }
            case UP: {
                return new int[]{this.xCoord,this.yCoord+1,this.zCoord};
            }
            case NORTH: {
                return new int[]{this.xCoord,this.yCoord,this.zCoord-1};
            }
            case SOUTH: {
                return new int[]{this.xCoord,this.yCoord,this.zCoord+1};
            }
            case WEST: {
                return new int[]{this.xCoord-1,this.yCoord,this.zCoord};
            }
            case EAST: {
                return new int[]{this.xCoord+1,this.yCoord,this.zCoord};
            }
            case UNKNOWN:{
                return new int[]{this.xCoord,this.yCoord,this.zCoord};
            }
        }

        return new int[]{this.xCoord,this.yCoord,this.zCoord};
    }

    public int translateDirectionToNumber() {

        int var1 = -1;

        switch(getOrientation()) {

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

        switch(direction) {

            case DOWN: {
                int[] coords = this.translateDirectionToCoords(direction);

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
                int[] coords = this.translateDirectionToCoords(direction);

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
                int[] coords = this.translateDirectionToCoords(direction);

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
                int[] coords = this.translateDirectionToCoords(direction);

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
                int[] coords = this.translateDirectionToCoords(direction);

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
                int[] coords = this.translateDirectionToCoords(direction);

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

    public void addConductorsAround(){
        addConductorsAround(ForgeDirection.DOWN);
        addConductorsAround(ForgeDirection.UP);
        addConductorsAround(ForgeDirection.NORTH);
        addConductorsAround(ForgeDirection.SOUTH);
        addConductorsAround(ForgeDirection.WEST);
        addConductorsAround(ForgeDirection.EAST);
    }

    public void addConductorsAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(this.translateDirectionToCoords(direction)[0], this.translateDirectionToCoords(direction)[1], this.translateDirectionToCoords(direction)[2]);

        if(tile != null && network != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;

                }
                case UP: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof TileMagicConduitMoving) {

                        if(((TileMagicConduitMoving) tile).getNetwork() != null) {

                            if(((TileMagicConduitMoving)tile).network.getAge() < this.network.getAge()) {

                                ((TileMagicConduitMoving)tile).overrideNetwork(network);
                                network.addConductor((TileMagicConduitMoving) tile);
                            }
                        }
                        else {

                            ((TileMagicConduitMoving)tile).overrideNetwork(network);
                            network.addConductor((TileMagicConduitMoving) tile);
                        }
                    }
                    break;
                }
                case UNKNOWN:
                    break;

                default:
                    break;
            }
        }
    }

    public void addSourceAround(){
        addSourceAround(ForgeDirection.DOWN);
        addSourceAround(ForgeDirection.UP);
        addSourceAround(ForgeDirection.NORTH);
        addSourceAround(ForgeDirection.SOUTH);
        addSourceAround(ForgeDirection.WEST);
        addSourceAround(ForgeDirection.EAST);
    }

    public void addSourceAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(this.translateDirectionToCoords(direction)[0], this.translateDirectionToCoords(direction)[1], this.translateDirectionToCoords(direction)[2]);

        if(tile != null && network != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }         
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).outputPower()) {

                                ((IPowerMisc)tile).overrideNetwork(network);
                                network.addSource((IPowerMisc) tile);
                            }
                        }


                    }
                    break;
                }
                case UNKNOWN:
                    break;

                default:
                    break;
            }
        }
    }

    public void addSinkAround(){
        addSinkAround(ForgeDirection.DOWN);
        addSinkAround(ForgeDirection.UP);
        addSinkAround(ForgeDirection.NORTH);
        addSinkAround(ForgeDirection.SOUTH);
        addSinkAround(ForgeDirection.WEST);
        addSinkAround(ForgeDirection.EAST);
    }

    public void addSinkAround(ForgeDirection direction){

        TileEntity tile = worldObj.getBlockTileEntity(this.translateDirectionToCoords(direction)[0], this.translateDirectionToCoords(direction)[1], this.translateDirectionToCoords(direction)[2]);

        if(tile != null && network != null) {

            switch(direction) {

                case DOWN: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }

                case EAST:{

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case NORTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case SOUTH: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;

                }
                case UP: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case WEST: {

                    if(tile instanceof IPowerMisc) {

                        if(((IPowerMisc)tile).getNetwork() == null) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                        else if(((IPowerMisc)tile).getNetwork().getAge() < this.getNetwork().getAge()) {

                            if(((IPowerMisc)tile).recievePower()) {

                                ((IPowerMisc)tile).overrideNetwork(getNetwork());
                                this.getNetwork().addSink((IPowerMisc) tile);
                            }
                        }

                    }
                    break;
                }
                case UNKNOWN:
                    break;

                default:
                    break;
            }
        }
    }

    protected long ticks = 0;
    public void updateEntity(){

        if(network != null)
            network.updateNetwork();

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
    public PowerNetwork getNetwork() {

        return network;
    }

    @Override
    public void overrideNetwork(PowerNetwork network) {

        this.network = network;
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

}
