package net.muluk.combined_furnace.fabric;

import net.fabricmc.api.ModInitializer;

import net.muluk.combined_furnace.CombinedFurnace;

public final class CombinedFurnaceFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CombinedFurnace.init();
    }
}
