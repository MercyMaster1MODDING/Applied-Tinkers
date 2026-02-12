package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class MoltenBlacksteelFluidType extends FluidType {

    public MoltenBlacksteelFluidType() {
        super(FluidType.Properties.create());
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return new ResourceLocation(AppliedTinkers.MOD_ID, "block/molten_blacksteel");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return new ResourceLocation(AppliedTinkers.MOD_ID, "block/molten_blacksteel_flowing");
            }

        });
    }
}
