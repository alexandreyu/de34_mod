package io.github.alexandreyu.de34m.core.network;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import io.github.alexandreyu.de34m.common.block.entity.HighTemperatureFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

/*public class ServerboundHighTemperatureFurnaceUpdatePacket {

	public final BlockPos HighTemperatureFurnacePos;

	public ServerboundHighTemperatureFurnaceUpdatePacket(BlockPos pos) {
		this.HighTemperatureFurnacePos = pos;

	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(this.HighTemperatureFurnacePos);
	}

	public boolean handle(Supplier<NetworkEvent.Context> context) {
		final var success = new AtomicBoolean();
		context.get().enqueueWork(() -> {
			final BlockEntity blockEntity = context.get().getSender().level.getBlockEntity(this.HighTemperatureFurnacePos);
			if(blockEntity instanceof HighTemperatureFurnaceBlockEntity furnace) {
				success.set(true);
			}
		});
		context.get().setPacketHandled(true);
		return success.get();
	}

}*/
public class ServerboundHighTemperatureFurnaceUpdatePacket {
	public final BlockPos furnacePos;

	public ServerboundHighTemperatureFurnaceUpdatePacket(BlockPos pos) {
		this.furnacePos = pos;
	}

	public ServerboundHighTemperatureFurnaceUpdatePacket(FriendlyByteBuf buffer) {
		this(buffer.readBlockPos());
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(this.furnacePos);
	}

	public void handle(Supplier<NetworkEvent.Context> context) {
		final var success = new AtomicBoolean();
		context.get().enqueueWork(() -> {
			final BlockEntity blockEntity = context.get().getSender().level.getBlockEntity(this.furnacePos);
			if (blockEntity instanceof final HighTemperatureFurnaceBlockEntity furnace) {
				success.set(true);
			}
		});

		context.get().setPacketHandled(true);
	}
}