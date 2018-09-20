package lord.vum.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityNautilus extends EntityWaterMob {

    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
	private float randomMotionSpeed = .3f;
	
	public float targetYaw;
	public float currentYaw;
	public float targetPitch;
	private float turnSpeed = .1f;
    public static final float tentacleTime = 30;
    public float tentacleAngle;
    
   
	public EntityNautilus(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initEntityAI() {
		this.tasks.addTask(0, new EntityNautilus.AIMoveRandom(this));
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		float f2 =(float) Math.sqrt((motionX*motionX + motionY*motionY));
		if (this.inWater)
        {
            	float f1 =(float) Math.sqrt((motionX*motionX + motionY*motionY+motionZ*motionZ));
                float f = ((this.world.getWorldTime())%tentacleTime)/(tentacleTime);

                this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.125F;
                this.randomMotionSpeed*=0.95f;
                if (!this.world.isRemote)
                {
                    this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
                    this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
                    this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
                }
                
                
                this.targetPitch = MathHelper.wrapDegrees((float) (MathHelper.atan2(this.motionY,f2)*(180f/Math.PI)))-this.rotationPitch;
                this.rotationPitch+=targetPitch*turnSpeed;
            }
            else
            {
                this.tentacleAngle = 0.0F;
                this.rotationPitch=0f;
            }
			this.targetYaw = MathHelper.wrapDegrees((float) (-MathHelper.atan2(this.motionX/f2, this.motionZ/f2)*(180f/Math.PI)))-this.rotationYaw;
			this.rotationYaw+=targetYaw*turnSpeed;

	}
	
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3);
	}

    public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn)
    {
        this.randomMotionVecX = randomMotionVecXIn;
        this.randomMotionVecY = randomMotionVecYIn;
        this.randomMotionVecZ = randomMotionVecZIn;
    }
    
    public boolean hasMovementVector()
    {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }
	

	
	
	static class AIMoveRandom extends EntityAIBase
    {
        private final EntityNautilus squid;

        public AIMoveRandom(EntityNautilus p_i45859_1_)
        {
            this.squid = p_i45859_1_;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            int i = this.squid.getIdleTime();

            if (i > 100)
            {
                this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
            }
            else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.hasMovementVector())
            {
            	squid.randomMotionSpeed=1f;
                float f = this.squid.getRNG().nextFloat() * ((float)Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F*(this.squid.isInWater()?1f:-1f);
                float f3 = MathHelper.sin(f) * 0.2F;
                this.squid.setMovementVector(f1, f2, f3);
                
            }
        }
    }



}
