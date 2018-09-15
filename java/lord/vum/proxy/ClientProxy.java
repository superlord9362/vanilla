package lord.vum.proxy;

import lord.vum.enities.renderers.GoatRenderer;
import lord.vum.entities.EntityGoat;
import lord.vum.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	@Override

	public void registerVariantRenderer(Item item, int meta, String filename, String id) 

	{

		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));

	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, new IRenderFactory<EntityGoat>(){public Render<EntityGoat> createRenderFor(RenderManager manager) {return new GoatRenderer();}});
	}
}
