package io.github.alexandreyu.de34m.common.block.entity;

import io.github.alexandreyu.de34m.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HighTemperatureFurnaceBlockEntity extends BlockEntity {
	public HighTemperatureFurnaceBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.HIGH_TEMPERATURE_FURNACE.get(), pos, state);
	}

	@Override
	protected void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		load(tag);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return serializeNBT();
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		load(pkt.getTag());
	}

	@Override
	public void onLoad() {
		super.onLoad();
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
	}

	public void tick() {

	}
}
