package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.common.material.BaseArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorMaterialInit {

	public static final ArmorMaterial ELERIUM_ARMOR_MATERIAL = new BaseArmorMaterial(15,
			new int[] { 512, 512, 512, 512 }, new int[] { 2, 6, 5, 4 }, 0.5F, 1.5F, "elerium",
			SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ItemInit.ELERIUM_PLATE.get()));

	private ArmorMaterialInit() {

	}

}
