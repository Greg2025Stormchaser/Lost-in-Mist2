package net.mcreator.lostinmist.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.lostinmist.entity.EntityinvalidEntity;

public class EntityinvalidPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof EntityinvalidEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
