package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, AppliedTinkers.MOD_ID);

    public static final RegistryObject<FlowingFluid> LIQUID_ESSENCE_OF_REBIRTH =
            FLUIDS.register("liquid_essence_of_rebirth",
                    () -> new ForgeFlowingFluid.Source(ModFluidProperties.ESSENCE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LIQUID_ESSENCE_OF_REBIRTH_FLOWING =
            FLUIDS.register("liquid_essence_of_rebirth_flowing",
                    () -> new ForgeFlowingFluid.Flowing(ModFluidProperties.ESSENCE_PROPERTIES));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
