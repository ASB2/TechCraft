package TechCraft.blocks.tcPersonalBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class PersonalBlockPlacer extends ItemBlock {

    public PersonalBlockPlacer(int par1) {
        super(par1);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int damageValue) {
        
        return damageValue;
    }
    
    public String getUnlocalizedName(ItemStack itemstack) {
        
        switch(itemstack.getItemDamage()) {
            
            case 0: return "Personal Glass";
            case 1: return "Personal Stone";
            
        default: return "Unknown Metadata Notify ASB2";
        }
    }
}
