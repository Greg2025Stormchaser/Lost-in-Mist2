package net.mcreator.lostinmist.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class EventsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double eventnum = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 25000) == 1) {
			eventnum = Mth.nextInt(RandomSource.create(), 1, 3);
			if (eventnum == 1) {
				if (world.getLevelData() instanceof ServerLevelData _levelData2)
					_levelData2.setGameTime(1);
			} else {
				if (eventnum == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, (float) 0.7);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, (float) 0.7, false);
						}
					}
				} else {
					if (eventnum == 3) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hello?"), false);
					}
				}
			}
		}
	}
}
