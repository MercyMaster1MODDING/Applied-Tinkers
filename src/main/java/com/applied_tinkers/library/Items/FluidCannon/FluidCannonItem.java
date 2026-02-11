package com.applied_tinkers.library.Items.FluidCannon;

import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
import com.applied_tinkers.library.Entities.ModEntities;
import com.applied_tinkers.library.Handlers.NetworkHandler;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.ModItems;
import com.applied_tinkers.library.Packets.FluidCannonPacket;
import com.applied_tinkers.library.Tags.ModTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class FluidCannonItem extends ProjectileWeaponItem {
    public static final Predicate<ItemStack> ammoTypePredicate = (ammo) -> ammo.is(ModTags.Items.IS_CANNON_AMMO);
    public FluidCannonItem(Properties properties) {
        super(properties);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ammoTypePredicate;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide){
            return InteractionResultHolder.pass(this.getDefaultInstance());
        }
        sendProjectileFlying(level, player);
        NetworkHandler.CHANNEL.sendToServer(new FluidCannonPacket());
        return InteractionResultHolder.success(this.getDefaultInstance());
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {

        stack.getOrCreateTag().putFloat("Damage", Math.max(0, damage));
    }

    public void sendProjectileFlying(Level level, Player player){
        if (level.isClientSide) return;

        level.playSound(null, player, SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 2, 2);
        ItemStack ammoStack = findCannonAmmo(player);
        if (ammoStack.getItem() instanceof FluidCannonAmmoItemAbstractClass ammo) {
            float damage = ammo.getAmmoDamage();
            FluidCannonAmmoProjectile projectile = new FluidCannonAmmoProjectile(
                    ModEntities.FLUID_CANNON_AMMO_ENTITY.get(), level, damage);

            ammoStack.shrink(1);
            player.getInventory().setChanged();
            projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            float velocity = 3.0f;      // arrow speed
            float inaccuracy = 1.0f;    // random spread
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, velocity, inaccuracy);
            level.addFreshEntity(projectile);
        }
    }

    public ItemStack findCannonAmmo(Player player) {
        // Creative mode: no ammo required
//        if (player.getAbilities().instabuild) {
//            return ItemStack.EMPTY;
//        }

        if (player == null) return ItemStack.EMPTY;

        // Offhand
        ItemStack offhand = player.getOffhandItem();
        if (!offhand.isEmpty() && offhand.getItem() instanceof FluidCannonAmmoItemAbstractClass) {
            return offhand;
        }

        // Main inventory
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.isEmpty() && stack.getItem() instanceof FluidCannonAmmoItemAbstractClass) {
                return stack;
            }
        }

        return ItemStack.EMPTY;
    }
}
