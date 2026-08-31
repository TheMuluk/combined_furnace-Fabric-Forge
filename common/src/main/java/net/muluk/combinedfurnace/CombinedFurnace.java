package net.muluk.combinedfurnace;

import net.muluk.combinedfurnace.registry.*;

public final class CombinedFurnace {
    public static final String MOD_ID = "combined_furnace";

    public static void init() {
        BlockRegistry.register();
        BlockEntitiesRegistry.register();
        ItemRegistry.register();
        MenuTypesRegistry.register();
        ModCreativeTabs.register();
    }
}