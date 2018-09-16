package lord.vum.tabs;

import lord.vum.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VumTab extends CreativeTabs {

	public VumTab(String label) {
		super("vumtab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (ItemInit.JADE);
	}

}
