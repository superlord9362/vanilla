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

import net.minecraft.entity.ai.EntityAIFollowParent;

import net.minecraft.entity.ai.EntityAILookIdle;

import net.minecraft.entity.ai.EntityAIMate;

import net.minecraft.entity.ai.EntityAIPanic;

import net.minecraft.entity.ai.EntityAISwimming;

import net.minecraft.entity.ai.EntityAITempt;

import net.minecraft.entity.ai.EntityAIWander;

import net.minecraft.entity.ai.EntityAIWatchClosest;

import net.minecraft.entity.passive.EntityAnimal;

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



public class EntitySecretaryBird extends EntityAnimal

{

    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(new Item[] {Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS});



    public int timeUntilNextEgg;



    public EntitySecretaryBird(World worldIn)

    {

        super(worldIn);

        this.setSize(0.4F, 1.5F);

        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

        this.setPathPriority(PathNodeType.WATER, 0.0F);

    }



    protected void initEntityAI()

    {

        this.tasks.addTask(0, new EntityAISwimming(this));

        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));

        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));

        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));

        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));

        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));

        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));

        this.tasks.addTask(7, new EntityAILookIdle(this));

    }



    public float getEyeHeight()

    {

        return this.height;

    }



    protected void applyEntityAttributes()

    {

        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);

        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);

    }



    /**

     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons

     * use this to react to sunlight and start to burn.

     */

    public void onLivingUpdate()

    {

        super.onLivingUpdate();

        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0)

        {

            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);

            this.dropItem(Items.EGG, 1);

            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

        }

    }



    public void fall(float distance, float damageMultiplier)

    {

    }



    protected SoundEvent getAmbientSound()

    {

        return SoundEvents.ENTITY_CHICKEN_AMBIENT;

    }



    protected SoundEvent getHurtSound()

    {

        return SoundEvents.ENTITY_CHICKEN_HURT;

    }



    protected SoundEvent getDeathSound()

    {

        return SoundEvents.ENTITY_CHICKEN_DEATH;

    }



    protected void playStepSound(BlockPos pos, Block blockIn)

    {

        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);

    }



    @Nullable

    protected ResourceLocation getLootTable()

    {

        return LootTableList.ENTITIES_CHICKEN;

    }



    public EntitySecretaryBird createChild(EntityAgeable ageable)

    {

        return new EntitySecretaryBird(this.world);

    }



    /**

     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on

     * the animal type)

     */

    public boolean isBreedingItem(@Nullable ItemStack stack)

    {

        return stack != null && TEMPTATION_ITEMS.contains(stack.getItem());

    }



    /**

     * Get the experience points the entity currently has.

     */

   





    /**

     * (abstract) Protected helper method to read subclass entity data from NBT.

     */

    public void readEntityFromNBT(NBTTagCompound compound)

    {

        super.readEntityFromNBT(compound);

        

        if (compound.hasKey("EggLayTime"))

        {

            this.timeUntilNextEgg = compound.getInteger("EggLayTime");

        }

    }



    /**

     * (abstract) Protected helper method to write subclass entity data to NBT.

     */

    public void writeEntityToNBT(NBTTagCompound compound)

    {

        super.writeEntityToNBT(compound);

        compound.setInteger("EggLayTime", this.timeUntilNextEgg);

    }



   

    



    public void updatePassenger(Entity passenger)

    {

        super.updatePassenger(passenger);

        float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);

        float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);

        float f2 = 0.1F;

        float f3 = 0.0F;

        passenger.setPosition(this.posX + (double)(0.1F * f), this.posY + (double)(this.height * 0.5F) + passenger.getYOffset() + 0.0D, this.posZ - (double)(0.1F * f1));



        if (passenger instanceof EntityLivingBase)

        {

            ((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;

        }

    }



   

}