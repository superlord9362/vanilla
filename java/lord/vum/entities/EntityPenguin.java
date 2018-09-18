package lord.vum.entities;



import com.google.common.collect.Sets;

import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.block.Block;

import net.minecraft.entity.Entity;

import net.minecraft.entity.EntityAgeable;

import net.minecraft.entity.EntityLiving;

import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.SharedMonsterAttributes;

import net.minecraft.entity.ai.EntityAIAvoidEntity;

import net.minecraft.entity.ai.EntityAIFollowParent;

import net.minecraft.entity.ai.EntityAILookIdle;

import net.minecraft.entity.ai.EntityAIMate;

import net.minecraft.entity.ai.EntityAIPanic;

import net.minecraft.entity.ai.EntityAISwimming;

import net.minecraft.entity.ai.EntityAITempt;

import net.minecraft.entity.ai.EntityAIWander;

import net.minecraft.entity.ai.EntityAIWatchClosest;

import net.minecraft.entity.monster.EntityMob;

import net.minecraft.entity.passive.EntityAnimal;

import net.minecraft.entity.passive.EntityRabbit;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.init.Items;

import net.minecraft.init.SoundEvents;

import net.minecraft.item.Item;

import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.pathfinding.PathNodeType;

import net.minecraft.util.ResourceLocation;

import net.minecraft.util.SoundEvent;

import net.minecraft.util.datafix.DataFixer;

import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.MathHelper;

import net.minecraft.world.World;

import net.minecraft.world.storage.loot.LootTableList;



public class EntityPenguin extends EntityAnimal {

	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(new Item[] { Items.FISH });

	public float wingRotation;

	public float destPos;

	public float oFlapSpeed;

	public float oFlap;

	public float wingRotDelta = 1.0F;

	public int timeUntilNextEgg;

	private int texture_index;



	public EntityPenguin(World worldIn) {

		super(worldIn);

		this.setSize(0.4F, 0.7F);

		this.setPathPriority(PathNodeType.WATER, 0.0F);

		this.texture_index = rand.nextInt(100); // a value from 0 to 15, i.e. 16 total possibilities

	}



	public int getTextureIndex() {

		return this.texture_index;

	}



	protected void initEntityAI() {

		this.tasks.addTask(0, new EntityAISwimming(this));

		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));

		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));

		this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));

		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));

		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));

		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));

		this.tasks.addTask(7, new EntityAILookIdle(this));




	}



	public float getEyeHeight() {

		return this.height;

	}



	protected void applyEntityAttributes() {

		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);

		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);

	}



	

	protected SoundEvent getAmbientSound() {

		return SoundEvents.ENTITY_CHICKEN_AMBIENT;

	}



	protected SoundEvent getHurtSound() {

		return SoundEvents.ENTITY_CHICKEN_HURT;

	}



	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_CHICKEN_DEATH;

	}



	protected void playStepSound(BlockPos pos, Block blockIn) {

		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);

	}



	@Nullable

	protected ResourceLocation getLootTable() {

		return LootTableList.ENTITIES_CHICKEN;

	}



	public EntityPenguin createChild(EntityAgeable ageable) {

		return new EntityPenguin(this.world);

	}



	public boolean isBreedingItem(@Nullable ItemStack stack) {

		return stack != null && TEMPTATION_ITEMS.contains(stack.getItem());

	}






	



}