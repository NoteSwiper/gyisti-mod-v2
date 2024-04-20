
package me.noteswiper.gyisti.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import me.noteswiper.gyisti.procedures.CorruptionposiyonnoXiaoGuogaKaiShiShiYongsaretatokiProcedure;

public class CorruptionMobEffect extends MobEffect {
	public CorruptionMobEffect() {
		super(MobEffectCategory.HARMFUL, -3342541);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		CorruptionposiyonnoXiaoGuogaKaiShiShiYongsaretatokiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
