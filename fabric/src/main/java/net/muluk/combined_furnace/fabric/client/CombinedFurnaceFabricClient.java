package net.muluk.combined_furnace.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.muluk.combined_furnace.client.CombinedFurnaceClient;

public final class CombinedFurnaceFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CombinedFurnaceClient.init();
    }
}