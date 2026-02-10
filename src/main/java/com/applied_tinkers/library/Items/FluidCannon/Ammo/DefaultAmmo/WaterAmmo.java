package com.applied_tinkers.library.Items.FluidCannon.Ammo.DefaultAmmo;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;

public class WaterAmmo extends FluidCannonAmmoItemAbstractClass {

    public WaterAmmo(Properties properties) {
        super(properties, 1, Fluids.WATER);
    }

}
