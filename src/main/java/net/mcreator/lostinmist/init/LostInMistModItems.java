
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lostinmist.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.lostinmist.LostInMistMod;

public class LostInMistModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LostInMistMod.MODID);
	public static final RegistryObject<Item> ENTITYINVALID_SPAWN_EGG = REGISTRY.register("entityinvalid_spawn_egg", () -> new ForgeSpawnEggItem(LostInMistModEntities.ENTITYINVALID, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
