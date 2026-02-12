package com.applied_tinkers.library.Items;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Blocks.ModBlocks;
import com.applied_tinkers.library.Fluids.ModFluids;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.DefaultAmmo.WaterAmmo;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.FluidCannon.FluidCannonItem;
import net.minecraft.world.item.BlockItem;
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

    //Piggy Backpack is a upgradeable backpack that has a upgrade to enable the player to pick up mob spawners
    public static final RegistryObject<Item> PIGGY_BACKPACK = ITEMS.register("piggy_backpack",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BACKPACK_CORE = ITEMS.register("backpack_core",
            () -> new Item(new Item.Properties()));

    //The fluid cannon takes fluids from the piggy backpack and other tanks in the player's inventory
    //and it solidifies them into balls/cannons
    public static final RegistryObject<FluidCannonItem> FLUID_CANNON = ITEMS.register("fluid_cannon",
            () -> new FluidCannonItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<FluidCannonAmmoItem> FLUID_CANNON_AMMO = ITEMS.register("fluid_cannon_ammo",
            () -> new FluidCannonAmmoItem(new Item.Properties()));

    public static final RegistryObject<WaterAmmo> WATER_FLUID_CANNON_AMMO = ITEMS.register("water_ammo",
            () -> new WaterAmmo(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_ESSENCE_OF_REBIRTH_BUCKET =
            ITEMS.register("liquid_essence_of_rebirth_bucket",
                    () -> new BucketItem(
                            ModFluids.LIQUID_ESSENCE_OF_REBIRTH,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                    ));

    public static final RegistryObject<Item> MOLTEN_BLACKSTEEL_BUCKET =
            ITEMS.register("molten_blacksteel_bucket",
                    () -> new BucketItem(
                            ModFluids.MOLTEN_BLACKSTEEL,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                    ));

    public static final RegistryObject<Item> MOLTEN_PITCH_BLACKSTEEL_BUCKET =
            ITEMS.register("molten_pitch_blacksteel_bucket",
                    () -> new BucketItem(
                            ModFluids.MOLTEN_PITCH_BLACKSTEEL,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                    ));

    public static final RegistryObject<Item> BLACKSTEEL_INGOT = ITEMS.register("blacksteel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PITCH_BLACKSTEEL_INGOT = ITEMS.register("pitch_blacksteel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<BlockItem> BLACKSTEEL_ORE = ITEMS.register("blacksteel_ore",
            () -> new BlockItem(ModBlocks.BLACKSTEEL_ORE.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
