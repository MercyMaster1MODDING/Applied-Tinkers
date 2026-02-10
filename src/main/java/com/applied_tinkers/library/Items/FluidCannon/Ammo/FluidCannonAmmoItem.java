package com.applied_tinkers.library.Items.FluidCannon.Ammo;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import net.minecraft.world.level.material.Fluids;

public class FluidCannonAmmoItem extends FluidCannonAmmoItemAbstractClass {
    public FluidCannonAmmoItem(Properties properties) {
        super(properties, 100, Fluids.WATER);
    }
}