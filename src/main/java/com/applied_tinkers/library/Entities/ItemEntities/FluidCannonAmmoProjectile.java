package com.applied_tinkers.library.Entities.ItemEntities;

import com.applied_tinkers.library.DamageSources.DamageTypesRegistry;
import com.applied_tinkers.library.DamageSources.ModDamageSources;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class FluidCannonAmmoProjectile extends AbstractHurtingProjectile {

    private float ammo_damage;
    public FluidCannonAmmoProjectile(EntityType<? extends AbstractHurtingProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage_amount) {
        return true;
    }

    @Override
    protected void onHitEntity(EntityHitResult entity) {
        Level level = entity.getEntity().level();
        ModDamageSources sources = new ModDamageSources(level.registryAccess());
        DamageSource source = sources.fluid_cannon_damage_source(null);
        ammo_damage = getAmmo_damage();

        entity.getEntity().hurt(source, ammo_damage);
    }

    public float getAmmo_damage() {
        return ammo_damage;
    }
}
