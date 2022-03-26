package io.github.alexandreyu.de34m.common.fluids;

import io.github.alexandreyu.de34m.core.init.BlockInit;
import io.github.alexandreyu.de34m.core.init.FluidInit;
import io.github.alexandreyu.de34m.core.init.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;

public class OilFluid extends WaterFluid {

	public Fluid getFlowing() {
		return FluidInit.FLOWING_OIL.get();
	}

	public Fluid getSource() {
		return FluidInit.OIL.get();
	}

	public Item getBucket() {
		return ItemInit.OIL_BUCKET.get();
	}

	@Override
	public int getAmount(FluidState p_164509_) {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public boolean isSource(FluidState p_76140_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BlockState createLegacyBlock(FluidState state) {
		return BlockInit.OIL_ORE.get().defaultBlockState().setValue(LiquidBlock.LEVEL,
				Integer.valueOf(getLegacyLevel(state)));
	}
	@Override
	public boolean isSame(Fluid fluid) {
	      return fluid == FluidInit.OIL.get() || fluid == FluidInit.FLOWING_OIL.get();
	   }


}
