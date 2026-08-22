package net.muluk.combinedfurnace.client;

import dev.architectury.registry.menu.MenuRegistry;
import net.muluk.combinedfurnace.registry.MenuTypesRegistry;
import net.muluk.combinedfurnace.screen.custom.CombinedFurnaceScreen;

public class CombinedFurnaceClient {

    public static void init() {
        MenuRegistry.registerScreenFactory(
                MenuTypesRegistry.COMBINED_FURNACE.get(),
                CombinedFurnaceScreen::new
        );
    }
}