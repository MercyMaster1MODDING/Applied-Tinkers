package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Blocks.ModBlocks;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
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
}
