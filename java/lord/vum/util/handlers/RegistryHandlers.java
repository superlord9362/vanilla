package lord.vum.util.handlers;

import lord.vum.Main;
import lord.vum.entities.EntityGoat;
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
	}
}
