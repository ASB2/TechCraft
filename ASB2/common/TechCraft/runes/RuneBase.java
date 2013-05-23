package TechCraft.runes;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneBase {

    ItemStack itemStack;
    
    public RuneBase(ItemStack item) {
        
        itemStack = item;
    }
    
    public void updateRune(){
        
    }
    
    public void onEntityEnterBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){ 
        
    }
    
    public String getName(){
        
        return "Not Set";
    }
}
