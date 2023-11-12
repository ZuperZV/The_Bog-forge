package net.ZuperZ.bog.worldgen.biome;

import net.ZuperZ.bog.Bog;
import net.ZuperZ.bog.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(Bog.MOD_ID, "overworld"), 5));
    }
}
