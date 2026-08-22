package net.muluk.combined_furnace.screen.custom;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;
import net.muluk.combined_furnace.registry.MenuTypesRegistry;

public class CombinedFurnaceMenu extends AbstractFurnaceMenu {

    public CombinedFurnaceMenu(int syncId, Inventory inventory) {
        super(
                MenuTypesRegistry.COMBINED_FURNACE.get(),
                RecipeType.SMELTING,
                RecipeBookType.FURNACE,
                syncId,
                inventory
        );
    }

    public CombinedFurnaceMenu(int syncId, Inventory inventory, Container container, ContainerData containerData) {
        super(
                MenuTypesRegistry.COMBINED_FURNACE.get(),
                RecipeType.SMELTING,
                RecipeBookType.FURNACE,
                syncId,
                inventory,
                container,
                containerData
        );
    }
}