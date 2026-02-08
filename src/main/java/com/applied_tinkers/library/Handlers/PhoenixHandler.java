package com.applied_tinkers.library.Handlers;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Items.ModUpgrades.Modules.Armor.PhoenixModule;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AppliedTinkers.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PhoenixHandler {

    @SubscribeEvent
    protected static void onPlayerDeath(LivingDeathEvent event){

        if (event.getEntity() instanceof Player player){
            event.setCanceled(true);
            PhoenixModule.respawnPlayer(player);
        }
    }
}
