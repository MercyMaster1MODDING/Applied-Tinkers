package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, AppliedTinkers.MOD_ID);

    public static final RegistryObject<FluidType> FLUID_ESSENCE_TYPE =
            FLUID_TYPES.register("fluid_essence_type", EssenceFluidType::new);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
