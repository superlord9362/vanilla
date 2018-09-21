package lord.vum.event;

import java.util.Random;

import lord.vum.init.BlockInit;
import lord.vum.util.GeneratorUtils;
import lord.vum.world.feature.WorldGenMuddyLake;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;

public class EventHandler {
	private static final int RIVER_MUD_PER_CHUNK = 2;
	//private static final WorldGenBlockBlob MUD_FEATURE = new WorldGenBlockBlob(BlockInit.MUD, 2);
	private static final WorldGenSand MUD_FEATURE = new WorldGenSand(BlockInit.MUD, 4);
	
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
//    public void onBiomeDecorate(DecorateBiomeEvent.Decorate event) {
	 public void onBiomeDecorate(DecorateBiomeEvent.Pre event) {
		for(int n=0; n<RIVER_MUD_PER_CHUNK+2; n++) {
			Random rand = event.getRand();
			int x = rand.nextInt(16) + 8;
	        int z = rand.nextInt(16) + 8;
	        BlockPos pos = new BlockPos(event.getChunkPos().getXStart() + x, 0, event.getChunkPos().getZStart() + z);
			if(event.getWorld().getBiome(pos) == Biomes.RIVER) {
				
				System.out.println(event.getChunkPos().getXStart());
				System.out.println(event.getWorld().getTopSolidOrLiquidBlock(pos));
				//pos = pos.add(0, GeneratorUtils.getOceanSurfaceHeight(event.getWorld(), pos.getX(), pos.getZ()), 0);
				//pos = pos.add(0, event.getWorld().getSeaLevel()-1, 0);
				MUD_FEATURE.generate(event.getWorld(), event.getRand(), event.getWorld().getTopSolidOrLiquidBlock(pos));
			}
		}
	}

}
