package net.ZuperZ.bog.worldgen.biome;

import net.ZuperZ.bog.Bog;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;



public class ModBiomes {
    public static final ResourceKey<Biome> BOG_WETLANDS = register("bog_wetlands");
    public static final ResourceKey<Biome> SUPERIOR_LAKES = register("superior_lakes");
    public static final ResourceKey<Biome> SLIME_PLAINS = register("slime_plains");
    public static final ResourceKey<Biome> ERODED_VALLEYS = register("eroded_valleys");
    public static final ResourceKey<Biome> WARPED_CAVERNS = register("warped_caverns");

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(BOG_WETLANDS, bog_wetlands(context));
        //context.register(SUPERIOR_LAKES, superiorlakes(context));
        //context.register(SLIME_PLAINS, slimeplains(context));
        //context.register(ERODED_VALLEYS, erodedvalleys(context));
        //context.register(WARPED_CAVERNS, warpedcaverns(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome bog_wetlands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 3, 1, 3));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.9f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x694118)
                        .waterFogColor(0x694118)
                        .skyColor(0x482b0e)
                        .grassColorOverride(0x482b0e)
                        .foliageColorOverride(0x482b0e)
                        .fogColor(0x482b0e)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.GAME).build())
                .build();
    }
    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Bog.MOD_ID, name));
    }
}