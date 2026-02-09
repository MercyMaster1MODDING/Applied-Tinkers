package com.applied_tinkers.library.Packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PhoenixPacket {

    public PhoenixPacket() {
    }

    // Encoder
    public static void encode(PhoenixPacket msg, FriendlyByteBuf buf) {
        return;

    }

    // Decoder
    public static PhoenixPacket decode(FriendlyByteBuf buf) {
        return new PhoenixPacket();
    }

    // Handle packet on server
    public static void handle( PhoenixPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = ctx.get().getSender();
            player.setHealth(0.5f);
            Level level = ctx.get().getSender().serverLevel();
            level.playSound(null, player, SoundEvents.TOTEM_USE, SoundSource.MASTER, 2, 2);

        });
        ctx.get().setPacketHandled(true);
    }
}
