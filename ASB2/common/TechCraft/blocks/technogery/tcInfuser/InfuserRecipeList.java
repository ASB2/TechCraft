package TechCraft.blocks.technogery.tcInfuser;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class InfuserRecipeList {

    private static final InfuserRecipeList instance = new InfuserRecipeList();

    public List<InfuserRecipieBase> recipes = new ArrayList <InfuserRecipieBase>();

    private InfuserRecipeList() {

        this.addRecipe(new InfuserRecipieBase(new ItemStack(Block.bedrock), new ItemStack[] {
            new ItemStack(Block.bedrock),new ItemStack(Block.bedrock),new ItemStack(Block.bedrock),
            new ItemStack(Block.bedrock),new ItemStack(Block.bedrock),new ItemStack(Block.bedrock),
            new ItemStack(Block.bedrock),new ItemStack(Block.bedrock),new ItemStack(Block.bedrock)}, 0));

    }

    public void addRecipe(InfuserRecipieBase recipe) {

        if(recipe != null) {

            recipes.add(recipe);
        }
    }

    public boolean isValidRecipe(ItemStack[] stack) {

        for(int i = 0; i < recipes.size(); i++) {

            if(recipes.get(i).isRecipeValid(stack)) {

                return true;
            }
        }
        return false;
    }

    public InfuserRecipieBase getRecipeClass(ItemStack[] stack) {

        for(int i = 0; i < recipes.size(); i++) {

            if(recipes.get(i).isRecipeValid(stack)) {

                return recipes.get(i);
            }
        }
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public List getRecipeList()
    {
        return recipes;
    }

    public static final InfuserRecipeList getInstance() {

        return instance;
    }


}
