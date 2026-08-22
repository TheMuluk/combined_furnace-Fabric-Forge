package net.muluk.combinedfurnace.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.muluk.combinedfurnace.client.CombinedFurnaceClient;

public final class CombinedFurnaceFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CombinedFurnaceClient.init();
    }
}