package lord.vum;

import lord.vum.proxy.CommonProxy;
import lord.vum.tabs.VumTab;
import lord.vum.util.Reference;
import lord.vum.util.handlers.RegistryHandlers;
import lord.vum.world.OreGeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import lord.vum.util.handlers.*;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static final CreativeTabs vumtab = new VumTab("vumtab");
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {}
	@EventHandler

	public static void init(FMLInitializationEvent event) {

		new OreGeneration();
		RegistryHandlers.initRegistries();

	}
	 @EventHandler
	 public static void postInit(FMLPostInitializationEvent event) {RegistryHandlers.postInitRegistries();}
	
}