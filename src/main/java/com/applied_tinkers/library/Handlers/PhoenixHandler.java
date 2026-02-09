package com.applied_tinkers.library.Handlers;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Items.ModUpgrades.Modules.Armor.PhoenixModule;
import com.applied_tinkers.library.Tags.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.tables.menu.slot.ArmorSlot;

@Mod.EventBusSubscriber(modid = AppliedTinkers.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PhoenixHandler {

    @SubscribeEvent
    protected static void onPlayerDeath(LivingDeathEvent event){

        if (event.getEntity() instanceof Player player){
            ItemStack player_chest_item = player.getItemBySlot(EquipmentSlot.CHEST);
            if (player_chest_item.is(ModTags.HAS_PHOENIX_MODIFIER)){

                event.setCanceled(true);
                PhoenixModule.respawnPlayer(player);

            }
        }
    }
}
