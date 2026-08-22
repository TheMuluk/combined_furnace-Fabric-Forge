package net.muluk.combinedfurnace.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.muluk.combinedfurnace.CombinedFurnace;
import net.muluk.combinedfurnace.block.custom.CombinedFurnaceBlock;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(CombinedFurnace.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> COMBINED_FURNACE = registerBlock("combined_furnace",
            () -> new CombinedFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)));

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        RegistrySupplier<T> reg = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, reg);
        return reg;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistrySupplier<T> block) {
        ItemRegistry.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register() {
        BLOCKS.register();
    }
}