package net.tlotd.roads_n_vehicles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HorizontalTrafficLightBlock extends TrafficLightBlock {
    public HorizontalTrafficLightBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape X_SHAPE = Block.box(5, 5, 0, 11, 11, 16);
    private static final VoxelShape Z_SHAPE = Block.box(0, 5, 5, 16, 11, 11);

    private static final VoxelShape X_IRON_ROD_SHAPE = Shapes.or(X_SHAPE, Block.box(7, 0, 7, 9, 16, 9));
    private static final VoxelShape Z_IRON_ROD_SHAPE = Shapes.or(Z_SHAPE, Block.box(7, 0, 7, 9, 16, 9));

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getVoxelShape(blockState);
    }

    @NotNull
    static VoxelShape getVoxelShape(BlockState blockState) {
        switch (blockState.getValue(FACING)) {
            case EAST, WEST -> {
                if (blockState.getValue(IRON_ROD)) {
                    return HorizontalTrafficLightBlock.X_IRON_ROD_SHAPE;
                } else return HorizontalTrafficLightBlock.X_SHAPE;
            }
            default -> {
                if (blockState.getValue(IRON_ROD)) {
                    return HorizontalTrafficLightBlock.Z_IRON_ROD_SHAPE;
                } else return HorizontalTrafficLightBlock.Z_SHAPE;
            }
        }
    }
}