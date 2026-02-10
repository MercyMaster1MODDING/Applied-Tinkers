package com.applied_tinkers.library.Packets;

import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
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
            level.playSound(null, player, SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 2, 2);
            ItemStack ammo = new ItemStack(ModItems.FLUID_CANNON_AMMO.get());
            Arrow projectile = new Arrow(EntityType.ARROW, level) {};
//            FluidCannonItem.getHeldProjectile(player, FluidCannonItem.ammoTypePredicate);
//            player.getInventory().setItem(-1, ammo);
//            player.getInventory().setChanged();
//            player.setInvulnerable(true);
            projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            float velocity = 3.0f;      // arrow speed
            float inaccuracy = 1.0f;    // random spread
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, velocity, inaccuracy);
            level.addFreshEntity(projectile);

        });
        ctx.get().setPacketHandled(true);
    }
}
