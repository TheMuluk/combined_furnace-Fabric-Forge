package net.muluk.combined_furnace.client;

import dev.architectury.registry.menu.MenuRegistry;
import net.muluk.combined_furnace.registry.MenuTypesRegistry;
import net.muluk.combined_furnace.screen.custom.CombinedFurnaceScreen;

public class CombinedFurnaceClient {

    public static void init() {
        MenuRegistry.registerScreenFactory(
                MenuTypesRegistry.COMBINED_FURNACE.get(),
                CombinedFurnaceScreen::new
        );
    }
}