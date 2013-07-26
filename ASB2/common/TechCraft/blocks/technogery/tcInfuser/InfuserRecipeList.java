package TechCraft.blocks.technogery.tcInfuser;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TechCraft.BlockRegistry;
import TechCraft.ItemRegistry;

public class InfuserRecipeList {

    private static final InfuserRecipeList instance = new InfuserRecipeList();
    private final static int standardPowerCost = 20;

    public List<InfuserRecipieBase> recipes = new ArrayList <InfuserRecipieBase>();

    private InfuserRecipeList() {

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemCrystalCasing, 4), new ItemStack[] {
            null,new ItemStack(Block.glass),null,
            new ItemStack(Block.glass),new ItemStack(Item.redstone),new ItemStack(Block.glass),
            null, new ItemStack(Block.glass), null},
            standardPowerCost));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemAirCrystalShard), new ItemStack[] {
            new ItemStack(Block.glass),new ItemStack(Item.feather),new ItemStack(Block.glass),
            new ItemStack(Item.feather),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Item.feather),
            new ItemStack(Block.glass), new ItemStack(Item.feather), new ItemStack(Block.glass)},
            standardPowerCost));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemFireCrystalShard), new ItemStack[] {
            new ItemStack(Item.coal),new ItemStack(Item.blazeRod),new ItemStack(Item.coal),
            new ItemStack(Item.blazeRod),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Item.blazeRod),
            new ItemStack(Item.coal), new ItemStack(Item.blazeRod), new ItemStack(Item.coal)},
            standardPowerCost));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemEarthCrystalShard), new ItemStack[] {
            new ItemStack(Block.dirt),new ItemStack(Block.cobblestone),new ItemStack(Block.dirt),
            new ItemStack(Block.cobblestone),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Block.cobblestone),
            new ItemStack(Block.dirt), new ItemStack(Block.cobblestone), new ItemStack(Block.dirt)},
            standardPowerCost));

        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemWaterCrystalShard), new ItemStack[] {
            new ItemStack(Item.bucketWater),new ItemStack(Block.glass),new ItemStack(Item.bucketWater),
            new ItemStack(Block.glass),new ItemStack(ItemRegistry.ItemCrystalCasing),new ItemStack(Block.glass),
            new ItemStack(Item.bucketWater), new ItemStack(Block.glass), new ItemStack(Item.bucketWater)},
            standardPowerCost));
        
        this.addRecipe(new InfuserRecipieBase(new ItemStack(ItemRegistry.ItemTradeStick), new ItemStack[] {
            new ItemStack(Item.diamond),new ItemStack(Item.emerald),new ItemStack(Item.emerald),
            null,new ItemStack(Item.stick),new ItemStack(Item.emerald),
            new ItemStack(Item.stick), null, new ItemStack(Item.diamond)},
            standardPowerCost));
        
        this.addRecipe(new InfuserRecipieBase(new ItemStack(BlockRegistry.BlockTCEnergySphere,4), new ItemStack[] {
            new ItemStack(ItemRegistry.ItemEnergyCrystalShard),new ItemStack(Block.glass),new ItemStack(ItemRegistry.ItemEnergyCrystalShard),
            new ItemStack(Block.glass),new ItemStack(Item.diamond),new ItemStack(Block.glass),
            new ItemStack(ItemRegistry.ItemEnergyCrystalShard), new ItemStack(Block.glass), new ItemStack(ItemRegistry.ItemEnergyCrystalShard)},
            standardPowerCost));
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
