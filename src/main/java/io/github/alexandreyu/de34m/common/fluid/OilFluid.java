package io.github.alexandreyu.de34m.common.fluid;

import java.util.Optional;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.core.init.BlockInit;
import io.github.alexandreyu.de34m.core.init.FluidInit;
import io.github.alexandreyu.de34m.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;

public class OilFluid extends FlowingFluid {

	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(DE34M.MODID, "blocks/oil"),
				new ResourceLocation(DE34M.MODID, "blocks/oil")).build(FluidInit.OIL.get());

	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
	}

	@Override
	public Fluid getFlowing() {
		return FluidInit.FLOWING_OIL.get();
	}

	@Override
	public Fluid getSource() {
		return FluidInit.OIL.get();
	}

	@Override
	protected boolean canConvertToSource() {
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor accessor_, BlockPos pos, BlockState state) {
		BlockEntity blockentity = state.hasBlockEntity() ? accessor_.getBlockEntity(pos) : null;
		Block.dropResources(state, accessor_, pos, blockentity);
	}

	@Override
	protected int getSlopeFindDistance(LevelReader reader) {
		return 4;
	}

	@Override
	protected int getDropOff(LevelReader reader) {
		return 1;
	}

	@Override
	public int getAmount(FluidState state) {
		return 8;
	}

	@Override
	public Item getBucket() {
		return ItemInit.OIL_BUCKET.get();
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockGetter getter, BlockPos pos, Fluid fluid,
			Direction direction) {
		return false;
	}

	@Override
	public int getTickDelay(LevelReader reader) {
		return 60;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState state) {
		return BlockInit.OIL.get().defaultBlockState().setValue(LiquidBlock.LEVEL,
				Integer.valueOf(getLegacyLevel(state)));
	}

	@Override
	public boolean isSource(FluidState state) {
		return true;
	}

	public boolean isSame(Fluid fluid) {
		return fluid == FluidInit.OIL.get() || fluid == FluidInit.FLOWING_OIL.get();
	}

	public static class Flowing extends OilFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> state) {
			super.createFluidStateDefinition(state);
			state.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends OilFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
