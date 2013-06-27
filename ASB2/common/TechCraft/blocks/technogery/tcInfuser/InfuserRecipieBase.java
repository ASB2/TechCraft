package TechCraft.blocks.technogery.tcInfuser;

import net.minecraft.item.ItemStack;

public class InfuserRecipieBase {

    ItemStack output;
    ItemStack[] input;
    int power;

    public InfuserRecipieBase(ItemStack output, ItemStack[] input, int power) {

        this.input = input;
        this.output = output;
        this.power = power;
    }

    public boolean isRecipeValid(ItemStack[] stack) {

        int equalStacks = 0;

        for(int i = 0; i < stack.length; i++) {

            if(stack[i] == null && input[i] == null) {
                
                equalStacks++;
                continue;
            }
            
            if(!(stack[i] == null && input[i] != null || stack[i] != null && input[i] == null)) {
                
                if(stack[i].isItemEqual(input[i]))
                    equalStacks++;
            }
        }
        return equalStacks == 9;
    }


    public int getPowerCost() {

        return power;
    }

    public ItemStack getOutput() {

        return this.output;
    }
}
