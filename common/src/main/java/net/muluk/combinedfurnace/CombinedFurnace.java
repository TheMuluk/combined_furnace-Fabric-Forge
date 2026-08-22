package net.muluk.combinedfurnace;

import net.muluk.combinedfurnace.registry.BlockEntitiesRegistry;
import net.muluk.combinedfurnace.registry.BlockRegistry;
import net.muluk.combinedfurnace.registry.ItemRegistry;
import net.muluk.combinedfurnace.registry.MenuTypesRegistry;

public final class CombinedFurnace {
    public static final String MOD_ID = "combined_furnace";

    public static void init() {
        BlockRegistry.register();
        BlockEntitiesRegistry.register();
        ItemRegistry.register();
        MenuTypesRegistry.register();
    }
}