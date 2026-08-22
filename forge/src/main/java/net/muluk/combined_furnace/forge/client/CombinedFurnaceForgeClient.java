package net.muluk.combined_furnace.forge.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.muluk.combined_furnace.CombinedFurnace;
import net.muluk.combined_furnace.client.CombinedFurnaceClient;

@Mod.EventBusSubscriber(modid = CombinedFurnace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CombinedFurnaceForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(CombinedFurnaceClient::init);
    }
}