package net.ZuperZ.bog.worldgen;

import net.ZuperZ.bog.Bog;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_WALNUT = registerKey("add_tree_walnut");

    public static final ResourceKey<BiomeModifier> ADD_ALEXANDRITE_ORE = registerKey("add_alexandrite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ALEXANDRITE_ORE = registerKey("add_nether_alexandrite_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_ALEXANDRITE_ORE = registerKey("add_end_alexandrite_ore");

    public static final ResourceKey<BiomeModifier> ADD_SNAPDRAGON = registerKey("add_snapdragon");

    public static final ResourceKey<BiomeModifier> SPAWN_RHINO = registerKey("spawn_rhino");

    public static final ResourceKey<BiomeModifier> ADD_ALEXANDRITE_GEODE = registerKey("add_alexandrite_geode");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Bog.MOD_ID, name));
    }
}
