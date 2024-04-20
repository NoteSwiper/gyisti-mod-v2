package me.noteswiper.gyisti.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import me.noteswiper.gyisti.init.GyistiModParticleTypes;

public class CorruptionposiyonnoXiaoGuogaKaiShiShiYongsaretatokiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (GyistiModParticleTypes.CORRUPTION_PARTICLE.get()), x, y, z, 5, 3, 3, 3, 1);
	}
}
