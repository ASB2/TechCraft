package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicDestructionCatalyst extends TechCraftItems {

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

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        ForgeDirection sideF = TechCraftTile.translateNumberToDirection(side);            
        this.cycle2DBlock(player, world, sideF, x, y, z, 3, 1, world.getBlockId(x, y, z));        
        return true;        
    }

    public void cycle2DBlock(EntityPlayer player, World world, ForgeDirection side, int x, int y, int z, int diameter, int debth, int blockIdToBreak)
    {

        int blockToBreak = world.getBlockId(x, y, z);

        for(int d = 0; d < diameter; d++) {
            
            for (int c = 0; c < diameter; c++) {
                
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
                        this.breakBlock(world,player, x + 1, coordChanged, z - 1, blockToBreak);
                        this.breakBlock(world,player,x, coordChanged, z + 1, blockToBreak);

                        this.breakBlock(world,player,x + 1,coordChanged, z + 1, blockToBreak);
                        this.breakBlock(world,player,x - 1, coordChanged, z, blockToBreak);
                        this.breakBlock(world,player,x - 1, coordChanged, z - 1, blockToBreak);

                        this.breakBlock(world,player,x - 1, coordChanged, z + 1, blockToBreak);
                        this.breakBlock(world,player,x, coordChanged, z - 1, blockToBreak);
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
}
