package TechCraft.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public abstract class TechCraftEnchantmentBase extends Enchantment {

    protected TechCraftEnchantmentBase(int par1, int par2, EnumEnchantmentType par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }

    public static Enchantment freezingTouch;
}
