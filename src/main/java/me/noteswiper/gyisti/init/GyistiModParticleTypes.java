
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import me.noteswiper.gyisti.GyistiMod;

public class GyistiModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GyistiMod.MODID);
	public static final RegistryObject<SimpleParticleType> CORRUPTION_PARTICLE = REGISTRY.register("corruption_particle", () -> new SimpleParticleType(false));
}
