package com.applied_tinkers.library.Items.FluidCannon;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public abstract class FluidCannonAmmoItemAbstractClass extends Item {

    private Float cachedAmmoDamage = null;
    protected final Supplier<Fluid> fluidSupplier;
    public FluidCannonAmmoItemAbstractClass(Item.Properties properties, Supplier<Fluid> fluidSupplier){
        super(properties);
        this.fluidSupplier = fluidSupplier;

    }

    public float getAmmoDamage() {
        return setAmmoDamage();
    }

    protected int getTemperature(){
        return fluidSupplier.get().getFluidType().getTemperature();
    }

    protected float setAmmoDamage(){
        int temperature = getTemperature();
        float damage = Math.max(0.5f, temperature / 1000);
        return damage + (damage * 1.3f);
    }

    public Supplier<Fluid> getFluid() {
        return fluidSupplier;
    }
}
