package net.muluk.combined_furnace.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.muluk.combined_furnace.block.entity.CombinedFurnaceBlockEntity;
import net.muluk.combined_furnace.registry.BlockEntitiesRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CombinedFurnaceBlock extends AbstractFurnaceBlock {

    public CombinedFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void openContainer(Level level, @NotNull BlockPos pos, @NotNull Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CombinedFurnaceBlockEntity furnace) {
            player.openMenu(furnace);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new CombinedFurnaceBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        if (level.isClientSide()) return null;

        return createTickerHelper(
                type,
                BlockEntitiesRegistry.COMBINED_FURNACE.get(),
                CombinedFurnaceBlockEntity::tick
        );
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if ((Boolean)blockState.getValue(LIT)) {
            double d = (double)blockPos.getX() + (double)0.5F;
            double e = (double)blockPos.getY();
            double f = (double)blockPos.getZ() + (double)0.5F;
            if (randomSource.nextDouble() < 0.1) {
                level.playLocalSound(d, e, f, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)blockState.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = randomSource.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : h;
            double j = randomSource.nextDouble() * (double)6.0F / (double)16.0F;
            double k = axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : h;
            level.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, (double)0.0F, (double)0.0F, (double)0.0F);
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d + i, e + j, f + k, (double)0.0F, (double)0.0F, (double)0.0F);
        }
    }
}