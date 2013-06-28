package TechCraft.blocks.tcPersonalBlocks;

import TechCraft.TehCraftItemBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PersonalBlockPlacer extends TehCraftItemBlock {

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) {
       super.addInformation(itemStack, player, info, var1);
        info.add("Source: Thaumcraft.");
        info.add("Can't be blown up.");
        info.add("Only breakable by the person who placed it.");
    }
}
