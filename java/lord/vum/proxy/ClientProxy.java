package lord.vum.proxy;

import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityHamster;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityLS;
import lord.vum.entities.EntityPenguin;
import lord.vum.entities.EntitySeal;
import lord.vum.entities.models.LeopardSeal;
import lord.vum.entities.renderers.GoatRenderer;
import lord.vum.entities.renderers.HamsterRenderer;
import lord.vum.entities.renderers.JerboaRenderer;
import lord.vum.entities.renderers.LeopardSealRenderer;
import lord.vum.entities.renderers.PenguinRenderer;
import lord.vum.entities.renderers.SealRenderer;
import lord.vum.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
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
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, GoatRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityJerbos.class, JerboaRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, PenguinRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityHamster.class, HamsterRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntitySeal.class, SealRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityLS.class, LeopardSealRenderer.FACTORY);

	}
}
