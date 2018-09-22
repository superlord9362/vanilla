package lord.vum.world.feature;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import lord.vum.event.EventHandler.Direction;

public class WorldGenBeaverDam {
	
	public WorldGenBeaverDam() {
		
	}
	
	public boolean generate(World worldIn, Random rand, BlockPos start, BlockPos end, Direction dir) {
		short[][][] damMap = genDamMap(dir, rand);
		
		//do one pass of the mock game of life to smooth out rough edges
		damMap[0] = cellStep(damMap);
		
		//make 3 more layers above base
		for(int n=1; n<=3; n++) {
			damMap[n] = layerStep(damMap, rand, n);
		}
		
		BlockPos center = new BlockPos((start.getX()+end.getX())/2, (start.getY()+end.getY())/2, (start.getZ()+end.getZ())/2);
		for(int x=0; x<25; x++) {
			for(int z=0; z<25; z++) {
				for(int y=0; y<=3; y++) {
					if(damMap[y][x][z] == 1) {
						worldIn.setBlockState(center.add(x-12, y, z-12), Blocks.DIAMOND_BLOCK.getDefaultState()); //TODO actually check what block we're overriding
					}
				}
			}
		}
		return true;
	}
	
	//makes the base map with '1' values in a rectangle with rough edges facing the direction of dir
	private short[][][] genDamMap(Direction dir, Random rand) { //TODO add dist
		short[][][] damMap = new short[10][25][25];
		
		if(dir == Direction.E) {
			for(int z=9; z<16; z++) {
				for(int x=5; x<20; x++) {
					if((z <= 10 || z >= 14) && rand.nextInt(100) < 50)
						continue;
					
					damMap[0][x][z] = 1;
				}
			}
		}
		else {
			for(int z=8; z<17; z++) {
				for(int x=5; x<20; x++) {
					if((z <= 9 || z >= 15) && rand.nextInt(100) < 50)
						continue;
					
					if(dir == Direction.NE) 
						damMap[0][x][z-x+12] = 1;
					else if(dir == Direction.SE)
						damMap[0][x][z+x-12] = 1;
				}
			}
		}
		return damMap;
	}
	
	private short[][] cellStep(short[][][] inMap) { 
		short[][] outMap = new short[25][25];
		for(int x=0; x<25; x++) {
			for(int z=0; z<25; z++) {
				//for y
				if(countFriends(inMap, x, 0, z) >= 4)
					outMap[x][z] = 1;
			}
		}
		
		return outMap;
	}
	
	//counts the number of '1' values in surrounding 8 positions in array on same y level
	private int countFriends(short[][][] map, int x, int y, int z) {
		int friends = 0;
		for(int xdif=-1; xdif<=1; xdif++) {
			for(int zdif=-1; zdif<=1; zdif++) {
				if(!(xdif == 0 && zdif == 0)) {//dont count the origin cell
					int x2 = x + xdif;
					int z2 = z + zdif;
					//make sure we dont go out of bounds
					if(x2 > 0 && z2 > 0 && x2 < 25 && z2 < 25) {
						if(map[y][x2][z2] == 1)
							friends++;
					}
				}	
			}
		}
		return friends;
	}
	
	//generates a new layer based on blocks below current layer
	private short[][] layerStep(short[][][] map, Random rand, int yLevel) {
		short[][] outMap = new short[25][25];
		for(int x=0; x<25; x++) {
			for(int z=0; z<25; z++) {
				if(map[yLevel-1][x][z] == 1) {
					int friends = countFriends(map, x, yLevel-1, z);
					if(friends > 5) {
						outMap[x][z] = 1;
					}
					else if(friends == 5 && rand.nextInt(100)>50) {
						outMap[x][z] = 1;
					}
				}
			}
		}
		
		return outMap;
	}
}
