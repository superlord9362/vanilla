package lord.vum.enities.renderers;

import lord.vum.enities.models.ModelGoat;
import lord.vum.entities.EntityGoat;
import lord.vum.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class GoatRenderer extends RenderLiving<EntityGoat> {

	public GoatRenderer() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelGoat(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGoat entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/goat.png");
	}
}
