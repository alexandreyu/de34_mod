package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.entity.DarkEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityInit {
	private EntityInit() {}

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DE34M.MODID);
	
	public static final RegistryObject<EntityType<DarkEntity>> DARK_ENTITY = ENTITIES.register("dark_entity",
			() -> EntityType.Builder.of(DarkEntity::new, MobCategory.CREATURE).sized(8.0F, 2.0F).fireImmune()
			.build(new ResourceLocation(DE34M.MODID, "dark_entity").toString()));
}
