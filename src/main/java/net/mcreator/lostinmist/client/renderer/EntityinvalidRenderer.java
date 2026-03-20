
package net.mcreator.lostinmist.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.lostinmist.entity.EntityinvalidEntity;

public class EntityinvalidRenderer extends HumanoidMobRenderer<EntityinvalidEntity, HumanoidModel<EntityinvalidEntity>> {
	public EntityinvalidRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<EntityinvalidEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(EntityinvalidEntity entity) {
		return new ResourceLocation("lost_in_mist:textures/entities/98edaccf5b96bc974fe6a48b2845058a2ed5fd14.png");
	}
}
