package net.tlotd.roads_n_vehicles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ModRodBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

    private static final VoxelShape X_SHAPE = Block.box(0, 7, 7, 16, 9, 9);
    private static final VoxelShape Y_SHAPE = Block.box(7, 0, 7, 9, 16, 9);
    private static final VoxelShape Z_SHAPE = Block.box(7, 7, 0, 9, 9, 16);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ModRodBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS);
    }

    public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return !(Boolean)blockState.getValue(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getVoxelShape(blockState);
    }

    @NotNull
    static VoxelShape getVoxelShape(BlockState blockState) {
        switch (blockState.getValue(AXIS)) {
            case X -> {
                return ModRodBlock.X_SHAPE;
            }
            case Z -> {
                return ModRodBlock.Z_SHAPE;
            }
            default -> {
                return ModRodBlock.Y_SHAPE;
            }
        }
    }
}