package net.muluk.combinedfurnace.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.muluk.combinedfurnace.CombinedFurnace;
import net.muluk.combinedfurnace.block.entity.CombinedFurnaceBlockEntity;

public class BlockEntitiesRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(CombinedFurnace.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CombinedFurnaceBlockEntity>> COMBINED_FURNACE =
            BLOCK_ENTITIES.register("combined_furnace",
                    () -> BlockEntityType.Builder.of(
                            CombinedFurnaceBlockEntity::new,
                            BlockRegistry.COMBINED_FURNACE.get()
                    ).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}