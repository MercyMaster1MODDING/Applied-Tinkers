package com.applied_tinkers.library.Packets;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
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
    public static void handle(PhoenixPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.hasItemInSlot(EquipmentSlot.CHEST))
            player.respawn();
            player.setHealth(0.5f);

        });
        ctx.get().setPacketHandled(true);
    }
}
