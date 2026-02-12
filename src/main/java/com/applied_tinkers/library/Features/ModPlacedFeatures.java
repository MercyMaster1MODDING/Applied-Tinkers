package com.applied_tinkers.library.Features;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature>BLACKSTEEL_ORE_PLACED =
            registerKey("blacksteel_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        var configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE)
                .getOrThrow(ModConfiguredFeatures.BLACKSTEEL_ORE_KEY);

        context.register(BLACKSTEEL_ORE_PLACED,
                new PlacedFeature(configuredFeature,
                        commonOrePlacement(
                                2, // veins per chunk
                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-32),
                                        VerticalAnchor.absolute(64)
                                )
                        )
                ));
    }

    // helper method like vanilla
    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier height) {
        return List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                height,
                BiomeFilter.biome()
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(AppliedTinkers.MOD_ID, name));
    }
}
