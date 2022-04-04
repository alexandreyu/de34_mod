package io.github.alexandreyu.de34m.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class TokenItem extends Item {

	public TokenItem(Properties properties) {
		super(properties);

	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return super.isPiglinCurrency(stack);
	}
	

}
