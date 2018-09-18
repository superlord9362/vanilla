package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityHamster;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelHamster;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class HamsterRenderer extends RenderLiving<EntityHamster> {

	public static final Factory FACTORY = new Factory();
	
	public HamsterRenderer(RenderManager manager) {
		super(manager, new ModelHamster(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityHamster entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/hamster.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityHamster> {

        @Override
        public Render<? super EntityHamster> createRenderFor(RenderManager manager) {
            return new HamsterRenderer(manager);
        }

    }
}
