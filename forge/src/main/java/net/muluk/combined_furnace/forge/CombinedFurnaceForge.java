package net.muluk.combined_furnace.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.muluk.combined_furnace.CombinedFurnace;

@Mod(CombinedFurnace.MOD_ID)
public final class CombinedFurnaceForge {
    public CombinedFurnaceForge(FMLJavaModLoadingContext context) {
        EventBuses.registerModEventBus(CombinedFurnace.MOD_ID, context.getModEventBus());
        CombinedFurnace.init();
    }
}