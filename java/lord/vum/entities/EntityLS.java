package lord.vum.entities;



import com.google.common.base.Predicate;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;

import net.minecraft.entity.Entity;

import net.minecraft.entity.EntityAgeable;

import net.minecraft.entity.EntityLiving;

import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.SharedMonsterAttributes;

import net.minecraft.entity.ai.EntityAIAttackMelee;

import net.minecraft.entity.ai.EntityAIBeg;

import net.minecraft.entity.ai.EntityAIFollowOwner;

import net.minecraft.entity.ai.EntityAIHurtByTarget;

import net.minecraft.entity.ai.EntityAILeapAtTarget;

import net.minecraft.entity.ai.EntityAILookIdle;

import net.minecraft.entity.ai.EntityAIMate;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;

import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;

import net.minecraft.entity.ai.EntityAISit;

import net.minecraft.entity.ai.EntityAISwimming;

import net.minecraft.entity.ai.EntityAITargetNonTamed;

import net.minecraft.entity.ai.EntityAIWander;

import net.minecraft.entity.ai.EntityAIWatchClosest;

import net.minecraft.entity.monster.EntityCreeper;

import net.minecraft.entity.monster.EntityGhast;

import net.minecraft.entity.monster.EntitySkeleton;

import net.minecraft.entity.passive.EntityAnimal;

import net.minecraft.entity.passive.EntityHorse;

import net.minecraft.entity.passive.EntityTameable;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.entity.projectile.EntityArrow;

import net.minecraft.init.Items;

import net.minecraft.init.SoundEvents;

import net.minecraft.item.EnumDyeColor;

import net.minecraft.item.ItemFood;

import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.network.datasync.DataParameter;

import net.minecraft.network.datasync.DataSerializers;

import net.minecraft.network.datasync.EntityDataManager;

import net.minecraft.util.DamageSource;

import net.minecraft.util.EnumHand;

import net.minecraft.util.EnumParticleTypes;

import net.minecraft.util.ResourceLocation;

import net.minecraft.util.SoundEvent;

import net.minecraft.util.datafix.DataFixer;

import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.MathHelper;

import net.minecraft.world.World;

import net.minecraft.world.storage.loot.LootTableList;

import net.minecraftforge.fml.relauncher.Side;

import net.minecraftforge.fml.relauncher.SideOnly;



public class EntityLS extends EntityTameable

