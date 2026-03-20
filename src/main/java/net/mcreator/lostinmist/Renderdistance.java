/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.lostinmist as this package is managed by MCCreator.
 *
 * If you change workspace package, modid or prefix, you will need to
 * manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
 */
package net.mcreator.lostinmist;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.server.ServerStartingEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Renderdistance {

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public static void serverLoad(ServerStartingEvent event) {
	}
}