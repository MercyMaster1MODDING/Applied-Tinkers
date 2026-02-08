package com.applied_tinkers.library;

import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabsRegistry {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AppliedTinkers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("applied_tinkers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable( "applied_tinkers.applied_tinkers_tab_title"))
                    .icon(() -> new ItemStack(ModItems.PHOENIX_FEATHER.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.PHOENIX_FEATHER.get());

                        output.accept(ModItems.LIQUID_ESSENCE_OF_REBIRTH_BUCKET.get());
                    })
                    .build());
}
