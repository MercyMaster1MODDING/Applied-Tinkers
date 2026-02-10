package com.applied_tinkers.library.Items.FluidCannon.Ammo;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoItemAbstractClass;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidCannonAmmoItem extends FluidCannonAmmoItemAbstractClass {
    public FluidCannonAmmoItem(Properties properties) {
        super(properties, 100, "Ammo", Fluids.WATER);
    }

    @Override
    protected float getAmmoDamage() {
        return 100;
    }

    @Override
    protected String getAmmoName(String name) {
        return name;
    }

    @Override
    protected int getTemperature() {
        return 3000;
    }
}