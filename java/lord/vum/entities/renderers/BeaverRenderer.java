package lord.vum.entities.renderers;

import lord.vum.entities.EntityBearBlack;
import lord.vum.entities.EntityBeaver;
import lord.vum.entities.EntityGoat;
import lord.vum.entities.models.Bear;
import lord.vum.entities.models.Beaver;
import lord.vum.entities.models.ModelGoat;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BeaverRenderer extends RenderLiving<EntityBeaver> {

	public static final Factory FACTORY = new Factory();
	
	public BeaverRenderer(RenderManager manager) {
		super(manager, new Beaver(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBeaver entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/beaver.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityBeaver> {

        @Override
        public Render<? super EntityBeaver> createRenderFor(RenderManager manager) {
            return new BeaverRenderer(manager);
        }

    }
}
