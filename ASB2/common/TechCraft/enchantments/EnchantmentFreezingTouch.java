package TechCraft.enchantments;

import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentFreezingTouch extends TechCraftEnchantmentBase {

    protected EnchantmentFreezingTouch(int par1, int par2, EnumEnchantmentType par3EnumEnchantmentType) {
        
        super(par1, par2, EnumEnchantmentType.all);
        this.setName("fire");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }
    
    public int getMaxLevel()
    {
        return 5;
    }
}
