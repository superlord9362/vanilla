package lord.vum.entities.renderers;

import lord.vum.entities.EntityNautilus;
import lord.vum.entities.models.ModelNautilus;
import lord.vum.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNautilus extends RenderLiving<EntityNautilus>{

	public static final IRenderFactory<EntityNautilus> FACTORY = new RenderNautilusFactory();
	
	
	public RenderNautilus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, .09f);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNautilus entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation(Reference.MODID,"textures/entities/nautilus.png");
	}
	
	@Override
    protected void applyRotations(EntityNautilus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
		GlStateManager.rotate(180f-rotationYaw,0,1f,0);
		GlStateManager.rotate(entityLiving.rotationPitch,1f,0,0);
		if(entityLiving.isInWater()) return;
		GlStateManager.rotate(90f,0,0,1f);
		GlStateManager.translate(0, -.2, 0);
    }
	
	@Override
    protected float handleRotationFloat(EntityNautilus livingBase, float partialTicks)
    {
        return livingBase.tentacleAngle;
    }

	public static class RenderNautilusFactory implements IRenderFactory<EntityNautilus>{

		@Override
		public Render<? super EntityNautilus> createRenderFor(RenderManager manager) {
			return new RenderNautilus(manager, new ModelNautilus(), 1f);
		}
		
	}
}
