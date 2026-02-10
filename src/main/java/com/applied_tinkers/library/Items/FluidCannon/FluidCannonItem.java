package com.applied_tinkers.library.Items.FluidCannon;

import com.applied_tinkers.library.Entities.ItemEntities.FluidCannonAmmoProjectile;
import com.applied_tinkers.library.Handlers.NetworkHandler;
import com.applied_tinkers.library.Items.FluidCannon.Ammo.FluidCannonAmmoItem;
import com.applied_tinkers.library.Items.ModItems;
import com.applied_tinkers.library.Packets.FluidCannonPacket;
import com.applied_tinkers.library.Tags.ModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class FluidCannonItem extends ProjectileWeaponItem {
    public static ItemStack ammo;
    public static final Predicate<ItemStack> ammoTypePredicate = (ammo) -> ammo.is(ModTags.Items.IS_CANNON_AMMO);
    public static FluidCannonAmmoProjectile ammoType;
    public FluidCannonItem(Properties properties, FluidCannonAmmoProjectile ammoType, ItemStack ammo) {
        super(properties);
        this.ammoType = ammoType;
        this.ammo = ammo;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ammoTypePredicate;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    public ItemStack return_ammo(ItemStack ammo){
        return ammo;
    }

    public FluidCannonAmmoProjectile returnAmmoType(FluidCannonAmmoProjectile ammoType){
        return ammoType;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide){
            return InteractionResultHolder.pass(this.getDefaultInstance());
        }

        NetworkHandler.CHANNEL.sendToServer(new FluidCannonPacket());
        return InteractionResultHolder.success(this.getDefaultInstance());
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int num) {
        super.releaseUsing(itemStack, level, entity, num);
    }


}
