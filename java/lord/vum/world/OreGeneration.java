package lord.vum.world;

import java.util.Random;

import lord.vum.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OreGeneration implements IWorldGenerator {
	public static final int ORE_MIN = 8;
	public static final int ORE_MAX = 45;
	public static final int VEIN_SIZE = 10;
	public static final int VEIN_FREQ = 6;
	
	public OreGeneration() {
		GameRegistry.registerWorldGenerator(this, 5);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(!(chunkGenerator instanceof ChunkGeneratorHell) && !(chunkGenerator instanceof ChunkGeneratorEnd)) {
			for(int n=0; n<VEIN_FREQ; n++){
				BlockPos pos = new BlockPos(chunkX*16+random.nextInt(16), random.nextInt(ORE_MAX-ORE_MIN)+ORE_MIN, chunkZ*16+random.nextInt(16));
				new WorldGenMinable(BlockInit.ORE_JADE.getDefaultState(), VEIN_SIZE, BlockMatcher.forBlock(Blocks.STONE)).generate(world, random, pos);
			}
			
		}
		
	}

}
