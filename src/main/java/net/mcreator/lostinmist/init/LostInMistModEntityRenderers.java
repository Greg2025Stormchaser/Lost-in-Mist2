
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lostinmist.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.lostinmist.client.renderer.EntityinvalidRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LostInMistModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(LostInMistModEntities.ENTITYINVALID.get(), EntityinvalidRenderer::new);
	}
}
