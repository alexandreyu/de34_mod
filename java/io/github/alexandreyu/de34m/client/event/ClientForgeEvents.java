package io.github.alexandreyu.de34m.client.event;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DE34M.MODID, bus = Bus.FORGE, value = Dist.CLIENT)
public final class ClientForgeEvents {
	private ClientForgeEvents() {

	}

	/*@SubscribeEvent
	public static void clientTick(ClientTickEvent event) {
		if(KeyInit.testKeyMapping.isDown() && )
	}*/

}
