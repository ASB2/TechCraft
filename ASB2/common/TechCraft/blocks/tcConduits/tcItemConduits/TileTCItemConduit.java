package TechCraft.blocks.tcConduits.tcItemConduits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.conduit.ConduitNetwork;
import TechCraft.conduit.EnumContuitType;
import TechCraft.conduit.IConduitConductor;
import TechCraft.conduit.IConduitInterfaceItem;

public class TileTCItemConduit extends TechCraftTile implements IConduitConductor {

    ConduitNetwork network;

    boolean circuitOnlyConnection = false;

    public void updateEntity() {
        ticks++;

        if(network == null) {

            network = new ConduitNetwork(worldObj, this, EnumContuitType.ITEM);
        }

        else {

            network.updateNetwork();

            if(ticks >= 20) {

                if(!circuitOnlyConnection) {

                    moveItemsToInventory(ForgeDirection.UP);
                    moveItemsToInventory(ForgeDirection.DOWN);
                    moveItemsToInventory(ForgeDirection.NORTH);
                    moveItemsToInventory(ForgeDirection.SOUTH);
                    moveItemsToInventory(ForgeDirection.WEST);
                    moveItemsToInventory(ForgeDirection.EAST);
                }
            }
        }

    }

    /**
     * If this conduit is facing a conduit network then it moves it's inventory to a item conduit in the network.
     */
    public void moveItemsToInventory(ForgeDirection direction) {

        TileEntity tileA = worldObj.getBlockTileEntity(TechCraftTile.translateDirectionToCoords(direction, this)[0], TechCraftTile.translateDirectionToCoords(direction, this)[1], TechCraftTile.translateDirectionToCoords(direction, this)[2]);

        if(this.getNetwork() != null) {

            if(tileA != null) {

                if(tileA instanceof IInventory && !(tileA instanceof ISidedInventory) && !(tileA instanceof IConduitInterfaceItem)) {

                    IInventory tileInventoryToChange = (IInventory)tileA;

                    if(this.getNetwork().getItemInterfaceSize() > 0) {

                        for(int b = 0; b < tileInventoryToChange.getSizeInventory(); b++) {

                            for(int i = 0; i < this.getNetwork().getItemInterfaceSize(); i++) {

                                TileEntity tileC = this.getNetwork().getItemInterface().get(i);

                                if(tileC != null) {

                                    if(tileC instanceof IInventory) {

                                        IInventory tileInventoryToTakeFromInNetwork = (IInventory) tileC;

                                        for(int c = 0; c < tileInventoryToTakeFromInNetwork.getSizeInventory() ; c++) {

                                            if(tileInventoryToTakeFromInNetwork.getStackInSlot(c) != null) {

                                                if(tileInventoryToChange.getStackInSlot(b) == null ) {

                                                    tileInventoryToChange.setInventorySlotContents(b, tileInventoryToTakeFromInNetwork.getStackInSlot(c));
                                                    tileInventoryToTakeFromInNetwork.setInventorySlotContents(c, null);
                                                }

                                                if(tileInventoryToChange.getStackInSlot(b).equals(tileInventoryToTakeFromInNetwork.getStackInSlot(c))) {

                                                    if(tileInventoryToChange.getStackInSlot(b).stackSize + tileInventoryToTakeFromInNetwork.getStackInSlot(c).stackSize  <= tileInventoryToChange.getInventoryStackLimit()) {

                                                        ItemStack stackI = tileInventoryToChange.getStackInSlot(b);

                                                        stackI.stackSize = tileInventoryToChange.getStackInSlot(b).stackSize + tileInventoryToTakeFromInNetwork.getStackInSlot(c).stackSize;

                                                        tileInventoryToChange.setInventorySlotContents(b, stackI);
                                                        tileInventoryToTakeFromInNetwork.setInventorySlotContents(c, null);
                                                    }

                                                    if(tileInventoryToChange.getStackInSlot(b).stackSize + 1  <= tileInventoryToChange.getInventoryStackLimit() && tileInventoryToTakeFromInNetwork.getStackInSlot(c).stackSize - 1 >= 0){

                                                        ItemStack stackB = tileInventoryToChange.getStackInSlot(b);
                                                        ItemStack stackCI = tileInventoryToTakeFromInNetwork.getStackInSlot(c);

                                                        stackB.stackSize = stackB.stackSize + 1;
                                                        stackCI.stackSize = stackCI.stackSize - 1;
                                                        tileInventoryToChange.setInventorySlotContents(b, stackB);
                                                        tileInventoryToTakeFromInNetwork.setInventorySlotContents(c, stackCI);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void triggerBlock(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z ) {

        if(circuitOnlyConnection == false){

            circuitOnlyConnection = true;
            return;
        }

        if(circuitOnlyConnection == true) {

            circuitOnlyConnection = false;
        }
    }

    @Override
    public String getName() {

        return "TC Item Conduit";
    }

    public ConduitNetwork getNetwork() {

        return network;
    }

    public void overrideNetwork(ConduitNetwork network) {

        this.network = network;
    }

    public boolean renderInterface(int side) {

        return true;
    }

    @Override
    public EnumContuitType getConductorType() {

        return EnumContuitType.ITEM;
    }

    @Override
    public boolean renderByDirection(ForgeDirection direction) {

        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        circuitOnlyConnection = tag.getBoolean("circuitOnlyConnection");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setBoolean("circuitOnlyConnection", circuitOnlyConnection);
    }
}