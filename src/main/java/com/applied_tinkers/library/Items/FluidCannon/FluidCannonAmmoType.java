package com.applied_tinkers.library.Items.FluidCannon;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;

public class FluidCannonAmmoType extends AbstractHurtingProjectile {
    protected FluidCannonAmmoType(EntityType<? extends AbstractHurtingProjectile> projectile, Level level) {
        super(projectile, level);
    }
}
