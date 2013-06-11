package TechCraft.items;

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

    public boolean onItemUseFirst(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

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
            
            for(int i = 0; i < 5; i++){
                
                if(TechCraftTile.translateNumberToDirection(side) == ForgeDirection.UP) {
                    
                    world.setBlockToAir(x, y - i, z);
                }
            }
        }

        return true;        
    }
}
