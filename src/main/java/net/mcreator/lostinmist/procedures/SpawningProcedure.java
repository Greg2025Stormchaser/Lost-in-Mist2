package net.mcreator.lostinmist.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.lostinmist.init.LostInMistModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double y, double z, Entity entity) {
		execute(null, world, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double entity_x = 0;
		double entity_z = 0;
		double entity_y = 0;
		double cooldown = 0;
		if (cooldown < 0) {
			cooldown = 20;
			if (world.getLevelData().getGameTime() == 18000) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = LostInMistModEntities.ENTITYINVALID.get().spawn(_level, BlockPos.containing(entity_x + 80, entity_y + 0, entity_z + 80), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof Level _level) {
					if (_level.isClientSide()) {
						_level.playLocalSound((entity.getX()), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else {
			cooldown = cooldown - 1;
		}
	}
}
