package lord.vum.entities;



import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;

import net.minecraft.entity.EntityLiving;

import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.EnumCreatureAttribute;

import net.minecraft.entity.IEntityLivingData;

import net.minecraft.entity.SharedMonsterAttributes;

import net.minecraft.entity.ai.EntityAIAttackMelee;

import net.minecraft.entity.ai.EntityAIHurtByTarget;

import net.minecraft.entity.ai.EntityAILeapAtTarget;

import net.minecraft.entity.ai.EntityAILookIdle;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import net.minecraft.entity.ai.EntityAISwimming;

import net.minecraft.entity.ai.EntityAIWander;

import net.minecraft.entity.ai.EntityAIWatchClosest;

import net.minecraft.entity.monster.EntityMob;

import net.minecraft.entity.passive.EntityWolf;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.init.MobEffects;

import net.minecraft.init.SoundEvents;

import net.minecraft.network.datasync.DataParameter;

import net.minecraft.network.datasync.DataSerializers;

import net.minecraft.network.datasync.EntityDataManager;

import net.minecraft.pathfinding.PathNavigate;

import net.minecraft.pathfinding.PathNavigateClimber;

import net.minecraft.potion.Potion;

import net.minecraft.potion.PotionEffect;

import net.minecraft.util.ResourceLocation;

import net.minecraft.util.SoundEvent;

import net.minecraft.util.datafix.DataFixer;

import net.minecraft.util.math.BlockPos;

import net.minecraft.world.DifficultyInstance;

import net.minecraft.world.EnumDifficulty;

import net.minecraft.world.World;

import net.minecraft.world.storage.loot.LootTableList;



public class EntityTiger extends EntityMob {

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityTiger.class,

			DataSerializers.BYTE);



	public EntityTiger(World worldIn) {

		super(worldIn);

		this.setSize(1.4F, 1.4F);

	}





	protected void initEntityAI() {

		this.tasks.addTask(1, new EntityAISwimming(this));

		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));

		this.tasks.addTask(4, new EntityTiger.AISpiderAttack(this));

		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));

		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));

		this.tasks.addTask(6, new EntityAILookIdle(this));

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));

		this.targetTasks.addTask(2, new EntityTiger.AISpiderTarget(this, EntityPlayer.class));

		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));

	}



	protected void applyEntityAttributes() {

		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);

		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);

	}



	protected SoundEvent getAmbientSound() {

		return null;

	}



	protected SoundEvent getHurtSound() {

		return null;

	}



	protected SoundEvent getDeathSound() {

		return null;

	}



	@Nullable

	protected ResourceLocation getLootTable() {

		return LootTableList.ENTITIES_SPIDER;

	}



	@Nullable

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {

		livingdata = super.onInitialSpawn(difficulty, livingdata);



		if (livingdata == null) {

			livingdata = new EntityTiger.GroupData();



			if (this.world.getDifficulty() == EnumDifficulty.HARD

					&& this.world.rand.nextFloat() < 0.1F * difficulty.getClampedAdditionalDifficulty()) {

				((EntityTiger.GroupData) livingdata).setRandomEffect(this.world.rand);

			}

		}



		if (livingdata instanceof EntityTiger.GroupData) {

			Potion potion = ((EntityTiger.GroupData) livingdata).effect;



			if (potion != null) {

				this.addPotionEffect(new PotionEffect(potion, Integer.MAX_VALUE));

			}

		}



		return livingdata;

	}



	public float getEyeHeight() {

		return 0.65F;

	}



	static class AISpiderAttack extends EntityAIAttackMelee {

		public AISpiderAttack(EntityTiger spider) {

			super(spider, 1.0D, true);

		}



		/**

		 * Returns whether an in-progress EntityAIBase should continue executing

		 */

		public boolean continueExecuting() {

			float f = this.attacker.getBrightness();



			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {

				this.attacker.setAttackTarget((EntityLivingBase) null);

				return false;

			} else {

				return super.shouldContinueExecuting();

			}

		}



		protected double getAttackReachSqr(EntityLivingBase attackTarget) {

			return (double) (4.0F + attackTarget.width);

		}

	}



	static class AISpiderTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {

		public AISpiderTarget(EntityTiger spider, Class<T> classTarget) {

			super(spider, classTarget, true);

		}



		/**

		 * Returns whether the EntityAIBase should begin execution.

		 */

		public boolean shouldExecute() {

			float f = this.taskOwner.getBrightness();

			return f >= 0.5F ? false : super.shouldExecute();

		}

	}



	public static class GroupData implements IEntityLivingData {

		public Potion effect;



		public void setRandomEffect(Random rand) {

			int i = rand.nextInt(5);



			if (i <= 1) {

				this.effect = MobEffects.SPEED;

			} else if (i <= 2) {

				this.effect = MobEffects.STRENGTH;

			} else if (i <= 3) {

				this.effect = MobEffects.REGENERATION;

			} else if (i <= 4) {

				this.effect = MobEffects.INVISIBILITY;

			}

		}

	}

}