package net.muluk.combined_furnace;

import net.muluk.combined_furnace.registry.BlockEntitiesRegistry;
import net.muluk.combined_furnace.registry.BlockRegistry;
import net.muluk.combined_furnace.registry.ItemRegistry;
import net.muluk.combined_furnace.registry.MenuTypesRegistry;

public final class CombinedFurnace {
    public static final String MOD_ID = "combined_furnace";

    public static void init() {
        BlockRegistry.register();
        BlockEntitiesRegistry.register();
        ItemRegistry.register();
        MenuTypesRegistry.register();
    }
}