package lord.vum.init;

import java.util.ArrayList;
import java.util.List;

import lord.vum.objects.ItemBase;
import lord.vum.objects.armor.ArmorBase;
import lord.vum.objects.tools.ToolAxe;
import lord.vum.objects.tools.ToolHoe;
import lord.vum.objects.tools.ToolPickaxe;
import lord.vum.objects.tools.ToolShovel;
import lord.vum.objects.tools.ToolSword;
import lord.vum.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final ToolMaterial TOOL_JADE = EnumHelper.addToolMaterial("tool_jade", 2, 500, 6.0F, 3.0F, 14);
	public static final ArmorMaterial ARMOR_JADE = EnumHelper.addArmorMaterial("armor_jade", Reference.MODID + ":jade", 15, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
	public static final ToolMaterial TOOL_AMETHYST = EnumHelper.addToolMaterial("tool_amethyst", 3, 550, 7.0F, 3.0F, 14);
	public static final ArmorMaterial ARMOR_AMETHYST = EnumHelper.addArmorMaterial("armor_amethyst", Reference.MODID + ":amethyst", 15, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);

	
	public static final Item JADE = new ItemBase("jade");
	public static final Item AMETHYST = new ItemBase("amethyst");
	public static final Item JADE_INGOT = new ItemBase("jade_stone");
	public static final Item AMETHYST_STONE = new ItemBase("amethyst_stone");
	public static final Item BLUBBER = new ItemBase("blubber");
	
	public static final Item JADE_SWORD = new ToolSword("jade_sword", TOOL_JADE);
	public static final Item JADE_HOE = new ToolHoe("jade_hoe", TOOL_JADE);
	public static final Item JADE_SPADE = new ToolShovel("jade_shovel", TOOL_JADE);
	public static final Item JADE_AXE = new ToolAxe("jade_axe", TOOL_JADE);
	public static final Item JADE_PICKAXE = new ToolPickaxe("jade_pickaxe", TOOL_JADE);
	public static final Item AMETHYST_SWORD = new ToolSword("amethyst_sword", TOOL_AMETHYST);
	public static final Item AMETHYST_HOE = new ToolHoe("amethyst_hoe", TOOL_AMETHYST);
	public static final Item AMETHYST_SPADE = new ToolShovel("amethyst_shovel", TOOL_AMETHYST);
	public static final Item AMETHYST_AXE = new ToolAxe("amethyst_axe", TOOL_AMETHYST);
	public static final Item AMETHYST_PICKAXE = new ToolPickaxe("amethyst_pickaxe", TOOL_AMETHYST);
	
	public static final Item JADE_HELMET = new ArmorBase("jade_helmet", ARMOR_JADE, 1, EntityEquipmentSlot.HEAD);
	public static final Item JADE_CHEST = new ArmorBase("jade_chest", ARMOR_JADE, 1, EntityEquipmentSlot.CHEST);
	public static final Item JADE_LEGS = new ArmorBase("jade_legs", ARMOR_JADE, 2, EntityEquipmentSlot.LEGS);
	public static final Item JADE_BOOTS = new ArmorBase("jade_boots", ARMOR_JADE, 1, EntityEquipmentSlot.FEET);
	public static final Item AMETHYST_HELMET = new ArmorBase("amethyst_helmet", ARMOR_AMETHYST, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMETHYST_CHEST = new ArmorBase("amethyst_chest", ARMOR_AMETHYST, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMETHYST_LEGS = new ArmorBase("amethyst_legs", ARMOR_AMETHYST, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMETHYST_BOOTS = new ArmorBase("amethyst_boots", ARMOR_AMETHYST, 1, EntityEquipmentSlot.FEET);

}
