package com.applied_tinkers.library.DamageSources;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

public class DamageTypesRegistry {

    public static final ResourceKey<DamageType> FLUID_CANNON =
            ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    new ResourceLocation(AppliedTinkers.MOD_ID, "fluid_cannon")
            );

    public static final RegistrySetBuilder BUILDER =
            new RegistrySetBuilder()
                    .add(Registries.DAMAGE_TYPE, context -> {
                        context.register(
                                FLUID_CANNON,
                                new DamageType(
                                        "fluid_cannon",
                                        DamageScaling.NEVER,
                                        0.2F,
                                        DamageEffects.HURT,
                                        DeathMessageType.DEFAULT
                                )
                        );
                    });
}
