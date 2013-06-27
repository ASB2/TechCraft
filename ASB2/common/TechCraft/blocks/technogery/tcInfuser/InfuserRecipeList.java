package TechCraft.blocks.technogery.tcInfuser;

import java.util.ArrayList;
import java.util.List;

import TechCraft.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipeList {

    private static final InfuserRecipeList instance = new InfuserRecipeList();

    public List<InfuserRecipieBase> recipes = new ArrayList <InfuserRecipieBase>();

    private InfuserRecipeList() {

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemCrystalCasing, 4), new ItemStack[] {
            null,new ItemStack(Block.glass),null,
            new ItemStack(Block.glass),new ItemStack(Item.redstone),new ItemStack(Block.glass),
            null, new ItemStack(Block.glass), null},
            20));
        
        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemAirCrystalShard), new ItemStack[] {
            new ItemStack(Block.glass),new ItemStack(Item.feather),new ItemStack(Block.glass),
            new ItemStack(Item.feather),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Item.feather),
            new ItemStack(Block.glass), new ItemStack(Item.feather), new ItemStack(Block.glass)},
            20));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemFireCrystalShard), new ItemStack[] {
            new ItemStack(Item.coal),new ItemStack(Item.blazeRod),new ItemStack(Item.coal),
            new ItemStack(Item.blazeRod),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Item.blazeRod),
            new ItemStack(Item.coal), new ItemStack(Item.blazeRod), new ItemStack(Item.coal)},
            20));
        
        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemEarthCrystalShard), new ItemStack[] {
            new ItemStack(Block.dirt),new ItemStack(Block.cobblestone),new ItemStack(Block.dirt),
            new ItemStack(Block.cobblestone),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Block.cobblestone),
            new ItemStack(Block.dirt), new ItemStack(Block.cobblestone), new ItemStack(Block.dirt)},
            20));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemWaterCrystalShard), new ItemStack[] {
            new ItemStack(Item.bucketWater),new ItemStack(Block.glass),new ItemStack(Item.bucketWater),
            new ItemStack(Block.glass),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Block.glass),
            new ItemStack(Item.bucketWater), new ItemStack(Block.glass), new ItemStack(Item.bucketWater)},
            20));
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
