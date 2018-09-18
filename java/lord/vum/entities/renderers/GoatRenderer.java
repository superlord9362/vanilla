package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.models.ModelGoat;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GoatRenderer extends RenderLiving<EntityGoat> {

	public static final Factory FACTORY = new Factory();
	
	public GoatRenderer(RenderManager manager) {
		super(manager, new ModelGoat(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGoat entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/goat.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityGoat> {

        @Override
        public Render<? super EntityGoat> createRenderFor(RenderManager manager) {
            return new GoatRenderer(manager);
        }

    }
}
