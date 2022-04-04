package io.github.alexandreyu.de34m.common.block;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.block.entity.HighTemperatureFurnaceBlockEntity;
import io.github.alexandreyu.de34m.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HighTemperatureFurnaceBlock extends HorizontalDirectionalBlock implements EntityBlock {

	private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

	private static final Optional<VoxelShape> SHAPE = Optional.of(Block.box(0, 0, 0, 16, 16, 16));

	public HighTemperatureFurnaceBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.EAST)
				.setValue(LIT, Boolean.FALSE).setValue(OPEN, Boolean.FALSE));
		runCalculation(SHAPE.orElse(Shapes.block()));

	}

	protected void runCalculation(VoxelShape shape) {
		for (Direction direction : Direction.values()) {
			SHAPES.put(direction, DE34M.calculateShapes(direction, shape));
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		// TODO Auto-generated method stub
		return SHAPES.get(state.getValue(FACING));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		// TODO Auto-generated method stub
		super.createBlockStateDefinition(builder);
		builder.add(FACING, LIT, OPEN);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
			if (player.isCreative()) {
				Pig pig = EntityType.PIG.create(level);
				pig.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
				level.addFreshEntity(pig);
				this.stateDefinition.any().setValue(LIT, Boolean.TRUE);
				return InteractionResult.SUCCESS;
			} else {
				Sheep sheep = EntityType.SHEEP.create(level);
				sheep.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
				level.addFreshEntity(sheep);
				this.stateDefinition.any().setValue(LIT, Boolean.FALSE);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.FAIL;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.HIGH_TEMPERATURE_FURNACE.get().create(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		return level.isClientSide ? null
				: (level0, pos, state0, blockEntity) -> ((HighTemperatureFurnaceBlockEntity) blockEntity).tick();
	}
}
