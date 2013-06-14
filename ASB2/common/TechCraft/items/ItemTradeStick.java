package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTradeStick extends TechCraftItems {

    public ItemTradeStick(int par1) {
        super(par1);
        this.setMaxDamage(150);
    }

    int length = 1;

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon("TechCraft:ItemTradeStick");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        super.addInformation(itemStack, player, info, var1);
        info.add("Idea Source: Thaumcraft 3");
    }
    
    public void setBlockID(ItemStack item, int id) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setInteger("id", id);
    }

    public int getBlockID(ItemStack item) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);

        if (nbtTagCompound != null) {

            return nbtTagCompound.getInteger("id");
        }
        return 0;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        if(player.isSneaking()) {
            player.sendChatToPlayer("Block ID set to: " + world.getBlockId(x,y,z));
            this.setBlockID(itemStack, world.getBlockId(x,y,z));
            return true;
        }

        else {

            if(this.getBlockID(itemStack) > 0) {
                
                //this.cycle2DBlock(player, world, sideF, x, y, z, 1, 1, this.getBlockID(itemStack));            
                this.breakBlock(world, player, x, y, z, this.getBlockID(itemStack));
            }
        }
        return true;        
    }

    public void cycle2DBlock(EntityPlayer player, World world, ForgeDirection side, int x, int y, int z, int radius, int debth, int blockIdToBreak)
    {

        int blockToBreak = world.getBlockId(x, y, z);

        for(int i = 0; i < length; i++) {

            if(side == ForgeDirection.UP) {

                int coordChanged = y - i;

                this.breakBlock(world,player, x, coordChanged, z, blockToBreak);

                this.breakBlock(world,player,x + 1 , coordChanged, z, blockToBreak);
                this.breakBlock(world, player,x + 1, coordChanged, z - 1, blockToBreak);
                this.breakBlock(world,player,x + 1,coordChanged, z + 1, blockToBreak);

                this.breakBlock(world,player,x, coordChanged, z + 1, blockToBreak);

                this.breakBlock(world,player,x - 1, coordChanged, z + 1, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z - 1, blockToBreak);

                this.breakBlock(world,player,x, coordChanged, z - 1, blockToBreak);
            }

            if(side == ForgeDirection.DOWN) {

                int coordChanged = y + i;

                this.breakBlock(world, player,x, coordChanged, z, blockToBreak);

                this.breakBlock(world,player,x + 1, coordChanged, z, blockToBreak);
                this.breakBlock(world,player, x + 1, coordChanged, z + 1, blockToBreak);
                this.breakBlock(world,player, x + 1, coordChanged, z - 1, blockToBreak);

                this.breakBlock(world,player,x, coordChanged, z + 1, blockToBreak);
                this.breakBlock(world,player,x + 1,coordChanged, z + 1, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z + 1, blockToBreak);

                this.breakBlock(world,player,x - 1, coordChanged, z, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z - 1, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z + 1, blockToBreak);

                this.breakBlock(world,player,x, coordChanged, z - 1, blockToBreak);
                this.breakBlock(world,player,x + 1, coordChanged, z - 1, blockToBreak);
                this.breakBlock(world,player,x - 1, coordChanged, z - 1, blockToBreak);
            }

            if(side == ForgeDirection.NORTH) {

                int coordChanged = z + i;

                this.breakBlock(world,player, x, y, coordChanged, blockToBreak);

                this.breakBlock(world,player, x + 1, y, coordChanged, blockToBreak);
                this.breakBlock(world,player, x + 1, y - 1, coordChanged, blockToBreak);
                this.breakBlock(world,player, x + 1, y + 1, coordChanged, blockToBreak);

                this.breakBlock(world,player,x - 1, y , coordChanged, blockToBreak);
                this.breakBlock(world,player,x - 1, y - 1, coordChanged, blockToBreak);
                this.breakBlock(world,player,x - 1, y + 1, coordChanged, blockToBreak);

                this.breakBlock(world,player,x, y + 1, coordChanged, blockToBreak);
                this.breakBlock(world,player,x, y - 1, coordChanged, blockToBreak);
            }

            if(side == ForgeDirection.SOUTH) {

                int coordChanged = z - i;

                this.breakBlock(world,player,x, y, coordChanged, blockToBreak);

                this.breakBlock(world,player,x + 1, y, coordChanged, blockToBreak);
                this.breakBlock(world,player,x + 1, y - 1, coordChanged, blockToBreak);
                this.breakBlock(world,player,x + 1, y + 1, coordChanged, blockToBreak);

                this.breakBlock(world,player,x - 1, y , coordChanged, blockToBreak);
                this.breakBlock(world,player,x - 1, y - 1, coordChanged, blockToBreak);
                this.breakBlock(world,player,x - 1, y + 1, coordChanged, blockToBreak);

                this.breakBlock(world,player,x, y + 1, coordChanged, blockToBreak);
                this.breakBlock(world,player,x, y - 1, coordChanged, blockToBreak);
            }

            if(side == ForgeDirection.WEST) {

                int coordChanged = x - i;

                this.breakBlock(world,player, coordChanged, y, z, blockToBreak);

                this.breakBlock(world,player, coordChanged, y + 1, z, blockToBreak);
                this.breakBlock(world,player, coordChanged, y + 1, z - 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y + 1, z + 1, blockToBreak);

                this.breakBlock(world,player, coordChanged, y - 1, z, blockToBreak);
                this.breakBlock(world,player, coordChanged, y - 1, z - 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y - 1, z + 1, blockToBreak);

                this.breakBlock(world,player, coordChanged, y, z + 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y, z - 1, blockToBreak);
            }

            if(side == ForgeDirection.EAST) {

                int coordChanged = x + i;

                this.breakBlock(world,player, coordChanged, y, z, blockToBreak);

                this.breakBlock(world,player, coordChanged, y + 1, z, blockToBreak);
                this.breakBlock(world,player, coordChanged, y + 1, z - 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y + 1, z + 1, blockToBreak);

                this.breakBlock(world,player, coordChanged, y - 1, z, blockToBreak);
                this.breakBlock(world,player, coordChanged, y - 1, z - 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y - 1, z + 1, blockToBreak);

                this.breakBlock(world,player, coordChanged, y, z + 1, blockToBreak);
                this.breakBlock(world,player, coordChanged, y, z - 1, blockToBreak);
            }
        }
    }

    public void breakBlock(World world, EntityPlayer player, int x, int y, int z, int blockToBreak) {

        if(world.blockExists(x, y, z)) {

            if(blockToBreak != Block.bedrock.blockID) { 

                if(world.getBlockTileEntity(x, y,  z) == null) {

                    if(world.getBlockId(x, y, z) != blockToBreak) {

                        int id = world.getBlockId(x, y, z);

                        int meta = world.getBlockMetadata(x, y, z);

                        for(int i = 0; i < player.inventory.getSizeInventory(); i++) {

                            if(player.inventory.getStackInSlot(i) != null) {

                                ItemStack stack = player.inventory.getStackInSlot(i);

                                if(stack.getItem() instanceof ItemBlock) {

                                    if(stack.itemID == blockToBreak) {

                                        if(player.capabilities.isCreativeMode == false) {

                                            if(world.isRemote) {

                                                if(stack.stackSize > 1) {

                                                    stack.stackSize = stack.stackSize - 1;
                                                    player.inventory.setInventorySlotContents(i, stack);
                                                }
                                                else {

                                                    player.inventory.setInventorySlotContents(i, null);
                                                }
                                            }
                                        }

                                        //player.sendChatToPlayer("Block equation has completed");

                                        player.inventory.getCurrentItem().damageItem(1, player);
                                        world.playAuxSFX(2001, x, y, z, id + (meta << 12));

                                        Block.blocksList[id].dropBlockAsItem(world, (int)player.posX, (int)player.posY, (int)player.posZ, meta, 0);
                                        world.setBlockToAir(x, y, z);
                                        world.setBlock(x, y, z, blockToBreak); 
                                        //break;
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
