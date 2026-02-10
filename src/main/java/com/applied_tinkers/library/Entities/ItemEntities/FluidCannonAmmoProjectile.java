package com.applied_tinkers.library.Entities.ItemEntities;

import com.applied_tinkers.library.DamageSources.ModDamageSources;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class FluidCannonAmmoProjectile extends AbstractHurtingProjectile implements ItemSupplier {

    private float ammo_damage;

    private final ItemStack ammoStack;
    public FluidCannonAmmoProjectile(EntityType<FluidCannonAmmoProjectile> entityType, Level level, ItemStack ammoStack) {
        super(entityType, level);
        this.ammoStack = ammoStack;

    }

    public FluidCannonAmmoProjectile(EntityType<FluidCannonAmmoProjectile> entityType, Level level) {
        super(entityType, level);
        this.ammoStack = ModItems.FLUID_CANNON_AMMO.get().getDefaultInstance();
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
        return ammo_damage = 1;
    }

    @Override
    protected float getInertia() {
        return 0.95f;
    }

    @Override
    public ItemStack getItem() {
        return ammoStack;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }
}
