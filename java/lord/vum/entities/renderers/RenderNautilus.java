package lord.vum.entities.renderers;

import lord.vum.entities.EntityNautilus;
import lord.vum.entities.models.ModelNautilus;
import lord.vum.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
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
	
	
	
	public static class RenderNautilusFactory implements IRenderFactory<EntityNautilus>{

		@Override
		public Render<? super EntityNautilus> createRenderFor(RenderManager manager) {
			return new RenderNautilus(manager, new ModelNautilus(), 1f);
		}
		
	}
}
