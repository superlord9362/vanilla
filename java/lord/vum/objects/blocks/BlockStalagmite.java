package lord.vum.objects.blocks;

import java.util.Random;

import lord.vum.objects.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStalagmite extends BlockBase {
	public int stalagmitePixels;
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public BlockStalagmite(String name, Material material, int stalagmitePixels) {
		super(name, material);
		this.stalagmitePixels=stalagmitePixels;
		
	}
	@SideOnly(Side.CLIENT)
	@Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
		if(stateIn.getValue(FACING)!=EnumFacing.DOWN) return;
		if(worldIn.rand.nextInt(10)!=0) return;
		
		worldIn.spawnParticle(EnumParticleTypes.DRIP_WATER, pos.getX()+.5, 1-stalagmitePixels/16.0-.05+pos.getY(), pos.getZ()+.5, 0, 0, 0);
    }
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		return this.getDefaultState().withProperty(FACING, facing);
    }
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