{

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityLS.class, DataSerializers.FLOAT);

    

    public EntityLS(World worldIn)

    {

        super(worldIn);

        this.setSize(0.6F, 0.85F);

        this.setTamed(false);

    }



    protected void initEntityAI()

    {

        this.aiSit = new EntityAISit(this);

        this.tasks.addTask(1, new EntityAISwimming(this));

        this.tasks.addTask(2, this.aiSit);

        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));

        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));

        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));

        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));

        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));

        this.tasks.addTask(9, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));

        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));

        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));

        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAnimal.class, false, new Predicate<Entity>()

        {

            public boolean apply(@Nullable Entity p_apply_1_)

            {

                return p_apply_1_ instanceof EntityPenguin;

            }

        }));

    }



    protected void applyEntityAttributes()

    {

        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);



        if (this.isTamed())

        {

            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);

        }

        else

        {

            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);

        }



        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);

    }



    /**

     * Sets the active target the Task system uses for tracking

     */

    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn)

    {

        super.setAttackTarget(entitylivingbaseIn);



        if (entitylivingbaseIn == null)

        {

            this.setAngry(false);

        }

        else if (!this.isTamed())

        {

            this.setAngry(true);

        }

    }



    protected void updateAITasks()

    {

        this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));

    }



    protected void entityInit()

    {

        super.entityInit();

        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));

    }



    protected void playStepSound(BlockPos pos, Block blockIn)

    {

        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);

    }





    /**

     * (abstract) Protected helper method to write subclass entity data to NBT.

     */

    public void writeEntityToNBT(NBTTagCompound compound)

    {

        super.writeEntityToNBT(compound);

        compound.setBoolean("Angry", this.isAngry());

    }



    /**

     * (abstract) Protected helper method to read subclass entity data from NBT.

     */

    public void readEntityFromNBT(NBTTagCompound compound)

    {

        super.readEntityFromNBT(compound);

        this.setAngry(compound.getBoolean("Angry"));

    }



    protected SoundEvent getAmbientSound()

    {

        return this.isAngry() ? SoundEvents.ENTITY_WOLF_GROWL : (this.rand.nextInt(3) == 0 ? (this.isTamed() && ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT) : SoundEvents.ENTITY_WOLF_AMBIENT);

    }



    protected SoundEvent getHurtSound()

    {

        return SoundEvents.ENTITY_WOLF_HURT;

    }



    protected SoundEvent getDeathSound()

    {

        return SoundEvents.ENTITY_WOLF_DEATH;

    }



    /**

     * Returns the volume for the sounds this mob makes.

     */

    protected float getSoundVolume()

    {

        return 0.4F;

    }



    @Nullable

    protected ResourceLocation getLootTable()

    {

        return LootTableList.ENTITIES_WOLF;

    }



    /**

     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons

     * use this to react to sunlight and start to burn.

     */

    public void onLivingUpdate()

    {

        super.onLivingUpdate();



        if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry())

        {

            this.setAngry(false);

        }

    }



    public float getEyeHeight()

    {

        return this.height * 0.8F;

    }



    public int getVerticalFaceSpeed()

    {

        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();

    }



    /**

     * Called when the entity is attacked.

     */

    public boolean attackEntityFrom(DamageSource source, float amount)

    {

        if (this.isEntityInvulnerable(source))

        {

            return false;

        }

        else

        {



            if (this.aiSit != null)

            {

                this.aiSit.setSitting(false);

            }



           



            return super.attackEntityFrom(source, amount);

        }

    }



    public boolean attackEntityAsMob(Entity entityIn)

    {

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));



        if (flag)

        {

            this.applyEnchantments(this, entityIn);

        }



        return flag;

    }



    public void setTamed(boolean tamed)

    {

        super.setTamed(tamed);



        if (tamed)

        {

            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);

        }

        else

        {

            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);

        }



        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);

    }



    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)

    {

        if (this.isTamed())

        {

            if (stack != null)

            {

                if (stack.getItem() instanceof ItemFood)

                {

                    ItemFood itemfood = (ItemFood)stack.getItem();



                    if (itemfood.isWolfsFavoriteMeat() && ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 20.0F)

                    {

                        



                        this.heal((float)itemfood.getHealAmount(stack));

                        return true;

                    }

                }

            }



            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack))

            {

                this.aiSit.setSitting(!this.isSitting());

                this.isJumping = false;

                this.navigator.clearPath();

                this.setAttackTarget((EntityLivingBase)null);

            }

        }

        else if (stack != null && stack.getItem() == Items.BONE && !this.isAngry())

        {






            if (!this.world.isRemote)

            {

                if (this.rand.nextInt(3) == 0)

                {

                    this.setTamed(true);

                    this.navigator.clearPath();

                    this.setAttackTarget((EntityLivingBase)null);

                    this.aiSit.setSitting(true);

                    this.setHealth(20.0F);

                    this.setOwnerId(player.getUniqueID());

                    this.playTameEffect(true);

                    this.world.setEntityState(this, (byte)7);

                }

                else

                {

                    this.playTameEffect(false);

                    this.world.setEntityState(this, (byte)6);

                }

            }



            return true;

        }



        return super.processInteract(player, hand);

    }



    @SideOnly(Side.CLIENT)

    public void handleStatusUpdate(byte id)

    {

            super.handleStatusUpdate(id);

    }



    public boolean isBreedingItem(@Nullable ItemStack stack)

    {

        return stack == null ? false : (!(stack.getItem() instanceof ItemFood) ? false : ((ItemFood)stack.getItem()).isWolfsFavoriteMeat());

    }



    /**

     * Will return how many at most can spawn in a chunk at once.

     */

    public int getMaxSpawnedInChunk()

    {

        return 8;

    }



    /**

     * Determines whether this wolf is angry or not.

     */

    public boolean isAngry()

    {

        return (((Byte)this.dataManager.get(TAMED)).byteValue() & 2) != 0;

    }



    /**

     * Sets whether this wolf is angry or not.

     */

    public void setAngry(boolean angry)

    {

        byte b0 = ((Byte)this.dataManager.get(TAMED)).byteValue();



        if (angry)

        {

            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 2)));

        }

        else

        {

            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -3)));

        }

    }





    public EntityLS createChild(EntityAgeable ageable)

    {

        EntityLS entitywolf = new EntityLS(this.world);

        UUID uuid = this.getOwnerId();



        if (uuid != null)

        {

            entitywolf.setOwnerId(uuid);

            entitywolf.setTamed(true);

        }



        return entitywolf;

    }



    public boolean canMateWith(EntityAnimal otherAnimal)

    {

        if (otherAnimal == this)

        {

            return false;

        }

        else if (!this.isTamed())

        {

            return false;

        }

        else if (!(otherAnimal instanceof EntityLS))

        {

            return false;

        }

        else

        {

            EntityLS entitywolf = (EntityLS)otherAnimal;

            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());

        }

    }



    public boolean shouldAttackEntity(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)

    {

        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))

        {

            if (p_142018_1_ instanceof EntityLS)

            {

                EntityLS entitywolf = (EntityLS)p_142018_1_;



                if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)

                {

                    return false;

                }

            }



            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();

        }

        else

        {

            return false;

        }

    }



    public boolean canBeLeashedTo(EntityPlayer player)

    {

        return !this.isAngry() && super.canBeLeashedTo(player);

    }

}