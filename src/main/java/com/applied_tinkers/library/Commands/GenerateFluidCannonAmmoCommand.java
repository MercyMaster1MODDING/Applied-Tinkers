package com.applied_tinkers.library.Commands;

import com.applied_tinkers.library.Items.FluidCannon.FluidCannonAmmoGenerator;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.commands.arguments.StringRepresentableArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.registries.ForgeRegistries;
import org.jline.reader.impl.DefaultParser;

import java.util.List;

public class GenerateFluidCannonAmmoCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("applied_tinkers")
                .then(Commands.literal("generate_ammo")
                        .then(Commands.literal("fluid_cannon")
                            .then(Commands.argument("ammo_name", StringArgumentType.string())
                        .then(Commands.argument("ammo_damage", FloatArgumentType.floatArg())
                        .then(Commands.argument("fluid", ResourceLocationArgument.id())
                        .then(Commands.argument("amount", IntegerArgumentType.integer())
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            String ammo_name = StringArgumentType.getString(context, "ammo_name");
                            ResourceLocation fluid_location = ResourceLocationArgument.getId(context, "fluid");
                            int amount = IntegerArgumentType.getInteger(context, "amount");
                            Fluid fluid = ForgeRegistries.FLUIDS.getValue(fluid_location);
                            ItemStack new_ammo = FluidCannonAmmoGenerator.GenerateAmmo(fluid, ammo_name, amount);
                            context.getSource().sendSuccess(
                                    () -> Component.literal(ammo_name + "Ammo Generated"),
                                    false
                            );
                            if (!player.getInventory().add(new_ammo)) {
                                player.drop(new_ammo, false);
                            }

                            return 1;
                        })
        )))))));

    }

}
