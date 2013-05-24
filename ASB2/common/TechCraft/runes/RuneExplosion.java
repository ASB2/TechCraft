package TechCraft.runes;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneExplosion extends RuneBase {

    public RuneExplosion(ItemStack item) {
        super(item);

    }

    public void onEntityEnterBlock(World par1World, int x, int y, int z, Entity par5Entity){ 

        par1World.createExplosion(par5Entity, x, y, z, 9, true);
    }

    public String getName(){

        return "Explosion Rune";
    }
}
