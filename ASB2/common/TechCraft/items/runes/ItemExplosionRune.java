package TechCraft.items.runes;

import net.minecraft.item.ItemStack;
import TechCraft.interfaces.runes.IRuneItem;
import TechCraft.items.TechCraftItems;
import TechCraft.runes.RuneBase;
import TechCraft.runes.RuneExplosion;

public class ItemExplosionRune extends TechCraftItems implements IRuneItem{

    public ItemExplosionRune(int par1) {
        super(par1);
    }

    @Override
    public RuneBase getRune() {

        return new RuneExplosion(new ItemStack(this));
    }

}
