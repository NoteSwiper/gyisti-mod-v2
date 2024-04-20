
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import me.noteswiper.gyisti.block.entity.UncorrupterBlockEntity;
import me.noteswiper.gyisti.GyistiMod;

public class GyistiModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GyistiMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> UNCORRUPTER = register("uncorrupter", GyistiModBlocks.UNCORRUPTER, UncorrupterBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
