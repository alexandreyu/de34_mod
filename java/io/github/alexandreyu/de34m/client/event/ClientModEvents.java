package io.github.alexandreyu.de34m.client.event;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.client.KeyInit;
import io.github.alexandreyu.de34m.client.renderer.DarkEntityRenderer;
import io.github.alexandreyu.de34m.client.renderer.model.DarkEntityModel;
import io.github.alexandreyu.de34m.core.init.BlockInit;
import io.github.alexandreyu.de34m.core.init.EntityInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DE34M.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
	private ClientModEvents() {

	}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GAMMA_ACTIVATOR.get(), RenderType.cutout());
		KeyInit.init();
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(DarkEntityModel.LAYER_LOCATION, DarkEntityModel::createBodyLayer);
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.DARK_ENTITY.get(), DarkEntityRenderer::new);
	}
}
