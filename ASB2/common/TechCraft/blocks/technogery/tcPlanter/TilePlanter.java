package TechCraft.blocks.technogery.tcPlanter;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import TechCraft.BlockRegistry;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import TechCraft.power.PowerClass;
import TechCraft.power.State;
import TechCraft.power.TCPowerProvider;
import TechCraft.utils.IBlockCycle;
import TechCraft.utils.UtilBlock;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilInventory;

public class TilePlanter extends TechCraftTile implements IPowerMisc, IInventory, IBlockCycle {

    int powerForTill = 10;
    int powerForPlant = 20;
    int powerForHarvest = 10;

    int farmSize = 10;
    ItemStack[] tileItemStacks;

    public TilePlanter() {        

        this.powerProvider = new TCPowerProvider(this, 1000, PowerClass.LOW, State.SINK);
        tileItemStacks = new ItemStack[10];
    }

    public void updateEntity() {

        if(this.getPowerProvider().getShouldWork() && this.getPowerProvider().getPowerStored() > 0) {

            if(TechCraft.testingMode) {

                this.getPowerProvider().setPower(this.getPowerProvider().getPowerMax());
                //Tills the earth
                UtilBlock.cycle2DBlock(null, worldObj, xCoord, yCoord, zCoord, ForgeDirection.DOWN, farmSize, this, 0);

                //Plants stuff
                UtilBlock.cycle2DBlock(null, worldObj, xCoord, yCoord + 1, zCoord, ForgeDirection.DOWN, farmSize, this, 1);

                //Fertilizes stuff
                UtilBlock.cycle2DBlock(null, worldObj, xCoord, yCoord + 1, zCoord, ForgeDirection.DOWN, farmSize, this, 2);

                //Breaks stuff
                UtilBlock.cycle2DBlock(null, worldObj, xCoord, yCoord + 1, zCoord, ForgeDirection.DOWN, farmSize, this, 3);
            }
        }

        this.moveToAdjacentInventories(ForgeDirection.DOWN);
        this.moveToAdjacentInventories(ForgeDirection.UP);

        this.moveToAdjacentInventories(ForgeDirection.NORTH);
        this.moveToAdjacentInventories(ForgeDirection.SOUTH);

        this.moveToAdjacentInventories(ForgeDirection.WEST);
        this.moveToAdjacentInventories(ForgeDirection.EAST);
    }

    public void moveToAdjacentInventories(ForgeDirection direction) {

        TileEntity tileInventory = UtilDirection.translateDirectionToTile(this, worldObj, direction);

        if(tileInventory != null) {

            if(tileInventory instanceof ISidedInventory) { 
                
                for(int i = 0; i < this.getSizeInventory(); i++) {

                    if(i != 9) {

                        for(int z = 0; z < ((ISidedInventory)tileInventory).getSizeInventory(); z++) {

                            UtilInventory.moveToAllISidedSlots(this, UtilDirection.translateDirectionToNumber(UtilDirection.translateDirectionToOpposite(direction)), (ISidedInventory)tileInventory);
                        }
                    }
                }
            }
            
            if(tileInventory instanceof IInventory) { 

                for(int i = 0; i < this.getSizeInventory(); i++) {

                    if(i != 9) {

                        for(int z = 0; z < ((IInventory)tileInventory).getSizeInventory(); z++) {

                            UtilInventory.moveIInventorySlot(this, i, (IInventory)tileInventory, z);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side, int id) {

        if(id == 0) {

            if(this.getPowerProvider().canUsePower(powerForTill)) {

                int currentBlockId = world.getBlockId(x, y, z);
                int currentBlockMetadata = world.getBlockMetadata(x, y, z);

                if(currentBlockId != BlockRegistry.BlockPlanter.blockID) {

                    if(currentBlockId == Block.grass.blockID || currentBlockId == Block.dirt.blockID || (currentBlockId == Block.tilledField.blockID && currentBlockMetadata != 1)) {

                        if(this.getPowerProvider().usePower(powerForTill, ForgeDirection.UNKNOWN)) {

                            world.setBlock(x, y, z, Block.tilledField.blockID);
                            world.setBlockMetadataWithNotify(x,y,z,1,3);
                        }
                        return true;
                    }
                }
            }
        }

        if(id == 1) {

            if(this.getPowerProvider().canUsePower(powerForPlant)) {

                for(int i = 0; i < this.getSizeInventory(); i++) {

                    ItemStack stackInSlot = this.getStackInSlot(i);

                    if(stackInSlot != null) {

                        Item item = stackInSlot.getItem();

                        if(item instanceof IPlantable) {

                            if(((IPlantable)item).getPlantType(world, x, y, z) == EnumPlantType.Crop && world.getBlockId(x,y - 1,z) == Block.tilledField.blockID) {

                                if(UtilInventory.decreaseSlotContents(this, i, 1)) {

                                    if(this.getPowerProvider().usePower(powerForPlant, ForgeDirection.UNKNOWN)) {

                                        UtilBlock.placeBlockInAir(worldObj, x, y, z, ((IPlantable)item).getPlantID(world, x, y, z), 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }            
        }


        if(id == 2) {

            if(Block.blocksList[world.getBlockId(x,y,z)] != null) {

                Block.blocksList[world.getBlockId(x,y,z)].updateTick(worldObj, x, y, z, new Random());
            }
        }

        if(id == 3) {

            if(this.getPowerProvider().canUsePower(powerForHarvest)) {

                int blockId = world.getBlockId(x,y,z);

                if(blockId == Block.crops.blockID && world.getBlockMetadata(x,y,z) > 3) { 

                    if(this.getPowerProvider().usePower(powerForHarvest, ForgeDirection.UNKNOWN)) {

                        UtilInventory.addItemStackToInventory(this, new ItemStack(Item.seeds,2,0));
                        UtilInventory.addItemStackToInventory(this, new ItemStack(Item.wheat,2,0));
                    }
                }

                if(Block.blocksList[blockId] instanceof BlockCrops) {


                }
            }
        }
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {        
        super.readFromNBT(nbtTagCompound);

        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items");
        tileItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < tileItemStacks.length)
            {
                tileItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < tileItemStacks.length; i++)
        {
            if (tileItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                tileItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbtTagCompound.setTag("Items", nbttaglist);
    }

    @Override
    public String getName() {

        return "TC Planter";
    }

    @Override
    public int getSizeInventory() {

        return tileItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return tileItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            }

            else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {

        ItemStack itemStack = getStackInSlot(slot);

        if (itemStack != null) {
            setInventorySlotContents(slot, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        tileItemStacks[slot] = itemStack;
    }

    @Override
    public String getInvName() {

        return getName();
    }

    @Override
    public boolean isInvNameLocalized() {

        return true;
    }

    @Override
    public int getInventoryStackLimit() {

        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void openChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return true;
    }
}
