package lord.vum.entities.renderers;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityPenguin;
import lord.vum.entities.EntityTiger;
import lord.vum.entities.EntityTurkey;
import lord.vum.entities.models.ModelGoat;
import lord.vum.entities.models.ModelJerboa;
import lord.vum.entities.models.ModelTurkey;
import lord.vum.entities.models.Penguin;
import lord.vum.entities.models.Tiger;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TurkeyRenderer extends RenderLiving<EntityTurkey> {

	public static final Factory FACTORY = new Factory();
	
	public TurkeyRenderer(RenderManager manager) {
		super(manager, new ModelTurkey(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTurkey entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/turkey.png");
	}
	
	
	public static class Factory implements IRenderFactory<EntityTurkey> {

        @Override
        public Render<? super EntityTurkey> createRenderFor(RenderManager manager) {
            return new TurkeyRenderer(manager);
        }

    }
}
