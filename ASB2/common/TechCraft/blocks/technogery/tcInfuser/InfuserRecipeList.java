package TechCraft.blocks.technogery.tcInfuser;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class InfuserRecipeList {

    InfuserRecipeList instance = new InfuserRecipeList();
    
    public static LinkedList<InfuserRecipieBase> recipes = new LinkedList<InfuserRecipieBase>();

    public static void addReciper(InfuserRecipieBase recipe) {
        
        recipes.add(recipe);
    }
    
    public static boolean isValidRecipe(ItemStack[] stack) {
        
        for(int i = 0; i < recipes.size(); i++) {
            
            if(recipes.get(i).isRecipeValid(stack)) {
                
               return true;
            }
        }
        return false;
    }
            
    @SuppressWarnings("rawtypes")
    public static List getRecipeList()
    {
        return InfuserRecipeList.recipes;
    }
    
    public InfuserRecipeList getInstance(){
        
        return instance;
    }
            
            
}
