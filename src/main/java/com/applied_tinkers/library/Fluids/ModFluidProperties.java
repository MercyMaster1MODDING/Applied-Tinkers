package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.Blocks.ModBlocks;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class ModFluidProperties {

    public static final ForgeFlowingFluid.Properties ESSENCE_PROPERTIES =
            new ForgeFlowingFluid.Properties(
                    ModFluidTypes.FLUID_ESSENCE_TYPE,
                    ModFluids.LIQUID_ESSENCE_OF_REBIRTH,
                    ModFluids.LIQUID_ESSENCE_OF_REBIRTH_FLOWING

            )
                    .bucket(ModItems.LIQUID_ESSENCE_OF_REBIRTH_BUCKET)
                    .block(ModBlocks.LIQUID_ESSENCE_OF_REBIRTH_BLOCK);

    public static final ForgeFlowingFluid.Properties MOLTEN_BLACKSTEEL_PROPERTIES =
            new ForgeFlowingFluid.Properties(
                    ModFluidTypes.MOLTEN_BLACKSTEEL_FLUID_TYPE,
                    ModFluids.MOLTEN_BLACKSTEEL,
                    ModFluids.MOLTEN_BLACKSTEEL_FLOWING

                    )
                    .bucket(ModItems.MOLTEN_BLACKSTEEL_BUCKET)
                    .block(ModBlocks.MOLTEN_BLACKSTEEL_BLOCK);

    public static final ForgeFlowingFluid.Properties MOLTEN_PITCH_BLACKSTEEL_PROPERTIES =
            new ForgeFlowingFluid.Properties(
                    ModFluidTypes.MOLTEN_PITCH_BLACKSTEEL_FLUID_TYPE,
                    ModFluids.MOLTEN_PITCH_BLACKSTEEL,
                    ModFluids.MOLTEN_PITCH_BLACKSTEEL_FLOWING

            )
                    .bucket(ModItems.MOLTEN_PITCH_BLACKSTEEL_BUCKET)
                    .block(ModBlocks.MOLTEN_PITCH_BLACKSTEEL_BLOCK);
}
