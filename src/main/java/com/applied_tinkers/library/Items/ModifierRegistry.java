package com.applied_tinkers.library.Items;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Items.ModUpgrades.PhoenixModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ModifierRegistry {

    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(AppliedTinkers.MOD_ID);

    public static final StaticModifier<PhoenixModifier> PHOENIX_MODIFIER = MODIFIERS.register("phoenix", PhoenixModifier::new);

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }

}
