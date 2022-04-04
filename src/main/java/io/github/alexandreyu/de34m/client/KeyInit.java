package io.github.alexandreyu.de34m.client;

import com.mojang.blaze3d.platform.InputConstants;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
	public static KeyMapping testKeyMapping;

	private KeyInit() {
	}

	public static void init() {
		testKeyMapping = registerKey("test_key", KeyMapping.CATEGORY_MISC, InputConstants.KEY_N);
	}

	private static KeyMapping registerKey(String name, String category, int keycode) {
		final var key = new KeyMapping("key." + DE34M.MODID + "." + name, keycode, category);
		ClientRegistry.registerKeyBinding(key);
		return key;
	}
}
