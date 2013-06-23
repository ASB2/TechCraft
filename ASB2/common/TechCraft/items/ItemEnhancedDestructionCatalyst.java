package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.utils.UtilDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnhancedDestructionCatalyst extends TechCraftItems {

    public ItemEnhancedDestructionCatalyst(int par1) {
        super(par1);
        this.setMaxDamage(300);
        this.setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!world.isRemote) {
            
            if(player.isSneaking()) {
                
                this.decrementLength(player);
                
                player.sendChatToPlayer("Debth of tunnel == " + this.getLength(itemStack));
                
                return itemStack;
                //player.openGui(TechCraft.instance, -1, world, (int)player.posX, (int)player.posY, (int)player.posZ);
            }

            this.incrementLength(player);
            player.sendChatToPlayer("Debth of tunnel == " + this.getLength(itemStack));
        }
        return itemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){


        ForgeDirection sideF = UtilDirection.translateNumberToDirection(side);
        this.cycle2DBlock(player, world, sideF, x, y, z, 3, this.getLength(par1ItemStack),world.getBlockId(x, y, z) );

        return true;        
    }

    public void cycle2DBlock(EntityPlayer player, World world, ForgeDirection side, int x, int y, int z, int radius, int debth, int blockIdToBreak)
    {

        int blockToBreak = world.getBlockId(x, y, z);

        for(int i = 0; i < debth; i++) {

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

    public void breakBlock(World world, EntityPlayer entity, int x, int y, int z, int blockToBreak) {

        if(world.blockExists(x, y, z)) {

            if(blockToBreak != Block.bedrock.blockID) { 

                if(world.getBlockTileEntity(x, y,  z) == null) {

                    if(world.getBlockId(x, y, z) == blockToBreak) {

                        int id = world.getBlockId(x, y, z);

                        if (id > 0) {

                            int meta = world.getBlockMetadata(x, y, z);

                            entity.inventory.getCurrentItem().damageItem(1, entity);
                            world.playAuxSFX(2001, x, y, z, id + (meta << 12));
                            Block.blocksList[id].dropBlockAsItem(world, (int)entity.posX, (int)entity.posY, (int)entity.posZ, meta, 0);
                            world.setBlockToAir(x, y, z);
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon("TechCraft:ItemContritioConsecteturCatalyst");
    }

    public int getLength(ItemStack item) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);

        if (nbtTagCompound != null) {

            return nbtTagCompound.getInteger("length");
        }        
        return 0;
    }

    public void setLenght(ItemStack item, int length) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setInteger("length", length);
    }

    public void decrementLength(EntityPlayer player) {

        if(player.inventory.getCurrentItem().getItem() instanceof ItemEnhancedDestructionCatalyst) {

            ItemEnhancedDestructionCatalyst item = (ItemEnhancedDestructionCatalyst)player.inventory.getCurrentItem().getItem();

            item.setLenght(player.inventory.getCurrentItem(), item.getLength(player.inventory.getCurrentItem()) - 1);
        }
    }

    public void incrementLength(EntityPlayer player) {

        if(player.inventory.getCurrentItem().getItem() instanceof ItemEnhancedDestructionCatalyst) {

            ItemEnhancedDestructionCatalyst item = (ItemEnhancedDestructionCatalyst)player.inventory.getCurrentItem().getItem();

            item.setLenght(player.inventory.getCurrentItem(), item.getLength(player.inventory.getCurrentItem()) + 1);
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        super.addInformation(itemStack, player, info, var1);
        info.add("Idea Source: EE2");
    }
}
