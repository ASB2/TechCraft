package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTestItem extends TechCraftItems {

    public ItemTestItem(int par1) {
        super(par1);

    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    int length = 5;

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(player.isSneaking()){

            if(world.isRemote)
                length = length - 1;

            if(!world.isRemote)
                player.sendChatToPlayer("Length = " + length);

            return itemStack;
        }        

        length++;

        if(!world.isRemote)
            player.sendChatToPlayer("Length = " + length);

        return itemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

        int power = 10;

        if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

            IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

            if(!player.isSneaking()){

                mTile.gainPower(power, TechCraftTile.translateNumberToDirection(side));
                player.sendChatToPlayer("Applied "+power+" Power");

            }
            else{   
                mTile.usePower(power, TechCraftTile.translateNumberToDirection(side));
                player.sendChatToPlayer("Drew "+power+" Power");
            }
        }
        else {
            ForgeDirection sideF = TechCraftTile.translateNumberToDirection(side);
            this.cycle2DBlock(player, world, sideF, x, y, z, 3, 5,world.getBlockId(x, y, z) );
        }

        return true;        
    }

    public void cycle2DBlock(EntityPlayer player, World world, ForgeDirection side, int x, int y, int z, int radius, int debth, int blockIdToBreak)
    {

        int blockToBreak = world.getBlockId(x, y, z);

        for(int r = 0; r < radius; r++) {

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
    }

    public void breakBlock(World world, EntityPlayer entity, int x, int y, int z, int blockToBreak) {

        if(world.blockExists(x, y, z)) {

            if(blockToBreak != Block.bedrock.blockID) { 

                if(world.getBlockTileEntity(x, y,  z) == null) {

                    if(world.getBlockId(x, y, z) == blockToBreak) {

                        int id = world.getBlockId(x, y, z);

                        if (id > 0) {

                            int meta = world.getBlockMetadata(x, y, z);

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
