package net.tlotd.roads_n_vehicles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import org.jetbrains.annotations.NotNull;

public class CornerRodBlock extends SignBlock {
    public CornerRodBlock(Properties properties) {
        super(properties);
    }

    private static final net.minecraft.world.phys.shapes.VoxelShape BASE_SHAPE = Block.box(7, 0, 7, 9, 7, 9);

    private static final net.minecraft.world.phys.shapes.VoxelShape WEST_SHAPE = Shapes.or(
            Block.box(7, 7, 7, 9, 9, 16),
            BASE_SHAPE
    );
    private static final net.minecraft.world.phys.shapes.VoxelShape NORTH_SHAPE = Shapes.or(
            Block.box(0, 7, 7, 9, 9, 9),
            BASE_SHAPE
    );
    private static final net.minecraft.world.phys.shapes.VoxelShape EAST_SHAPE = Shapes.or(
            Block.box(7, 7, 0, 9, 9, 9),
            BASE_SHAPE
    );
    private static final net.minecraft.world.phys.shapes.VoxelShape SOUTH_SHAPE = Shapes.or(
            Block.box(7, 7, 7, 16, 9, 9),
            BASE_SHAPE
    );

    public @NotNull net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getVoxelShape(blockState, NORTH_SHAPE, SOUTH_SHAPE, WEST_SHAPE, EAST_SHAPE, BASE_SHAPE);
    }
}