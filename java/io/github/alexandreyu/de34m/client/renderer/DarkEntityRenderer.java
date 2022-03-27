package io.github.alexandreyu.de34m.client.renderer;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.client.renderer.model.DarkEntityModel;
import io.github.alexandreyu.de34m.common.entity.DarkEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DarkEntityRenderer<Type extends DarkEntity> extends MobRenderer<Type, DarkEntityModel<Type>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DE34M.MODID,
			"textures/entities/dark_entity.png");

	public DarkEntityRenderer(Context context) {
		super(context, new DarkEntityModel<>(context.bakeLayer(DarkEntityModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Type entity) {
		return TEXTURE;
	}

}
