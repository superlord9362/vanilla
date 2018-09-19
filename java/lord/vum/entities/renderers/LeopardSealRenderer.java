package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityLS;
import lord.vum.entities.models.LeopardSeal;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelJerboa;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class LeopardSealRenderer extends RenderLiving<EntityLS> {

	public static final Factory FACTORY = new Factory();
	
	public LeopardSealRenderer(RenderManager manager) {
		super(manager, new LeopardSeal(0), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLS entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/leopardseal.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityLS> {

        @Override
        public Render<? super EntityLS> createRenderFor(RenderManager manager) {
            return new LeopardSealRenderer(manager);
        }

    }
}
