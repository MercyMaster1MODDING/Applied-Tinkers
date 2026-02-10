package com.applied_tinkers.library.Items.FluidCannon.Ammo.DefaultAmmo;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.registries.ForgeRegistries;

public class WaterAmmo extends FluidCannonAmmoItemAbstractClass {

    public WaterAmmo(Properties properties) {
        super(properties, 1, "Water Ammo", Fluids.WATER);
        this.ammo_damage = 1;
    }

    @Override
    protected float getAmmoDamage() {
        return this.setAmmoDamage();
    }

    @Override
    protected String getAmmoName(String name) {
        return name;
    }

    @Override
    protected float setAmmoDamage() {
        this.ammo_damage = super.setAmmoDamage();
        return this.ammo_damage;
    }

    @Override
    protected int getTemperature() {
        return super.getTemperature();
    }

    @Override
    protected ResourceLocation setTexture(ResourceLocation textureLocation) {
        return textureLocation;
    }
}
