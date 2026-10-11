package net.tlotd.roads_n_vehicles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TrafficLightBlock extends SignBlock {

    public static final BooleanProperty IRON_ROD = BooleanProperty.create("iron_rod");
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);

    public TrafficLightBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(STAGE, 0).setValue(IRON_ROD, false).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Direction direction = blockPlaceContext.getHorizontalDirection();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
        assert blockPlaceContext.getPlayer() != null;
        return this.defaultBlockState().setValue(STAGE, 0).setValue(IRON_ROD, blockPlaceContext.getPlayer().isCrouching()).setValue(FACING, direction).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, IRON_ROD, STAGE);
    }

    private static final VoxelShape BASE_SHAPE = Block.box(5, 0, 5, 11, 16, 11);
    private static final VoxelShape X_IRON_ROD_SHAPE = Shapes.or(BASE_SHAPE, Block.box(0, 7, 7, 16, 9, 9));
    private static final VoxelShape Z_IRON_ROD_SHAPE = Shapes.or(BASE_SHAPE, Block.box(7, 7, 0, 9, 9, 16));

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getVoxelShape(blockState);
    }

    @NotNull
    static VoxelShape getVoxelShape(BlockState blockState) {
        if (blockState.getValue(IRON_ROD)) {
            switch (blockState.getValue(FACING)) {
                case EAST, WEST -> {
                    return Z_IRON_ROD_SHAPE;
                }
                default -> {
                    return X_IRON_ROD_SHAPE;
                }
            }
        } else return BASE_SHAPE;
    }
}