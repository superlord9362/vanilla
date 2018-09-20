package lord.vum.world.biomes;

import java.util.Random;

import lord.vum.util.GeneratorUtils;
import lord.vum.world.feature.WorldGenCoralLump;
import lord.vum.world.feature.WorldGenCoralTree;
import lord.vum.world.feature.WorldGenSpongeLump;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class TropicalOcean extends Biome{
	
	public static BiomeProperties properties = new BiomeProperties("Tropical Ocean");
	public static int spongeChance = 10; //lower number = more sponges
	public static int coralBoxChance = 5; //lower numbers = more coral boxes
	public static int coralTreeChance = 3; //lower numbers = more coral trees
	public static int coralTreeClusterSize = 3; //higher numbers = more coral trees per cluster
	private static final WorldGenSpongeLump SPONGE_FEATURE = new WorldGenSpongeLump(Blocks.SPONGE.getStateFromMeta(1), 4);
	private static final WorldGenCoralLump CORAL_BOX_FEATURE = new WorldGenCoralLump(6);
	private static final WorldGenCoralTree CORAL_TREE_FEATURE = new WorldGenCoralTree(10);
	
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
        
        if(rand.nextInt(spongeChance) == 0) {
	        int x = rand.nextInt(16) + 8 + pos.getX();
	        int z = rand.nextInt(16) + 8 + pos.getZ();
	        int y = GeneratorUtils.getOceanSurfaceHeight(worldIn, x, z);
	        BlockPos genLocation = new BlockPos(x, y, z);
	        
	        SPONGE_FEATURE.generate(worldIn, rand, genLocation);
        }
        
        if(rand.nextInt(coralBoxChance) == 0) {
        	int x = rand.nextInt(16) + 8 + pos.getX();
	        int z = rand.nextInt(16) + 8 + pos.getZ();
	        int y = GeneratorUtils.getOceanSurfaceHeight(worldIn, x, z);
	        BlockPos genLocation = new BlockPos(x, y, z);
	        
	        CORAL_BOX_FEATURE.generate(worldIn, rand, genLocation);
        }
        
        if(rand.nextInt(coralTreeChance) == 0) {
        	//generate multiple trees to give a more clustered coral look
        	for(int n=0; n<coralTreeClusterSize; n++) {
		    	int x = rand.nextInt(16) + 8 + pos.getX();
		        int z = rand.nextInt(16) + 8 + pos.getZ();
		        int y = GeneratorUtils.getOceanSurfaceHeight(worldIn, x, z);
		        BlockPos genLocation = new BlockPos(x, y, z);
		     
		        CORAL_TREE_FEATURE.generate(worldIn, rand, genLocation);
        	}
        }
        
	}
}
