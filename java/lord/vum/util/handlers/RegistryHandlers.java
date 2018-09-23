package lord.vum.util.handlers;

import lord.vum.Main;
import lord.vum.entities.EntityBearBlack;
import lord.vum.entities.EntityBearBrown;
import lord.vum.entities.EntityBeaver;
import lord.vum.entities.EntityGiraffe;
import lord.vum.entities.EntityGoat;
import lord.vum.entities.EntityHamster;
import lord.vum.init.BlockInit;
import lord.vum.init.ItemInit;
import lord.vum.util.IHasModel;
import lord.vum.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import lord.vum.entities.EntityJerbos;
import lord.vum.entities.EntityLS;
import lord.vum.entities.EntityNautilus;
import lord.vum.entities.EntityOtter;
import lord.vum.entities.EntityPenguin;
import lord.vum.entities.EntitySeal;
import lord.vum.entities.EntityTiger;
import lord.vum.entities.EntityTurkey;

@EventBusSubscriber
public class RegistryHandlers {

	private static int entityId = 0;
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels(); 
			}
		}
		
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries() {
	}
	
	@SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "goat"), EntityGoat.class, "goat", entityId++, Main.instance, 64, 3, true, 12871971, 10507067);
		EntityRegistry.addSpawn(EntityGoat.class, 60, 3, 5, EnumCreatureType.CREATURE, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.MUTATED_EXTREME_HILLS_WITH_TREES);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "jerboa"), EntityJerbos.class, "jerboa", entityId++, Main.instance, 64, 3, true, 0x5F4023, 0x000000);
		EntityRegistry.addSpawn(EntityJerbos.class, 65, 2, 5, EnumCreatureType.CREATURE, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.MUTATED_DESERT);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "penguin"), EntityPenguin.class, "penguin", entityId++, Main.instance, 64, 3, true, 0x000000, 0xffffff);
		EntityRegistry.addSpawn(EntityPenguin.class, 20, 5, 10, EnumCreatureType.CREATURE, Biomes.ICE_PLAINS);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "hamster"), EntityHamster.class, "hamster", entityId++, Main.instance, 64, 3, true, 0x7F6A00, 0x000000);
		EntityRegistry.addSpawn(EntityHamster.class, 10, 1, 3, EnumCreatureType.AMBIENT, Biomes.PLAINS);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "seal"), EntitySeal.class, "seal", entityId++, Main.instance, 64, 3, true, 0x808080, 0x000000);
		EntityRegistry.addSpawn(EntitySeal.class, 40, 1, 3, EnumCreatureType.AMBIENT, Biomes.BEACH, Biomes.STONE_BEACH);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "leopardseal"), EntityLS.class, "leopardseal", entityId++, Main.instance, 64, 3, true, 0x808080, 0x000000);
		EntityRegistry.addSpawn(EntityLS.class, 40, 1, 3, EnumCreatureType.AMBIENT, Biomes.COLD_BEACH);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"nautilus"), EntityNautilus.class, "nautilus", entityId++, Main.instance, 16, 3, true, 0x808080, 0x808080);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"tiger"), EntityTiger.class, "tiger", entityId++, Main.instance, 16, 3, true, 0x77492F, 0x808080);
		EntityRegistry.addSpawn(EntityTiger.class, 40, 1, 3, EnumCreatureType.AMBIENT, Biomes.JUNGLE);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"blackbear"), EntityBearBlack.class, "blackbear", entityId++, Main.instance, 16, 3, true, 0x352015, 0x000000);
		EntityRegistry.addSpawn(EntityBearBlack.class, 40, 1, 3, EnumCreatureType.CREATURE, Biomes.TAIGA, Biomes.TAIGA_HILLS);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"brownbear"), EntityBearBrown.class, "brownbear", entityId++, Main.instance, 16, 3, true, 0x965A3C, 0x000000);
		EntityRegistry.addSpawn(EntityBearBrown.class, 40, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"beaver"), EntityBeaver.class, "beaver", entityId++, Main.instance, 16, 3, true, 0x682808, 0x000000);
		EntityRegistry.addSpawn(EntityBeaver.class, 40, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"giraffe"), EntityGiraffe.class, "giraffe", entityId++, Main.instance, 16, 3, true, 0x9F4D00, 0x000000);
		EntityRegistry.addSpawn(EntityGiraffe.class, 40, 3, 6, EnumCreatureType.CREATURE, Biomes.SAVANNA);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"otter"), EntityOtter.class, "otter", entityId++, Main.instance, 16, 3, true, 0x493D00, 0x000000);
		EntityRegistry.addSpawn(EntityOtter.class, 74, 1, 3, EnumCreatureType.CREATURE, Biomes.BEACH);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID,"turkey"), EntityTurkey.class, "turkey", entityId++, Main.instance, 16, 3, true, 0xAD0000, 0x000000);
		EntityRegistry.addSpawn(EntityTurkey.class, 74, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST);

	}
}
