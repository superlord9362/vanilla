package lord.vum.world.feature;

import java.util.Random;

import com.jcraft.jorbis.Block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpongeLump extends WorldGenerator {
	private final IBlockState block;
    private final int size;
    
    public WorldGenSpongeLump(IBlockState block, int size) {
    	this.block = block;
    	this.size = size;
    }
    
    public boolean generate(World worldIn, Random rand, BlockPos center) {
    	int layer = 0;
    	
    	//generate circular layers, each being 1 or 2 smaller than the layer below
    	for(int layerSize = size; layerSize > 0; layerSize -= rand.nextInt(2)+1) {
    		genLayer(worldIn, rand, center, layerSize, layer);
    		
    		//chance to shift the center location for next layer
    		center = center.add(rand.nextInt(3)-1, 0, rand.nextInt(3)-1); 
    		layer++;
    	}
    	return true;
    }
    
    private void genLayer(World worldIn, Random rand, BlockPos center, int layerSize, int layer) {
    	for(int x=-layerSize; x<=layerSize; x++){
    		for(int z=-layerSize; z<=layerSize; z++) {
    			BlockPos pos = center.add(x, layer, z);
    			double dist = Math.sqrt(x*x + z*z);
    			if(dist > layerSize) 
    				continue;
    			
    			//blocks further from the center have a higher chance of not generating
    			int genChance = (int) (90 - 10*dist);
    			IBlockState toReplace = worldIn.getBlockState(pos);
    			if(toReplace == Blocks.WATER.getDefaultState() && rand.nextInt(100)<genChance) {
    				worldIn.setBlockState(pos, block, 4);
    			}
    		}
    	}
    }

}
