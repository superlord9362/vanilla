package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelJerboa;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class JerboaRenderer extends RenderLiving<EntityJerbos> {

	public static final Factory FACTORY = new Factory();
	
	public JerboaRenderer(RenderManager manager) {
		super(manager, new ModelJerboa(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityJerbos entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/jerboa.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityJerbos> {

        @Override
        public Render<? super EntityJerbos> createRenderFor(RenderManager manager) {
            return new JerboaRenderer(manager);
        }

    }
}
