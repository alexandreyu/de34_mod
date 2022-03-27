package io.github.alexandreyu.de34m.core.event;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.entity.DarkEntity;
import io.github.alexandreyu.de34m.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DE34M.MODID, bus = Bus.MOD)
public class CommonModEvents {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.DARK_ENTITY.get(), DarkEntity.createAttributes().build());
	}

}
