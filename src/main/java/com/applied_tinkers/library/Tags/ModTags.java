package com.applied_tinkers.library.Tags;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static final TagKey<Item> HAS_PHOENIX_MODIFIER = TagKey.create(
            Registries.ITEM, new ResourceLocation(AppliedTinkers.MOD_ID, "has_phoenix_modifier"));

    public static final TagKey<Item> IS_CANNON_AMMO = TagKey.create(
            Registries.ITEM, new ResourceLocation(AppliedTinkers.MOD_ID, "is_fluid_cannon_ammo"));

}
