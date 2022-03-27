package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {
	private BlockEntityInit() {

	}

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, DE34M.MODID);
}
