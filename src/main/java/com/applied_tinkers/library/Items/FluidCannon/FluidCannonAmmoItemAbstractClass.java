package com.applied_tinkers.library.Items.FluidCannon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

public abstract class FluidCannonAmmoItemAbstractClass extends Item {

    protected static float ammo_damage;
    protected Fluid fluid;

    public FluidCannonAmmoItemAbstractClass(Item.Properties properties, float ammo_damage, Fluid fluid){
        super(properties);
        this.ammo_damage = ammo_damage;
        this.fluid = fluid;

    }

    public float getAmmoDamage(){

        return ammo_damage;
    };

    protected int getTemperature(){
        return fluid.getFluidType().getTemperature();
    }

    protected float setAmmoDamage(){
        int temperature = getTemperature();
        float damage = Math.max(0.5f, temperature / 1000);
        return damage + (damage * 1.3f);
    }
}
