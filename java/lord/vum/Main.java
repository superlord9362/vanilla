package lord.vum;

import lord.vum.entities.EntityGoat;
import lord.vum.proxy.CommonProxy;
import lord.vum.tabs.VumTab;
import lord.vum.util.Reference;
import lord.vum.util.handlers.RegistryHandlers;
import lord.vum.world.OreGeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static final CreativeTabs vumtab = new VumTab("vumtab");
	
	private static int entityId = 0;
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "goat"), EntityGoat.class, "goat", entityId++, instance, 64, 3, true, 12871971, 10507067);
	}
	@EventHandler

	public static void init(FMLInitializationEvent event) {

		new OreGeneration();
		RegistryHandlers.initRegistries();

	}
	 @EventHandler
	 public static void postInit(FMLPostInitializationEvent event) {RegistryHandlers.postInitRegistries();}
	
}