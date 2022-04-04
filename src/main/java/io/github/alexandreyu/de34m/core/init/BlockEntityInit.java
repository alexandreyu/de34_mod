package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.block.entity.HighTemperatureFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, DE34M.MODID);

	public static final RegistryObject<BlockEntityType<HighTemperatureFurnaceBlockEntity>> HIGH_TEMPERATURE_FURNACE = BLOCK_ENTITIES
			.register("high_temperature_furnace", () -> BlockEntityType.Builder
					.of(HighTemperatureFurnaceBlockEntity::new, BlockInit.HIGH_TEMPERATURE_FURNACE.get()).build(null));

	private BlockEntityInit() {
	}

}
