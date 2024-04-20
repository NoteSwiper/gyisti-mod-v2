
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import me.noteswiper.gyisti.client.renderer.GyistiZombieRenderer;
import me.noteswiper.gyisti.client.renderer.GyistiPlayerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GyistiModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GyistiModEntities.GYISTI_PLAYER.get(), GyistiPlayerRenderer::new);
		event.registerEntityRenderer(GyistiModEntities.GYISTI_ZOMBIE.get(), GyistiZombieRenderer::new);
	}
}
