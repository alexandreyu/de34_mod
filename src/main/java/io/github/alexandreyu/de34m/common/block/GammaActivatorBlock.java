package io.github.alexandreyu.de34m.common.block;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GammaActivatorBlock extends Block {

	private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	private static final Optional<VoxelShape> SHAPE = Stream
			.of(Block.box(0, 12, 0, 16, 16, 16), Block.box(0, 0, 0, 16, 8, 16), Block.box(6, 8, 6, 10, 12, 10))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

	public GammaActivatorBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.EAST));
		runCalculation(SHAPE.orElse(Shapes.block()));
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));

	}

	protected void runCalculation(VoxelShape shape) {
		for (Direction direction : Direction.values()) {
			SHAPES.put(direction, DE34M.calculateShapes(direction, shape));
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPES.get(state.getValue(FACING));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
		builder.add(LIT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
}
