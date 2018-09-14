package lord.vum.init;

import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
	
	private static void registerEntity(String name)
	{
		EntityRegistry.registerModEntity(name, entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
	}

}
