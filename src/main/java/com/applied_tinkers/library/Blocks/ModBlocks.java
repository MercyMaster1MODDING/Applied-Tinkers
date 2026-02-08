package com.applied_tinkers.library.Blocks;

import com.applied_tinkers.library.AppliedTinkers;
import com.applied_tinkers.library.Fluids.ModFluids;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AppliedTinkers.MOD_ID);

    public static final RegistryObject<LiquidBlock> LIQUID_ESSENCE_OF_REBIRTH_BLOCK =
            BLOCKS.register("liquid_essence_of_rebirth_block",
                    () -> new LiquidBlock(
                            ModFluids.LIQUID_ESSENCE_OF_REBIRTH,
                            Block.Properties.copy(Blocks.WATER)
                    ));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
