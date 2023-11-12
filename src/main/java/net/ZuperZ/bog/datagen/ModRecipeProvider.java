
package net.ZuperZ.bog.datagen;

import net.ZuperZ.bog.block.ModBlocks;
import net.ZuperZ.bog.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALAD.get(), 1)
                .requires(ModItems.CRANBERRIES.get())
                .requires(ModItems.SALAD.get())
                .unlockedBy("has_cranberies_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CRANBERRIES.get()).build()))
                .save(pWriter);
    }

}