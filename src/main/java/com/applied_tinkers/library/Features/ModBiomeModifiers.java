package com.applied_tinkers.library.Features;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_BLACKSTEEL_ORE =
            ResourceKey.create(
                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(AppliedTinkers.MOD_ID, "add_blacksteel_ore")
            );

    public static void bootstrap(BootstapContext<BiomeModifier> context) {

        context.register(ADD_BLACKSTEEL_ORE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        context.lookup(Registries.BIOME)
                                .getOrThrow(BiomeTags.IS_OVERWORLD),   // Biomes
                        HolderSet.direct(
                                context.lookup(Registries.PLACED_FEATURE)
                                        .getOrThrow(ModPlacedFeatures.BLACKSTEEL_ORE_PLACED)
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }
}
