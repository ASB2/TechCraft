package TechCraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemOmniTool extends TechCraftItems {

    protected EnumToolMaterial toolMaterial;
    public int damageVsEntity = 100;
    public float efficiencyOnProperMaterial = 14.0F;

    public ItemOmniTool(int par1) {
        super(par1);

        this.setMaxDamage(200);
        this.setMaxStackSize(1);
    }

    public boolean canHarvestBlock(Block par1Block)
    {
        return true;
    }

    /** an array of the blocks this spade is effective against */

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {

        return efficiencyOnProperMaterial;
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {

        par1ItemStack.damageItem(0, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(1, par7EntityLiving);
        }

        return true;
    }

    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta)  {

        return efficiencyOnProperMaterial;
    }
}
