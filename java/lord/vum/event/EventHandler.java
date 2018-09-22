package lord.vum.event;

import java.util.Random;

import lord.vum.init.BlockInit;
import lord.vum.util.GeneratorUtils;
import lord.vum.world.feature.WorldGenBeaverDam;
import lord.vum.world.feature.WorldGenMuddyLake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;

public class EventHandler {
	private static final IBlockState WATER = Blocks.WATER.getDefaultState();
	private static final int RIVER_MUD_PER_CHUNK = 2;
	private static final WorldGenSand MUD_FEATURE = new WorldGenSand(BlockInit.MUD, 4);
	private static final WorldGenBeaverDam DAM_FEATURE = new WorldGenBeaverDam();
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
		
		for(int m=0; m<1; m++) {
			int x = rand.nextInt(16) + 8;
	        int z = rand.nextInt(16) + 8;
	        BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, world.getSeaLevel()-1, event.getChunkPos().getZStart() + z);
			if(world.getBiome(pos) == Biomes.RIVER) {
				IBlockState state = world.getBlockState(pos);
				if(state != WATER)
					break;
				
				Direction firstBank = null;
				BlockPos firstBankPos = null;
				
				//check east, north east, south east (in that order) from starting location to find first river bank
				for(int riverSearch=1; riverSearch<10; riverSearch++) {
					//check east block
					state = world.getBlockState(getDirectionalPos(pos, Direction.E, riverSearch));
					if(state != WATER) {
						firstBank = Direction.E;
						firstBankPos = getDirectionalPos(pos, Direction.E, riverSearch);
						break;
					}
					
					//check north east block
					state = world.getBlockState(getDirectionalPos(pos, Direction.NE, riverSearch));
					if(state != WATER) {
						firstBank = Direction.NE;
						firstBankPos = getDirectionalPos(pos, Direction.NE, riverSearch);
						break;
					}
					
					//check south east block
					state = world.getBlockState(getDirectionalPos(pos, Direction.SE, riverSearch));
					if(state != WATER) {
						firstBank = Direction.SE;
						firstBankPos = getDirectionalPos(pos, Direction.SE, riverSearch);
						break;
					}
				}
				
				//make sure we actually found a bank before continuing 
				if(firstBank != null) {
					world.setBlockState(pos.add(0,2,0), Blocks.WOOL.getDefaultState()); //TODO remove
					Direction secondBank = null;
					BlockPos secondBankPos = null;
					Direction dirToTest = null;
					
					switch(firstBank) {
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
							secondBank = Direction.SE;
							secondBankPos = getDirectionalPos(pos, dirToTest, riverSearch);
							break;
						}
					}
					
					if(secondBank != null) {
						//ayyy we found two sides to a river
//						for (BlockPos pixel : GeneratorUtils.getBresehnamArrays(firstBankPos.add(0,1,0), secondBankPos.add(0,1,0))) {
//							world.setBlockState(pixel, Blocks.NETHER_BRICK.getDefaultState());
//						}
						DAM_FEATURE.generate(world, rand, firstBankPos, secondBankPos, firstBank);
						world.setBlockState(pos.add(0,2,0), Blocks.NETHER_BRICK.getDefaultState());
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
