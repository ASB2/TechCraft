package TechCraft.runes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneTest extends RuneBase {

    public RuneTest(ItemStack itemStack) {
        super(itemStack);
        
    }

    public void onEntityEnterBlock(World par1World, int x, int y, int z, Entity par5Entity){ 
        
        if(par5Entity instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer)par5Entity;
            player.sendChatToPlayer("It is getting called");
        }
        par1World.createExplosion(par5Entity, x, y, z, 9, true);
    }
    
    public String getName(){

        return "Test Rune";
    }

}
