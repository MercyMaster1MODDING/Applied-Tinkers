package com.applied_tinkers.library.Renderers;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class FluidCannonAmmoRenderer extends EntityRenderer<FluidCannonAmmoProjectile> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(AppliedTinkers.MOD_ID, "textures/item/phoenix_feather.png");

    public FluidCannonAmmoRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(FluidCannonAmmoProjectile fluidCannonAmmoProjectile) {
        return TEXTURE;
    }



}
