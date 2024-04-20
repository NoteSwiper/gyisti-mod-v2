
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import me.noteswiper.gyisti.potion.CorruptionMobEffect;
import me.noteswiper.gyisti.GyistiMod;

public class GyistiModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GyistiMod.MODID);
	public static final RegistryObject<MobEffect> CORRUPTION = REGISTRY.register("corruption", () -> new CorruptionMobEffect());
}
