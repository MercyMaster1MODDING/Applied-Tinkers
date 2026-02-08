package com.applied_tinkers.library.Items.ModUpgrades;

import com.applied_tinkers.library.Items.ModUpgrades.Modules.Armor.PhoenixModule;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;

public class PhoenixModifier extends NoLevelsModifier {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addModule(new PhoenixModule());
    }
}
