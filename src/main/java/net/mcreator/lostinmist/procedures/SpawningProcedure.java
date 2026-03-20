package net.mcreator.lostinmist.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.lostinmist.init.LostInMistModEntities;
import net.mcreator.lostinmist.entity.EntityinvalidEntity;
import net.mcreator.lostinmist.LostInMistMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class SpawningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double entity_x = 0;
		double entity_z = 0;
		double entity_y = 0;
		double cooldown = 0;
		if (!(!world.getEntitiesOfClass(EntityinvalidEntity.class, AABB.ofSize(new Vec3(x, y, z), 4000, 4000, 4000), e -> true).isEmpty())) {
			if (!(world instanceof Level _lvl1 && _lvl1.isDay())) {
				if (!(Math.random() < 0.7)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = LostInMistModEntities.ENTITYINVALID.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					LostInMistMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 600, 1200), () -> {
						if (!((Entity) world.getEntitiesOfClass(EntityinvalidEntity.class, AABB.ofSize(new Vec3(x, y, z), 4000, 4000, 4000), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
							((Entity) world.getEntitiesOfClass(EntityinvalidEntity.class, AABB.ofSize(new Vec3(x, y, z), 4000, 4000, 4000), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
					});
				}
			}
		}
	}
}
