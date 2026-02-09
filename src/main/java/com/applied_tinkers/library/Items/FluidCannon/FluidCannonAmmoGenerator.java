package com.applied_tinkers.library.Items.FluidCannon;

import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public class FluidCannonAmmoGenerator {

    public static ItemStack GenerateAmmo(Fluid fluid, String name, int amount){


        String fluid_name = setFluidName(fluid);
        float ammo_damage = ((fluid.getFluidType().getTemperature()) / 100) + 0.5f ;

        Item newAmmo = ModItems.FLUID_CANNON_AMMO.get();
        ItemStack stack = new ItemStack(newAmmo);

        stack.getOrCreateTag().putString("FluidName", fluid_name);
        stack.getTag().putFloat("AmmoDamage", ammo_damage);
        stack.getOrCreateTag().putString("AmmoName", name);
        stack.setCount(amount);
        return stack;
    }

    private static String setFluidName(Fluid fluid){
        return fluid.toString();
    }
}
