package com.applied_tinkers.library.Entities;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AppliedTinkers.MOD_ID);

    public static final RegistryObject<EntityType<FluidCannonAmmoProjectile>> FLUID_CANNON_AMMO_ENTITY =
            ENTITY_TYPES.register("fluid_cannon_ammo_projectile",
                    () -> EntityType.Builder.<FluidCannonAmmoProjectile>of(FluidCannonAmmoProjectile::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("fluid_cannon_ammo_projectile")

            );

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
