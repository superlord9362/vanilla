package lord.vum.world.biomes;

import java.util.Random;

import lord.vum.world.feature.WorldGenSpongeLump;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class TropicalOcean extends Biome{
	
	public static BiomeProperties properties = new BiomeProperties("Tropical Ocean");
	public static int spongeChance = 10; //lower number = more sponges
	private static final WorldGenSpongeLump SPONGE_FEATURE = new WorldGenSpongeLump(Blocks.SPONGE.getStateFromMeta(1), 4);
	private static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	static {
		properties.setBaseHeight(-0.8F);
		properties.setHeightVariation(0.08F);
		properties.setWaterColor(2289390);
	}
	
	public TropicalOcean() {
		super(properties);
		this.spawnableCreatureList.clear();
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);
        if(rand.nextInt(spongeChance) == 0)
        {
	        int x = rand.nextInt(16) + pos.getX();
	        int z = rand.nextInt(16) + pos.getZ();
	        int y = getOceanSurface(worldIn, x, z);
	        BlockPos genLocation = new BlockPos(x, y, z);
	        
	        SPONGE_FEATURE.generate(worldIn, rand, genLocation);
        }
        
	}
	
	public int getOceanSurface(World worldIn, int x, int z) {
		int y = worldIn.getSeaLevel();
		IBlockState blocky;
		do {
			y--;
			blocky = worldIn.getBlockState(new BlockPos(x, y, z));
		} while(blocky == WATER && y > 0);
		
		return y+1;	
	}

}
