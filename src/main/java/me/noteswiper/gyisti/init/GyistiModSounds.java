
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.noteswiper.gyisti.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import me.noteswiper.gyisti.GyistiMod;

public class GyistiModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GyistiMod.MODID);
	public static final RegistryObject<SoundEvent> CORRUPTEDPLAYER_HURT = REGISTRY.register("corruptedplayer.hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gyisti", "corruptedplayer.hurt")));
	public static final RegistryObject<SoundEvent> CORRUPTEDPLAYER_AMBIENT = REGISTRY.register("corruptedplayer.ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gyisti", "corruptedplayer.ambient")));
	public static final RegistryObject<SoundEvent> UNCORRUPTER_BREAK = REGISTRY.register("uncorrupter.break", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gyisti", "uncorrupter.break")));
}
