package com.applied_tinkers.library.Entities.ItemEntities;

import com.applied_tinkers.library.DamageSources.ModDamageSources;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class FluidCannonAmmoProjectile extends AbstractHurtingProjectile implements ItemSupplier {

    private static final EntityDataAccessor<Float> ammo_damage =
            SynchedEntityData.defineId(FluidCannonAmmoProjectile.class, EntityDataSerializers.FLOAT);

    private ItemStack ammoStack;

    public FluidCannonAmmoProjectile(EntityType<FluidCannonAmmoProjectile> entityType, Level level) {
        super(entityType, level);
        this.ammoStack = ItemStack.EMPTY;
    }
    public FluidCannonAmmoProjectile(EntityType<FluidCannonAmmoProjectile> entityType, Level level, float damage) {
        super(entityType, level);
        this.entityData.set(ammo_damage, damage);

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

        entity.getEntity().hurt(source, getAmmoDamage());
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected float getInertia() {
        return 0.95f;
    }

    @Override
    public ItemStack getItem() {
        return ammoStack == null ? ItemStack.EMPTY : ammoStack;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(ammo_damage, 0f);
    }

    public void setAmmoDamage(float damage) {
        this.entityData.set(ammo_damage, damage);
    }

    public float getAmmoDamage() {
        return this.entityData.get(ammo_damage);
    }
}
