
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import me.noteswiper.gyisti.item.UncorruptedDustItem;
import me.noteswiper.gyisti.item.CorruptedSwordItem;
import me.noteswiper.gyisti.item.CorruptedDustItem;
import me.noteswiper.gyisti.GyistiMod;

public class GyistiModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GyistiMod.MODID);
	public static final RegistryObject<Item> GYISTI_PLAYER_SPAWN_EGG = REGISTRY.register("gyisti_player_spawn_egg", () -> new ForgeSpawnEggItem(GyistiModEntities.GYISTI_PLAYER, -16738048, -1, new Item.Properties()));
	public static final RegistryObject<Item> CORRUPTED_DUST = REGISTRY.register("corrupted_dust", () -> new CorruptedDustItem());
	public static final RegistryObject<Item> UNCORRUPTED_DUST = REGISTRY.register("uncorrupted_dust", () -> new UncorruptedDustItem());
	public static final RegistryObject<Item> UNCORRUPTER = block(GyistiModBlocks.UNCORRUPTER);
	public static final RegistryObject<Item> GYISTI_PLANT = block(GyistiModBlocks.GYISTI_PLANT);
	public static final RegistryObject<Item> CORRUPTED_SWORD = REGISTRY.register("corrupted_sword", () -> new CorruptedSwordItem());
	public static final RegistryObject<Item> GYISTI_ZOMBIE_SPAWN_EGG = REGISTRY.register("gyisti_zombie_spawn_egg", () -> new ForgeSpawnEggItem(GyistiModEntities.GYISTI_ZOMBIE, -16737793, -6697984, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
