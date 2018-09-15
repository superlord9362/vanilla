package lord.vum.objects.armor;

import lord.vum.Main;
import lord.vum.init.ItemInit;
import lord.vum.tabs.VumTab;
import lord.vum.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item.ToolMaterial;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(material, renderIndexIn, equipmentSlotIn);
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
