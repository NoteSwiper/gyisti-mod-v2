
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import me.noteswiper.gyisti.GyistiMod;

public class GyistiModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GyistiMod.MODID);
	public static final RegistryObject<CreativeModeTab> GYISTI = REGISTRY.register("gyisti",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.gyisti.gyisti")).icon(() -> new ItemStack(GyistiModItems.GYISTI_PLAYER_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GyistiModItems.GYISTI_PLAYER_SPAWN_EGG.get());
				tabData.accept(GyistiModItems.CORRUPTED_DUST.get());
				tabData.accept(GyistiModItems.UNCORRUPTED_DUST.get());
				tabData.accept(GyistiModBlocks.UNCORRUPTER.get().asItem());
				tabData.accept(GyistiModBlocks.GYISTI_PLANT.get().asItem());
				tabData.accept(GyistiModItems.CORRUPTED_SWORD.get());
				tabData.accept(GyistiModItems.GYISTI_ZOMBIE_SPAWN_EGG.get());
			}).withSearchBar().build());
}
