package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityOtter;
import lord.vum.entities.EntityPenguin;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelJerboa;
import lord.vum.entities.models.ModelOtter;
import lord.vum.entities.models.Penguin;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class OtterRenderer extends RenderLiving<EntityOtter> {

	public static final Factory FACTORY = new Factory();
	
	public OtterRenderer(RenderManager manager) {
		super(manager, new ModelOtter(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOtter entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/otter.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityOtter> {

        @Override
        public Render<? super EntityOtter> createRenderFor(RenderManager manager) {
            return new OtterRenderer(manager);
        }

    }
}
