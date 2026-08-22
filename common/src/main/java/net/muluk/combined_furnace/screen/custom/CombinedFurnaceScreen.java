package net.muluk.combined_furnace.screen.custom;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.muluk.combined_furnace.CombinedFurnace;

public class CombinedFurnaceScreen extends AbstractFurnaceScreen<CombinedFurnaceMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CombinedFurnace.MOD_ID, "textures/gui/container/combined_furnace.png");

    public CombinedFurnaceScreen(CombinedFurnaceMenu menu, Inventory inventory, Component title) {
        super(menu, new SmeltingRecipeBookComponent(), inventory, title, TEXTURE);
    }
}