package com.applied_tinkers.library.Items.FluidCannon;

import com.applied_tinkers.library.Items.ModItems;
import com.applied_tinkers.library.Tags.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;

import java.util.function.Predicate;

public class FluidCannonItem extends ProjectileWeaponItem {
    private static ItemStack ammo;
    public static final Predicate<ItemStack> ammoTypePredicate = (ammo) -> ammo.is(ModTags.IS_CANNON_AMMO);
    private static FluidCannonAmmoType ammoType;
    public FluidCannonItem(Properties properties, FluidCannonAmmoType ammoType, ItemStack ammo) {
        super(properties);
        this.ammoType = returnAmmoType(ammoType);
        this.ammo = return_ammo(ammo);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ammoTypePredicate;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    public ItemStack return_ammo(ItemStack ammo){
        return this.ammo;
    }

    public FluidCannonAmmoType returnAmmoType(FluidCannonAmmoType ammoType){
        return ammoType;
    }




}
