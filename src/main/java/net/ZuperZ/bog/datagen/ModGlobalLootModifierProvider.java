package net.ZuperZ.bog.datagen;

import net.ZuperZ.bog.Bog;
import net.ZuperZ.bog.item.ModItems;
import net.ZuperZ.bog.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Bog.MOD_ID);
    }

    @Override
    protected void start() {

        add("leaf_from_leaves", new AddItemModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.29f).build() }, ModItems.LEAF.get()));

        add("cranberries", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LEAVES).build(),
                LootItemRandomChanceCondition.randomChance(0.32f).build() }, ModItems.CRANBERRIES.get()));

    }
}
