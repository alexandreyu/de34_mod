package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.common.material.BaseToolMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialInit {
	private ToolMaterialInit() {
		
	}
	
	protected static final Tier TUNGSTEN_CARBIDE_TIER = new BaseToolMaterial(0.0F, 4.0F, 5, 4, 2048, 
			() -> Ingredient.of(ItemInit.TUNGSTEN_CARBIDE_INGOT.get()));
	
	protected static final Tier STEEL_TIER = new BaseToolMaterial(9.0F, 4.0F, 8, 4, 512, 
			() -> Ingredient.of(ItemInit.STEEL_INGOT.get()));
	
	protected static final Tier BLACK_STEEL_TIER = new BaseToolMaterial(8.0F, 4.0F, 6, 4, 2048, 
			() -> Ingredient.of(ItemInit.BLACK_STEEL_INGOT.get()));
	
	protected static final Tier WCR_TIER = new BaseToolMaterial(0.0F, 4.0F, 7, 4, 2048, 
			() -> Ingredient.of(ItemInit.WCR_INGOT.get()));
	
	protected static final Tier CHROMIUM_CARBIDE_TIER = new BaseToolMaterial(8.0F, 4.0F, 7, 4, 2048, 
			() -> Ingredient.of(ItemInit.CHROMIUM_CARBIDE_INGOT.get()));

}
