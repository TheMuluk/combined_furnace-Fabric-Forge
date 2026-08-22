package net.muluk.combined_furnace.mixin;

import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceBlockEntity.class)
public interface AbstractFurnaceBlockEntityAccessor {

    @Accessor("cookingProgress")
    int getCookingProgress();

    @Accessor("cookingProgress")
    void setCookingProgress(int value);

    @Accessor("cookingTotalTime")
    int getCookingTotalTime();

    @Accessor("cookingTotalTime")
    void setCookingTotalTime(int value);
}