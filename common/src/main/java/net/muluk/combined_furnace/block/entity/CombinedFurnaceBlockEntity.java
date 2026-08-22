package net.muluk.combined_furnace.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.muluk.combined_furnace.mixin.AbstractFurnaceBlockEntityAccessor;
import net.muluk.combined_furnace.registry.BlockEntitiesRegistry;
import net.muluk.combined_furnace.screen.custom.CombinedFurnaceMenu;
import org.jetbrains.annotations.NotNull;

public class CombinedFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    private static final int SPEED_MULTIPLIER = 2;

    public CombinedFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.COMBINED_FURNACE.get(), pos, state, RecipeType.SMELTING);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        ItemStack oldStack = this.getItem(slot);
        boolean sameItem = !stack.isEmpty() && ItemStack.isSameItemSameTags(oldStack, stack);

        super.setItem(slot, stack);

        if (slot == 0 && !sameItem) {
            applySpeedBoost(true);
        }
    }

    private int getFullCookTime() {
        if (this.level == null) {
            return 200;
        }

        return this.level.getRecipeManager()
                .getRecipeFor(RecipeType.SMELTING, this, this.level)
                .map(recipe -> ((AbstractCookingRecipe) recipe).getCookingTime())
                .orElse(200);
    }

    private void applySpeedBoost(boolean resetProgress) {
        AbstractFurnaceBlockEntityAccessor accessor = (AbstractFurnaceBlockEntityAccessor) this;

        int fullTime = getFullCookTime();
        if (fullTime <= 0) return;

        int boosted = Math.max(1, fullTime / SPEED_MULTIPLIER);
        int currentTotal = accessor.getCookingTotalTime();

        if (currentTotal != boosted) {
            if (!resetProgress && currentTotal > 0 && accessor.getCookingProgress() > 0) {
                int oldProgress = accessor.getCookingProgress();
                int newProgress = (int) ((long) oldProgress * boosted / currentTotal);
                accessor.setCookingProgress(Math.min(newProgress, boosted - 1));
            } else if (resetProgress) {
                accessor.setCookingProgress(0);
            }

            accessor.setCookingTotalTime(boosted);
            this.setChanged();
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CombinedFurnaceBlockEntity be) {
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, be);
        be.applySpeedBoost(false);
    }

    @Override
    protected int getBurnDuration(ItemStack itemStack) {
        return super.getBurnDuration(itemStack) / 2;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.combined_furnace");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, Inventory inv) {
        return new CombinedFurnaceMenu(id, inv, this, this.dataAccess);
    }
}