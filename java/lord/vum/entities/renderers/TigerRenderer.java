package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityPenguin;
import lord.vum.entities.EntityTiger;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelJerboa;
import lord.vum.entities.models.Penguin;
import lord.vum.entities.models.Tiger;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TigerRenderer extends RenderLiving<EntityTiger> {

	public static final Factory FACTORY = new Factory();
	
	public TigerRenderer(RenderManager manager) {
		super(manager, new Tiger(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTiger entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/tiger.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityTiger> {

        @Override
        public Render<? super EntityTiger> createRenderFor(RenderManager manager) {
            return new TigerRenderer(manager);
        }

    }
}
