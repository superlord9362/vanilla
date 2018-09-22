package lord.vum.entities.renderers;

import lord.vum.entities.EntityBearBlack;
import lord.vum.entities.EntityGoat;
import lord.vum.entities.models.Bear;
import lord.vum.entities.models.ModelGoat;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BlackBearRenderer extends RenderLiving<EntityBearBlack> {

	public static final Factory FACTORY = new Factory();
	
	public BlackBearRenderer(RenderManager manager) {
		super(manager, new Bear(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBearBlack entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/bear_black.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityBearBlack> {

        @Override
        public Render<? super EntityBearBlack> createRenderFor(RenderManager manager) {
            return new BlackBearRenderer(manager);
        }

    }
}
