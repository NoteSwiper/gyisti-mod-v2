
package me.noteswiper.gyisti.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import me.noteswiper.gyisti.entity.GyistiPlayerEntity;
import me.noteswiper.gyisti.client.model.Modelbiped_fix;

public class GyistiPlayerRenderer extends MobRenderer<GyistiPlayerEntity, Modelbiped_fix<GyistiPlayerEntity>> {
	public GyistiPlayerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbiped_fix(context.bakeLayer(Modelbiped_fix.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GyistiPlayerEntity entity) {
		return new ResourceLocation("gyisti:textures/entities/787noteswiper-64x64-edited.png");
	}
}
