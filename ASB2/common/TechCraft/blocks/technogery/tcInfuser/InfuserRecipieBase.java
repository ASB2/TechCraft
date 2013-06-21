package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.item.ItemStack;

public class InfuserRecipieBase {

    ItemStack output;
    ItemStack[] input;
    int power;

    public InfuserRecipieBase(ItemStack output, ItemStack[] input, int power){

        this.output = output;
        this.input = input;
        this.power = power;
    }

    public boolean isRecipeValid(ItemStack[] stack) {

        if(stack == input) {   

            return true;
        }
        return false;
    }
}
