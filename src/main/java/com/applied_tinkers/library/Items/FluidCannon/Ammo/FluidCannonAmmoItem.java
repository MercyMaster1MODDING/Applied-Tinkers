package com.applied_tinkers.library.Items.FluidCannon.Ammo;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class FluidCannonAmmoItem extends FluidCannonAmmoItemAbstractClass {

    public FluidCannonAmmoItem(Properties properties) {
        super(properties, () -> Fluids.LAVA);
    }

    @Override
    protected float setAmmoDamage() {
        return 100;
    }
}