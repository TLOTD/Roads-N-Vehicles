package net.tlotd.roads_n_vehicles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
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

public class SmallTrafficLightBlock extends SignBlock {

    public static final BooleanProperty IRON_ROD = BooleanProperty.create("iron_rod");
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);

    public SmallTrafficLightBlock(Properties properties) {
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

    private static final VoxelShape BASE_SHAPE = Block.box(5, 0, 5, 11, 11, 11);

    private static final VoxelShape IRON_ROD_SHAPE = Shapes.or(
            Block.box(7, 11, 7, 9, 16, 9),
            BASE_SHAPE
    );

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getVoxelShape(blockState, BASE_SHAPE, IRON_ROD_SHAPE);
    }

    @NotNull
    static VoxelShape getVoxelShape(BlockState blockState, VoxelShape baseShape, VoxelShape ironRodShape) {
        if (blockState.getValue(IRON_ROD)) {
            return ironRodShape;
        } else return baseShape;
    }
}