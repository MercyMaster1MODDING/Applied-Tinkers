package com.applied_tinkers.library.Commands;

import com.applied_tinkers.library.AppliedTinkers;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AppliedTinkers.MOD_ID)
public class CommandEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        GenerateFluidCannonAmmoCommand.register(event.getDispatcher());
    }
}
