package lord.vum.objects;

import lord.vum.init.ItemInit;
import lord.vum.proxy.ClientProxy;
import lord.vum.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import lord.vum.Main;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.vumtab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
