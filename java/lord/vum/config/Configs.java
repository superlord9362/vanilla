package lord.vum.config;

import lord.vum.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MODID, category = "")
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Configs {
	
	public static ConfigGeneral general = new ConfigGeneral();
	public static ConfigWorldGen worldgen = new ConfigWorldGen();
	
	public static class ConfigGeneral {
		//hi
	}
	
	public static class ConfigWorldGen {
		
		@Config.Comment({"Jade ore veins per chunk", "Default: 2"})
		@Config.RequiresWorldRestart
		public int jadeVeinFrequency = 2;
		
		@Config.Comment({"Amethyst ore veins per chunk", "Default: 2"})
		@Config.RequiresWorldRestart
		public int amethystVeinFrequency = 2;
		
		@Config.Comment({"Limestone veins per chunk", "Default: 6"})
		@Config.RequiresWorldRestart
		public int limestoneVeinFrequency = 6;
		
		@Config.Comment({"Marble veins per chunk", "Default: 6"})
		@Config.RequiresWorldRestart
		public int marbleVeinFrequency = 6;
		
		@Config.Comment({"River mud per chunk (only spawns in river biomes)", "Default: 4"})
		@Config.RequiresWorldRestart
		public int riverMudFrequency = 4;
		
		@Config.Comment({"Mossy stone per chunk (only spawns in jungle biomes)", "Default: 1"})
		@Config.RequiresWorldRestart
		public int mossyStoneFrequency = 1;
		
		@Config.Comment({"Maximum amount of Stalagmite pairs per chunk", "Default: 9"})
		@Config.RequiresWorldRestart
		public int stalagtiteFrequency = 9;
		
		@Config.Comment({"Maximum height stalagtites can start generating", "Default: 64"})
		@Config.RequiresWorldRestart
		public int stalagtiteMaxHeight = 64;
	}
	
	@SubscribeEvent
	public static void onConfigReload(ConfigChangedEvent.OnConfigChangedEvent event) 
	{
		if (Reference.MODID.equals(event.getModID()))
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
	}
	

}
