package lord.vum.objects.blocks;

import java.util.Random;

import lord.vum.Main;
import lord.vum.init.BlockInit;
import lord.vum.init.ItemInit;
import lord.vum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MossyStone extends Block implements IHasModel{

	
	public MossyStone(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.vumTab);
		this.setHardness(10);
		this.setResistance(10);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == BlockInit.MOSS_STONE ? Item.getItemFromBlock(Blocks.MOSSY_COBBLESTONE) : Item.getItemFromBlock(BlockInit.MOSS_STONE);
    }

}