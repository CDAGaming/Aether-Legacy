package com.legacy.aether.client.renders.entities;

import com.legacy.aether.client.models.entities.SunSpiritModel;
import com.legacy.aether.entities.bosses.EntityFireMinion;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class FireMinionRenderer extends RenderBiped<EntityFireMinion>
{

    private static final ResourceLocation SPIRIT = new ResourceLocation("aether_legacy", "textures/bosses/sun_spirit/sun_spirit.png");
    
    private static final ResourceLocation FROZEN_SPIRIT = new ResourceLocation("aether_legacy", "textures/bosses/sun_spirit/frozen_sun_spirit.png");

    public FireMinionRenderer(RenderManager renderManager)
    {
        super(renderManager, new SunSpiritModel(0.0F, 0.0F), 0.4F);
        this.shadowSize = 0.8F;
        
    }

	@Override
    protected ResourceLocation getEntityTexture(EntityFireMinion entity)
    {
		if (entity.hasCustomName() && "JorgeQ".equals(entity.getCustomNameTag()))
		{
			return FROZEN_SPIRIT;
		}
		else
		{
			return SPIRIT;
		}
    }

}