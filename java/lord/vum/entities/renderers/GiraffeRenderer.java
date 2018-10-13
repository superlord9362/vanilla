package lord.vum.entities.renderers;

import lord.vum.entities.EntityBearBrown;
import lord.vum.entities.EntityGiraffe;
import lord.vum.entities.EntityGoat;
import lord.vum.entities.models.Bear;
import lord.vum.entities.models.Giraffe;
import lord.vum.entities.models.ModelGoat;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GiraffeRenderer extends RenderLiving<EntityGiraffe> {

	public static final Factory FACTORY = new Factory();
	
	public GiraffeRenderer(RenderManager manager) {
		super(manager, new Giraffe(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGiraffe entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/giraffe.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityGiraffe> {

        @Override
        public Render<? super EntityGiraffe> createRenderFor(RenderManager manager) {
            return new GiraffeRenderer(manager);
        }

    }
}
