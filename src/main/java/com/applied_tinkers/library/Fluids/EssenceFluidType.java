package com.applied_tinkers.library.Fluids;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class EssenceFluidType extends FluidType {

    public EssenceFluidType() {
        super(FluidType.Properties.create());
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return new ResourceLocation(AppliedTinkers.MOD_ID, "block/liquid_essence_of_rebirth");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return new ResourceLocation(AppliedTinkers.MOD_ID, "block/liquid_essence_of_rebirth_flow");
            }
        });
    }
}
