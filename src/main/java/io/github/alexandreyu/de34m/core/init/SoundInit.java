package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class SoundInit {
	private SoundInit() {
		
	}
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DE34M.MODID);

}
