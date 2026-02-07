package com.applied_tinkers.library;

import com.applied_tinkers.library.Items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AppliedTinkers.MOD_ID)
public class AppliedTinkers
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "applied_tinkers";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AppliedTinkers(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

//        ModEffects.EFFECTS.register(modEventBus);
        ModItems.register(modEventBus);
//        ModBlocks.register(modEventBus);
//        ModRecipeRegister.SERIALIZERS.register(modEventBus);
//        ModCreativeModeTabsRegistry.TABS.register(modEventBus);





        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });

    }


    // Add the example block item to the vanilla ingredients tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
//        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(ModItems.RAW_MERCINIUM);
//        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void registerAttributes(net.minecraftforge.event.entity.EntityAttributeCreationEvent event) {

        }
    }

}
