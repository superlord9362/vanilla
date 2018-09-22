package lord.vum.entities.renderers;

import lord.vum.entities.EntityBearBrown;
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

public class BrownBearRenderer extends RenderLiving<EntityBearBrown> {

	public static final Factory FACTORY = new Factory();
	
	public BrownBearRenderer(RenderManager manager) {
		super(manager, new Bear(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBearBrown entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/bear_brown.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityBearBrown> {

        @Override
        public Render<? super EntityBearBrown> createRenderFor(RenderManager manager) {
            return new BrownBearRenderer(manager);
        }

    }
}
