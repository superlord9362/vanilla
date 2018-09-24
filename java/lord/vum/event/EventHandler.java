package lord.vum.event;

import java.util.Random;

import lord.vum.init.BlockInit;
import lord.vum.world.feature.WorldGenBeaverDam;
import lord.vum.world.feature.WorldGenMuddyLake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	private static final IBlockState WATER = Blocks.WATER.getDefaultState();
	private static final int RIVER_MUD_PER_CHUNK = 2;
	private static final WorldGenSand MUD_FEATURE = new WorldGenSand(BlockInit.MUD, 4);
	private static final WorldGenBeaverDam DAM_FEATURE = new WorldGenBeaverDam(BlockInit.STICK_BLOCK.getDefaultState(), BlockInit.MUD.getDefaultState(), true);
	private static final int DAM_FREQUENCY = 3; //lower numbers = more dams. set this to 0 to crash
	public enum Direction { NE, E, SE, NW, W, SW };
	
	//Replace vanilla lakes with our lakes that contains mud blocks around the edges
	@SubscribeEvent 
	public void onLakeEvent(PopulateChunkEvent.Populate event) {
		if(event.getType() == Populate.EventType.LAKE) {
			event.setResult(Result.DENY);
			Random rand = event.getRand();
			int x = rand.nextInt(16) + 8;
            int y = rand.nextInt(256);
            int z = rand.nextInt(16) + 8;
            BlockPos pos = new BlockPos(event.getChunkX()*16 + x, y, event.getChunkZ()*16 + z);
			(new WorldGenMuddyLake(Blocks.WATER)).generate(event.getWorld(), rand, pos);
		}
	}
	
	//Add muddy blobs to rivers
	@SubscribeEvent
	 public void onBiomeDecorate(DecorateBiomeEvent.Pre event) {
		Random rand = event.getRand();
		World world = event.getWorld();
		for(int n=0; n<RIVER_MUD_PER_CHUNK+2; n++) {
			int x = rand.nextInt(16) + 8;
	        int z = rand.nextInt(16) + 8;
	        BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, 0, event.getChunkPos().getZStart() + z);
			if(world.getBiome(pos) == Biomes.RIVER) {
				MUD_FEATURE.generate(event.getWorld(), event.getRand(), event.getWorld().getTopSolidOrLiquidBlock(pos));
			}
		}
		
		if(rand.nextInt(DAM_FREQUENCY) == 0) {
			//smaller rng range for location to prevent cascading... hopefully 
			int x = rand.nextInt(8) + 12;
	        int z = rand.nextInt(8) + 12;
	        BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, world.getSeaLevel()-1, event.getChunkPos().getZStart() + z);
			if(world.getBiome(pos) == Biomes.RIVER) {
				IBlockState state = world.getBlockState(pos);
				if(state == WATER)
				{
					Direction firstBankDir = null;
					BlockPos firstBankPos = null;
					
					//check east, north east, south east (in that order) from starting location to find first river bank
					for(int riverSearch=1; riverSearch<10; riverSearch++) {
						//check east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.E, riverSearch));
						if(state != WATER) {
							firstBankDir = Direction.E;
							firstBankPos = getDirectionalPos(pos, Direction.E, riverSearch);
							break;
						}
						
						//check north east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.NE, riverSearch));
						if(state != WATER) {
							firstBankDir = Direction.NE;
							firstBankPos = getDirectionalPos(pos, Direction.NE, riverSearch);
							break;
						}
						
						//check south east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.SE, riverSearch));
						if(state != WATER) {
							firstBankDir = Direction.SE;
							firstBankPos = getDirectionalPos(pos, Direction.SE, riverSearch);
							break;
						}
					}
					
					//make sure we actually found a bank before continuing 
					if(firstBankDir != null) {
						Direction secondBankDir = null;
						BlockPos secondBankPos = null;
						Direction dirToTest = null;
						
						switch(firstBankDir) {
							case NE:
								dirToTest = Direction.SW;
								break;
							case E:
								dirToTest = Direction.W;
								break;
							case SE:
								dirToTest = Direction.NW;
								break;
							default:
								//how did you get here
								break;
						}
						
						for(int riverSearch=1; riverSearch<7; riverSearch++) {
							state = world.getBlockState(getDirectionalPos(pos, dirToTest, riverSearch));
							if(state != WATER) {
								secondBankDir = Direction.SE;
								secondBankPos = getDirectionalPos(pos, dirToTest, riverSearch);
								break;
							}
						}
						
						if(secondBankDir != null) {
							
							//check that at least one edge of the dam is touching a forest type biome
							Biome firstBankBiome = world.getBiome(getDirectionalPos(firstBankPos, firstBankDir, 4));
							Biome secondBankBiome = world.getBiome(getDirectionalPos(secondBankPos, secondBankDir, 4));
							if(BiomeDictionary.hasType(firstBankBiome, BiomeDictionary.Type.FOREST) || 
							   BiomeDictionary.hasType(secondBankBiome, BiomeDictionary.Type.FOREST)) {
								
								DAM_FEATURE.generate(world, rand, firstBankPos, secondBankPos, firstBankDir);
								//world.setBlockState(pos.add(0,2,0), Blocks.NETHER_BRICK.getDefaultState());//TODO remove
							}
								
								
	
						}
					}
				}
			}
		}
	}
	
	private BlockPos getDirectionalPos(BlockPos pos, Direction dir, int numBlocksAway) {
		switch (dir) {
			case NE:
				return pos.add(numBlocksAway, 0, -numBlocksAway);
			case E:
				return pos.add(numBlocksAway, 0, 0);
			case SE:
				return pos.add(numBlocksAway, 0, numBlocksAway);
			case NW:
				return pos.add(-numBlocksAway, 0, -numBlocksAway);
			case W:
				return pos.add(-numBlocksAway, 0, 0);
			case SW:
				return pos.add(-numBlocksAway, 0, numBlocksAway);
			default:
				return pos;
		}
				
	}
	
//  public void onBiomeDecorate(DecorateBiomeEvent.Decorate event) {

}
