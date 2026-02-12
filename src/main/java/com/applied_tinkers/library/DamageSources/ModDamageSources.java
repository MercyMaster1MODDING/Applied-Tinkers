package com.applied_tinkers.library.DamageSources;

import com.applied_tinkers.library.DataGen.DamageTypesRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class ModDamageSources extends DamageSources {

    private final Registry<DamageType> damageTypes;

    public ModDamageSources(RegistryAccess access) {
        super(access);
        this.damageTypes = access.registryOrThrow(Registries.DAMAGE_TYPE);
    }



    public DamageSource fluid_cannon_damage_source(Entity entity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(DamageTypesRegistry.FLUID_CANNON), entity);
    }


}
