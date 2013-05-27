package TechCraft.runes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneExplosion extends RuneBase {

    public RuneExplosion(ItemStack item) {
        super(item);

    }

    public void onEntityEnterBlock(World par1World, int x, int y, int z, Entity entity){ 

        if(entity instanceof EntityLiving) {
            
            par1World.createExplosion(entity, x, y, z, 9, true);
        }
    }

    public String getName(){

        return "Explosion Rune";
    }
}
