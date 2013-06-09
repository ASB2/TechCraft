package TechCraft.items.runes;

import net.minecraft.item.ItemStack;
import TechCraft.items.TechCraftItems;
import TechCraft.runes.IRuneItem;
import TechCraft.runes.RuneBase;
import TechCraft.runes.RuneTest;

public class ItemRuneTest extends TechCraftItems implements IRuneItem{

    public ItemRuneTest(int par1) {
        super(par1);
        
    }

    @Override
    public RuneBase getRune() {

        return new RuneTest(new ItemStack(this));
    }

}
