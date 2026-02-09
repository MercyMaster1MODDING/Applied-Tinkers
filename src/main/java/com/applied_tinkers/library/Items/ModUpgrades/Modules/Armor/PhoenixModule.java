package com.applied_tinkers.library.Items.ModUpgrades.Modules.Armor;

import com.applied_tinkers.library.Handlers.NetworkHandler;
import com.applied_tinkers.library.Packets.PhoenixPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;

import java.util.List;

public record PhoenixModule() implements ModifierModule{

    private static boolean hasPhoenixModule;
    private static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.<PhoenixModule>defaultHooks();

    @Override
    public RecordLoadable<PhoenixModule> getLoader() {
        return null;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    public static void respawnPlayer(Player player){
        Level level = Minecraft.getInstance().level;
        if (!level.isClientSide){
            return;
        }
        NetworkHandler.CHANNEL.sendToServer(new PhoenixPacket());
    }

    private static Vec3 returnPos(Player player){
        return player.position();
    }

}
