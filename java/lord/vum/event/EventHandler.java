package lord.vum.event;

import java.util.Random;

import lord.vum.config.Configs;
import lord.vum.init.BlockInit;
import lord.vum.objects.blocks.BlockStalagmite;
import lord.vum.world.feature.WorldGenBeaverDam;
import lord.vum.world.feature.WorldGenMuddyLake;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	private static final IBlockState WATER = Blocks.WATER.getDefaultState();
	private static final int RIVER_MUD_PER_CHUNK;
	private static final WorldGenSand MUD_FEATURE = new WorldGenSand(BlockInit.MUD, 4);
	private static final int MOSSY_STONE_PER_CHUNK;
	private static final WorldGenBlockBlob MOSSY_FEATURE = new WorldGenBlockBlob(BlockInit.MOSS_STONE, 2);
	private static final WorldGenBeaverDam DAM_FEATURE = new WorldGenBeaverDam(BlockInit.STICK_BLOCK.getDefaultState(), BlockInit.MUD.getDefaultState(), true);
	private static final int DAM_FREQUENCY = 3; //lower numbers = more dams. set this to 0 to crash
	private static final int STALAGTITE_FREQUENCY = 9;
	private static final int STALAGTITE_MAX_HEIGHT=64;
	public enum Direction { NE, E, SE, NW, W, SW };
	
	static {
		RIVER_MUD_PER_CHUNK = Configs.worldgen.riverMudFrequency;
		MOSSY_STONE_PER_CHUNK = Configs.worldgen.mossyStoneFrequency;
		STALAGTITE_FREQUENCY = Configs.worldgen.stalagtiteFrequency;
		STALAGTITE_MAX_HEIGHT=Configs.worldgen.stalagtiteMaxHeight;
	}
	
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
	
	
	@SubscribeEvent
	public void onBiomeDecoratePre(DecorateBiomeEvent.Pre event) {
		Random rand = event.getRand();
		World world = event.getWorld();

		// Add muddy blobs to rivers
		for (int n = 0; n < RIVER_MUD_PER_CHUNK; n++) {
			int x = rand.nextInt(16) + 8;
			int z = rand.nextInt(16) + 8;
			BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, 0, event.getChunkPos().getZStart() + z);
			if (world.getBiome(pos) == Biomes.RIVER) {
				MUD_FEATURE.generate(event.getWorld(), event.getRand(), event.getWorld().getTopSolidOrLiquidBlock(pos));
			}
		}

		// add dams to rivers
		if (rand.nextInt(DAM_FREQUENCY) == 0) {
			// smaller rng range for location to prevent cascading... hopefully
			int x = rand.nextInt(8) + 12;
			int z = rand.nextInt(8) + 12;
			BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, world.getSeaLevel() - 1, event.getChunkPos().getZStart() + z);
			if (world.getBiome(pos) == Biomes.RIVER) {
				IBlockState state = world.getBlockState(pos);
				if (state == WATER) {
					Direction firstBankDir = null;
					BlockPos firstBankPos = null;

					// check east, north east, south east (in that order) from starting location to
					// find first river bank
					for (int riverSearch = 1; riverSearch < 10; riverSearch++) {
						// check east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.E, riverSearch));
						if (state != WATER) {
							firstBankDir = Direction.E;
							firstBankPos = getDirectionalPos(pos, Direction.E, riverSearch);
							break;
						}

						// check north east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.NE, riverSearch));
						if (state != WATER) {
							firstBankDir = Direction.NE;
							firstBankPos = getDirectionalPos(pos, Direction.NE, riverSearch);
							break;
						}

						// check south east block
						state = world.getBlockState(getDirectionalPos(pos, Direction.SE, riverSearch));
						if (state != WATER) {
							firstBankDir = Direction.SE;
							firstBankPos = getDirectionalPos(pos, Direction.SE, riverSearch);
							break;
						}
					}

					// make sure we actually found a bank before continuing
					if (firstBankDir != null) {
						Direction secondBankDir = null;
						BlockPos secondBankPos = null;
						Direction dirToTest = null;

						switch (firstBankDir) {
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
								// how did you get here
								break;
						}

						for (int riverSearch = 1; riverSearch < 7; riverSearch++) {
							state = world.getBlockState(getDirectionalPos(pos, dirToTest, riverSearch));
							if (state != WATER) {
								secondBankDir = dirToTest;
								secondBankPos = getDirectionalPos(pos, dirToTest, riverSearch);
								break;
							}
						}

						if (secondBankDir != null) {

							// check that at least one edge of the dam is touching a forest type biome
							Biome firstBankBiome = world.getBiome(getDirectionalPos(firstBankPos, firstBankDir, 4));
							Biome secondBankBiome = world.getBiome(getDirectionalPos(secondBankPos, secondBankDir, 4));
							if (BiomeDictionary.hasType(firstBankBiome, BiomeDictionary.Type.FOREST)
									|| BiomeDictionary.hasType(secondBankBiome, BiomeDictionary.Type.FOREST)) {

								DAM_FEATURE.generate(world, rand, firstBankPos, secondBankPos, firstBankDir);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBiomeDecoratePost(DecorateBiomeEvent.Post event) {
		Random rand = event.getRand();
		World world = event.getWorld();

		// Add mossy stone blobs to jungle biome
		for (int n = 0; n < MOSSY_STONE_PER_CHUNK; n++) {
			int x = rand.nextInt(8) + 12;
			int z = rand.nextInt(8) + 12;
			BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, 0, event.getChunkPos().getZStart() + z);
			if (world.getBiome(pos) == Biomes.JUNGLE) {
				pos = pos.add(0, rand.nextInt(event.getWorld().getTopSolidOrLiquidBlock(pos).getY() - 10) + 5, 0);
				MOSSY_FEATURE.generate(event.getWorld(), event.getRand(), pos);
			}
		}

		// Try adding stalagmite stalagtite pairs to caves
		for (int n = 0;n<STALAGTITE_FREQUENCY;n++) {
			//if(rand.nextBoolean()) continue;
			int x = rand.nextInt(16)+8;
			int z = rand.nextInt(16)+8;
			BlockPos pos = new BlockPos(event.getChunkPos().getXStart()+x,STALAGTITE_MAX_HEIGHT,event.getChunkPos().getZStart()+z);
			IBlockState down = BlockInit.STONE_STALAGMITE_TALL.getDefaultState().withProperty(BlockStalagmite.FACING,EnumFacing.DOWN); 
			IBlockState up = BlockInit.STONE_STALAGMITE_SHORT.getDefaultState().withProperty(BlockStalagmite.FACING,EnumFacing.UP); 
			BlockPos firstPosition = null;
			BlockPos secondPosition=null;
			boolean shouldPlaceSmall = false;
			while(pos.getY()>0) {
				IBlockState lastBlock = world.getBlockState(pos);
				pos=pos.offset(EnumFacing.DOWN);
				
				if(world.getBlockState(pos).getBlock()!=Blocks.AIR) continue;
				if(!shouldPlaceSmall) {
					if(lastBlock.getBlock()==Blocks.STONE) {
						shouldPlaceSmall = true;
						firstPosition = pos;
					}
				}
				else {
					BlockPos nextPos = pos.offset(EnumFacing.DOWN);
					lastBlock = world.getBlockState(nextPos);
					if(lastBlock.getBlock()!=Blocks.AIR) {
						secondPosition = pos;
						break;
					}
				}
			}
			if(firstPosition==null) return;
			world.setBlockState(firstPosition, down);
			if(secondPosition==null) return;
			if(firstPosition.getY()-secondPosition.getY()<3) return;
			world.setBlockState(secondPosition, up);
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
}
