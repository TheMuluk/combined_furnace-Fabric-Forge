package net.muluk.combinedfurnace.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.muluk.combinedfurnace.CombinedFurnace;

@Mod(CombinedFurnace.MOD_ID)
public final class CombinedFurnaceForge {
    public CombinedFurnaceForge(FMLJavaModLoadingContext context) {
        EventBuses.registerModEventBus(CombinedFurnace.MOD_ID, context.getModEventBus());
        CombinedFurnace.init();
    }
}