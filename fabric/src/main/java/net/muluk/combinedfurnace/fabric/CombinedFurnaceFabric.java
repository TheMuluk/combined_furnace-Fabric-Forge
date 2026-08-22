package net.muluk.combinedfurnace.fabric;

import net.fabricmc.api.ModInitializer;

import net.muluk.combinedfurnace.CombinedFurnace;

public final class CombinedFurnaceFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CombinedFurnace.init();
    }
}
