package lord.vum.proxy;

import lord.vum.init.BiomeInit;
import lord.vum.world.OreGeneration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	public void preInit(FMLPreInitializationEvent event) {}
	
	public void init(FMLInitializationEvent event) {
		new OreGeneration();
		BiomeInit.registerBiomes();
	}
}
