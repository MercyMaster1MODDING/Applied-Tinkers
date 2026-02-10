package com.applied_tinkers.library.Items.FluidCannon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

public abstract class FluidCannonAmmoItemAbstractClass extends ArrowItem {

    protected float ammo_damage;
    protected String name;
    protected Fluid fluid;

    public FluidCannonAmmoItemAbstractClass(Item.Properties properties, float ammo_damage, String name, Fluid fluid){
        super(properties);
        this.ammo_damage = ammo_damage;
        this.name = name;
        this.fluid = fluid;

    }

    protected abstract float getAmmoDamage();

    public float returnAmmoDamage(){
        return getAmmoDamage();
    };

    protected abstract String getAmmoName(String name);

    protected int getTemperature(){
        return fluid.getFluidType().getTemperature();
    }

    protected float setAmmoDamage(){
        int temperature = getTemperature();
        float damage = Math.max(0.5f, temperature / 1000);
        return damage + (damage * 1.3f);
    }

    protected ResourceLocation setTexture(ResourceLocation textureLocation){
        ResourceLocation defaultTextureLocation = new ResourceLocation("minecraft:water");
        if (textureLocation == null){
            textureLocation = defaultTextureLocation;
        }
        return textureLocation;
    }

}
