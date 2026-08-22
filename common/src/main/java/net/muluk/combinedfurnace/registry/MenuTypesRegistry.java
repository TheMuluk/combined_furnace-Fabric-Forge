package net.muluk.combinedfurnace.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import net.muluk.combinedfurnace.CombinedFurnace;
import net.muluk.combinedfurnace.screen.custom.CombinedFurnaceMenu;

public class MenuTypesRegistry {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(CombinedFurnace.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<CombinedFurnaceMenu>> COMBINED_FURNACE =
            MENUS.register(
                    "combined_furnace",
                    () -> new MenuType<>(
                            CombinedFurnaceMenu::new,
                            FeatureFlags.DEFAULT_FLAGS
                    )
            );

    public static void register() {
        MENUS.register();
    }
}