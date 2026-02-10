package com.applied_tinkers.library.DataGen;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.DamageSources.DamageTypesRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatagen extends DatapackBuiltinEntriesProvider {


    public ModDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DamageTypesRegistry.BUILDER, Set.of(AppliedTinkers.MOD_ID));
    }
}
