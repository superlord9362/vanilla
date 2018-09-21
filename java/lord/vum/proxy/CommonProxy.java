package lord.vum.proxy;

import lord.vum.event.EventHandler;
import lord.vum.init.BiomeInit;
import lord.vum.world.OreGeneration;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	
	public void preInit(FMLPreInitializationEvent event) {
		EventHandler events = new EventHandler();
		MinecraftForge.EVENT_BUS.register(events);
		MinecraftForge.TERRAIN_GEN_BUS.register(events);
	}
	
	public void init(FMLInitializationEvent event) {
		new OreGeneration();
		BiomeInit.registerBiomes();
	}
}
