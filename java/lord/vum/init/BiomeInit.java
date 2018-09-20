package lord.vum.init;

import lord.vum.world.biomes.TropicalOcean;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	
	public static final Biome TROPICAL_OCEAN = new TropicalOcean();

	public static void registerBiomes() {
		initBiome(TROPICAL_OCEAN, "Tropical Ocean", 5, BiomeType.WARM, Type.OCEAN, Type.WATER, Type.WET);
	}
	
	private static Biome initBiome(Biome biome, String name, int weight, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
