package net.muluk.combinedfurnace.registry;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.world.item.CreativeModeTabs;

public class ModCreativeTabs {

    public static void register() {
        CreativeTabRegistry.append(CreativeModeTabs.FUNCTIONAL_BLOCKS, BlockRegistry.COMBINED_FURNACE);
    }
}