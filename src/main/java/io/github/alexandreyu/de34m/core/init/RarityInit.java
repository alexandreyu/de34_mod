package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class RarityInit {
	
	//TODO Try to change to DeferredRegister	
	public static final Rarity LEGENDARY = Rarity.create(DE34M.MODID + "legendary", ChatFormatting.GOLD);
	public static final Rarity MYTHIC = Rarity.create(DE34M.MODID + "mythic", ChatFormatting.RED);
	public static final Rarity FORBIDDEN = Rarity.create(DE34M.MODID + "forbidden", ChatFormatting.OBFUSCATED);
}
