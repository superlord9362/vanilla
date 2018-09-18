package lord.vum.init;

import java.util.ArrayList;
import java.util.List;

import lord.vum.objects.blocks.AmethystOre;
import lord.vum.objects.blocks.BlockBase;
import lord.vum.objects.blocks.JadeOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORE_JADE = new JadeOre("ore_jade", Material.ROCK);
	public static final Block ORE_AMETHYST = new AmethystOre("ore_amethyst", Material.ROCK);
	public static final Block PILLAR_ANDESITE = new BlockBase("pillar_andesite", Material.ROCK);
	public static final Block PILLAR_DIORITE = new BlockBase("pillar_diorite", Material.ROCK);
	public static final Block PILLAR_GRANITE = new BlockBase("pillar_granite", Material.ROCK);
	public static final Block AMETHYST_BLOCK = new BlockBase("amethyst_block", Material.ROCK);
	public static final Block ANDESITE_BRICKS = new BlockBase("andesite_bricks", Material.ROCK);
	public static final Block DIORITE_BRICKS = new BlockBase("diorite_bricks", Material.ROCK);
	public static final Block GRANITE_BRICKS = new BlockBase("granite_bricks", Material.ROCK);
	public static final Block JADE_BLOCK = new BlockBase("jade_block", Material.ROCK);
	public static final Block STRIPPED_ACACIA = new BlockBase("stripped_acacia", Material.WOOD);
	public static final Block STRIPPED_BIRCH = new BlockBase("stripped_birch", Material.WOOD);
	public static final Block STRIPPED_DARK_OAK = new BlockBase("stripped_dark_oak", Material.WOOD);
	public static final Block STRIPPED_JUNGLE = new BlockBase("stripped_jungle", Material.WOOD);
	public static final Block STRIPPED_OAK = new BlockBase("stripped_oak", Material.WOOD);
	public static final Block STRIPPED_SPRUCE = new BlockBase("stripped_spruce", Material.WOOD);
	public static final Block LIMESTONE = new BlockBase("limestone", Material.ROCK);
	public static final Block LIMESTONE_BRICKS = new BlockBase("limestone_bricks", Material.ROCK);
	public static final Block LIMESTONE_PILLAR = new BlockBase("limestone_pillar", Material.ROCK);
	public static final Block LIMESTONE_SMOOTH = new BlockBase("limestone_smooth", Material.ROCK);
	public static final Block MARBLE = new BlockBase("marble", Material.ROCK);
	public static final Block MARBLE_SMOOTH = new BlockBase("marble_smooth", Material.ROCK);
	public static final Block MARBLE_BRICKS = new BlockBase("marble_bricks", Material.ROCK);
	public static final Block MARBLE_PILLAR = new BlockBase("marble_pillar", Material.ROCK);
	public static final Block ANDESTITE_SLAB = new BlockBase("andestite_slab", Material.ROCK);
	public static final Block DIORITE_SLAB = new BlockBase("andestite_slab", Material.ROCK);
	public static final Block GRANITE_SLAB = new BlockBase("granite_slab", Material.ROCK);
	public static final Block LIMESTONE_SLAB = new BlockBase("limestone_slab", Material.ROCK);
	public static final Block MARBLE_SLAB = new BlockBase("marble_slab", Material.ROCK);
	public static final Block ANDESTITE_STAIRS = new BlockBase("andestite_stairs", Material.ROCK);
	public static final Block DIORITE_STAIRS = new BlockBase("andestite_stairs", Material.ROCK);
	public static final Block GRANITE_STAIRS = new BlockBase("granite_stairs", Material.ROCK);
	public static final Block LIMESTONE_STAIRS = new BlockBase("limestone_stairs", Material.ROCK);
	public static final Block MARBLE_STAIRS = new BlockBase("marble_stairs", Material.ROCK);
	public static final Block BRICK_WALL = new BlockBase("brick_wall", Material.ROCK);
	public static final Block SANDSTONE_WALL = new BlockBase("sandstone_wall", Material.ROCK);
	public static final Block PRISMARINE_WALL = new BlockBase("prismarine_wall", Material.ROCK);
}
