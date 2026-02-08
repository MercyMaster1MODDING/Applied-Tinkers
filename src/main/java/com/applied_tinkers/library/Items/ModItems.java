package com.applied_tinkers.library.Items;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Fluids.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AppliedTinkers.MOD_ID);

    public static final RegistryObject<Item> PHOENIX_FEATHER = ITEMS.register("phoenix_feather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_ESSENCE_OF_REBIRTH_BUCKET =
            ITEMS.register("liquid_essence_of_rebirth_bucket",
                    () -> new BucketItem(
                            ModFluids.LIQUID_ESSENCE_OF_REBIRTH,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
