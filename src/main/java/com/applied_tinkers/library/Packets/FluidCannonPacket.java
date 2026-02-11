package com.applied_tinkers.library.Packets;

import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
import com.applied_tinkers.library.Entities.ModEntities;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.FluidCannon.FluidCannonItem;
import com.applied_tinkers.library.Items.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FluidCannonPacket {

    public FluidCannonPacket() {
    }

    // Encoder
    public static void encode(FluidCannonPacket msg, FriendlyByteBuf buf) {
    }

    // Decoder
    public static FluidCannonPacket decode(FriendlyByteBuf buf) {
        return new FluidCannonPacket();
    }

    // Handle packet on server
    public static void handle(FluidCannonPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = ctx.get().getSender();
            Level level = ctx.get().getSender().serverLevel();

            if (level.isClientSide) return;
            ItemStack stack = player.getMainHandItem();
            if (!(stack.getItem() instanceof FluidCannonItem cannonItem)) return;
            cannonItem.sendProjectileFlying(level, player);

        });
        ctx.get().setPacketHandled(true);
    }
}
