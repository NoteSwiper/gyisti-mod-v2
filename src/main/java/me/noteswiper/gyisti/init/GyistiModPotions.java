
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import me.noteswiper.gyisti.GyistiMod;

public class GyistiModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, GyistiMod.MODID);
	public static final RegistryObject<Potion> CORRUPTION_POTION = REGISTRY.register("corruption_potion", () -> new Potion(new MobEffectInstance(GyistiModMobEffects.CORRUPTION.get(), 3600, 4, false, true)));
}
