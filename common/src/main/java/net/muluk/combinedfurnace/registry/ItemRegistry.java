package net.muluk.combinedfurnace.registry;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.muluk.combinedfurnace.CombinedFurnace;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(CombinedFurnace.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }
}