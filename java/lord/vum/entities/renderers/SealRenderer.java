package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntitySeal;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.Seal;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SealRenderer extends RenderLiving<EntitySeal> {

	public static final Factory FACTORY = new Factory();
	
	public SealRenderer(RenderManager manager) {
		super(manager, new Seal(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySeal entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/seal.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntitySeal> {

        @Override
        public Render<? super EntitySeal> createRenderFor(RenderManager manager) {
            return new SealRenderer(manager);
        }

    }
}
