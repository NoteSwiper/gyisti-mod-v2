
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import me.noteswiper.gyisti.block.UncorrupterBlock;
import me.noteswiper.gyisti.block.GyistiPlantBlock;
import me.noteswiper.gyisti.GyistiMod;

public class GyistiModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, GyistiMod.MODID);
	public static final RegistryObject<Block> UNCORRUPTER = REGISTRY.register("uncorrupter", () -> new UncorrupterBlock());
	public static final RegistryObject<Block> GYISTI_PLANT = REGISTRY.register("gyisti_plant", () -> new GyistiPlantBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			GyistiPlantBlock.blockColorLoad(event);
		}
	}
}
