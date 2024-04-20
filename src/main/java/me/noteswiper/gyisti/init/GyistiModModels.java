
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import me.noteswiper.gyisti.client.model.Modelbiped_fix;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GyistiModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelbiped_fix.LAYER_LOCATION, Modelbiped_fix::createBodyLayer);
	}
}
