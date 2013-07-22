package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.utils.IBlockCycle;
import TechCraft.utils.UtilBlock;
import TechCraft.utils.UtilDirection;
import TechCraft.utils.UtilItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicDestructionCatalyst extends TechCraftItems implements IBlockCycle {

    public ItemBasicDestructionCatalyst(int par1) {
        super(par1);
        this.setMaxDamage(150);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon("TechCraft:ItemContritioSimplexCatalyst");
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        super.addInformation(itemStack, player, info, var1);
        info.add("Idea Source: EE2");
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        ForgeDirection sideF = UtilDirection.translateNumberToDirection(side);
        
        UtilItemStack.setNBTTagInt(itemStack, "id", world.getBlockId(x, y, z));        
        UtilBlock.cycle2DBlock(player, world, x, y, z, sideF, 1, this, 0); 
        
        return true;        
    }

    @Override
    public boolean execute(EntityPlayer player, World world, int x, int y, int z, ForgeDirection side, int mid) {
      
        int blockToBreak = UtilItemStack.getNBTTagInt(player.inventory.getCurrentItem(), "id");
        
        if(world.blockExists(x, y, z)) {

            if(blockToBreak != Block.bedrock.blockID) { 

                if(world.getBlockTileEntity(x, y,  z) == null) {

                    if(world.getBlockId(x, y, z) == blockToBreak) {

                        int id = world.getBlockId(x, y, z);

                        if (id > 0) {

                            int meta = world.getBlockMetadata(x, y, z);

                            player.inventory.getCurrentItem().damageItem(1, player);

                            world.playAuxSFX(2001, x, y, z, id + (meta << 12));
                            Block.blocksList[id].dropBlockAsItem(world, (int)player.posX, (int)player.posY, (int)player.posZ, meta, 0);
                            world.setBlockToAir(x, y, z);
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
