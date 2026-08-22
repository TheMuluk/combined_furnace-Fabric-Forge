package net.muluk.combinedfurnace.screen.custom;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;
import net.muluk.combinedfurnace.registry.MenuTypesRegistry;

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