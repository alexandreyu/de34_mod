package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.core.network.ClientBoundHighTemperatureFurnaceUpdatePacket;
import io.github.alexandreyu.de34m.core.network.ServerboundHighTemperatureFurnaceUpdatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {

	private PacketHandler() {
	}

	private static final String PROTOCOL_VERSION = "1";

	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DE34M.MODID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void init() {
		int index = 0;
		/*
		 * INSTANCE.messageBuilder(ServerboundHighTemperatureFurnaceUpdatePacket.class,
		 * index++, NetworkDirection.PLAY_TO_SERVER).encoder(
		 * ServerboundHighTemperatureFurnaceUpdatePacket::encode)
		 * .decoder(ServerboundHighTemperatureFurnaceUpdatePacket::new)
		 * .consumer(ServerboundHighTemperatureFurnaceUpdatePacket::handle).add();
		 */
		INSTANCE.messageBuilder(ServerboundHighTemperatureFurnaceUpdatePacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundHighTemperatureFurnaceUpdatePacket::encode).decoder(ServerboundHighTemperatureFurnaceUpdatePacket::new)
		.consumer(ServerboundHighTemperatureFurnaceUpdatePacket::handle).add();
		
		INSTANCE.messageBuilder(ClientBoundHighTemperatureFurnaceUpdatePacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ClientBoundHighTemperatureFurnaceUpdatePacket::encode).decoder(ClientBoundHighTemperatureFurnaceUpdatePacket::new)
		.consumer(ClientBoundHighTemperatureFurnaceUpdatePacket::handle).add();
		
		DE34M.LOGGER.info("Registered {} packets for mod '{}'", index, DE34M.MODID);
	}

}
