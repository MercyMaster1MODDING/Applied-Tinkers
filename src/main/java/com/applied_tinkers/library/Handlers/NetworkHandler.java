package com.applied_tinkers.library.Handlers;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Packets.PhoenixPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkDirection;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AppliedTinkers.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        int id = 0;
        CHANNEL.messageBuilder(PhoenixPacket.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PhoenixPacket::encode)
                .decoder(PhoenixPacket::decode)
                .consumerMainThread(PhoenixPacket::handle)
                .add();
    }
}
