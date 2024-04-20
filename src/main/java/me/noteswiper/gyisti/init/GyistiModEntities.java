
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import me.noteswiper.gyisti.entity.GyistiZombieEntity;
import me.noteswiper.gyisti.entity.GyistiPlayerEntity;
import me.noteswiper.gyisti.GyistiMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GyistiModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GyistiMod.MODID);
	public static final RegistryObject<EntityType<GyistiPlayerEntity>> GYISTI_PLAYER = register("gyisti_player", EntityType.Builder.<GyistiPlayerEntity>of(GyistiPlayerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GyistiPlayerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GyistiZombieEntity>> GYISTI_ZOMBIE = register("gyisti_zombie",
			EntityType.Builder.<GyistiZombieEntity>of(GyistiZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GyistiZombieEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GyistiPlayerEntity.init();
			GyistiZombieEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GYISTI_PLAYER.get(), GyistiPlayerEntity.createAttributes().build());
		event.put(GYISTI_ZOMBIE.get(), GyistiZombieEntity.createAttributes().build());
	}
}
