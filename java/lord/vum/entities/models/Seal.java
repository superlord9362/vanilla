package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Seal - JJo
 * Created using Tabula 5.0.0
 */
public class Seal extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer lowerbody1;
    public ModelRenderer neck;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tailendleft;
    public ModelRenderer tailendright;
    public ModelRenderer head;
    public ModelRenderer upperjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer leftflipper;
    public ModelRenderer rightflipper;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Seal() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.upperjaw = new ModelRenderer(this, 59, 16);
        this.upperjaw.mirror = true;
        this.upperjaw.setRotationPoint(0.0F, 2.45F, -6.25F);
        this.upperjaw.addBox(-2.0F, -2.0F, -3.0F, 4, 2, 3, 0.0F);
        this.neck = new ModelRenderer(this, 0, 16);
        this.neck.setRotationPoint(0.0F, 0.7F, 0.8F);
        this.neck.addBox(-2.5F, 0.0F, -6.0F, 5, 5, 7, 0.0F);
        this.setRotateAngle(neck, -0.36425021489121656F, 0.0F, 0.0F);
        this.rightflipper = new ModelRenderer(this, 10, 28);
        this.rightflipper.mirror = true;
        this.rightflipper.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.rightflipper.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F);
        this.setRotateAngle(rightflipper, 0.136659280431156F, 0.0F, 0.27314402793711257F);
        this.leftflipper = new ModelRenderer(this, 10, 28);
        this.leftflipper.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leftflipper.addBox(0.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F);
        this.setRotateAngle(leftflipper, 0.136659280431156F, 0.0F, -0.27314402793711257F);
        this.rightarm = new ModelRenderer(this, 0, 28);
        this.rightarm.mirror = true;
        this.rightarm.setRotationPoint(-3.5F, 2.5F, 0.0F);
        this.rightarm.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(rightarm, 0.091106186954104F, 0.0F, 0.5918411493512771F);
        this.tail1 = new ModelRenderer(this, 62, 0);
        this.tail1.setRotationPoint(0.0F, 0.7F, 8.1F);
        this.tail1.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(tail1, 0.09110618695410429F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 90, 0);
        this.tail2.setRotationPoint(0.5F, 1.0F, 8.3F);
        this.tail2.addBox(-2.0F, 0.0F, 0.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(tail2, -0.045553093477051F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 26, 16);
        this.head.setRotationPoint(0.0F, 1.2F, -5.5F);
        this.head.addBox(-3.0F, -1.5F, -6.75F, 6, 5, 7, 0.0F);
        this.setRotateAngle(head, 0.7285004297824331F, 0.0F, 0.0F);
        this.tailendleft = new ModelRenderer(this, 106, 5);
        this.tailendleft.setRotationPoint(-0.5F, 1.0F, 7.0F);
        this.tailendleft.addBox(0.0F, 0.0F, 0.0F, 4, 1, 7, 0.0F);
        this.setRotateAngle(tailendleft, 0.0F, 0.136659280431156F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 12.599999999999998F, -3.5F);
        this.Body1.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 9, 0.0F);
        this.setRotateAngle(Body1, -0.27314402793711257F, 0.0F, 0.0F);
        this.tailendright = new ModelRenderer(this, 106, 5);
        this.tailendright.setRotationPoint(-0.5F, 1.0F, 7.0F);
        this.tailendright.addBox(-4.0F, 0.0F, 0.0F, 4, 1, 7, 0.0F);
        this.setRotateAngle(tailendright, 0.0F, -0.136659280431156F, 0.0F);
        this.lowerbody1 = new ModelRenderer(this, 32, 0);
        this.lowerbody1.setRotationPoint(0.0F, 0.5F, 8.1F);
        this.lowerbody1.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 9, 0.0F);
        this.setRotateAngle(lowerbody1, 0.045553093477051616F, 0.0F, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 74, 16);
        this.lowerjaw.mirror = true;
        this.lowerjaw.setRotationPoint(0.0F, 2.05F, -6.25F);
        this.lowerjaw.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 3, 0.0F);
        this.leftarm = new ModelRenderer(this, 0, 28);
        this.leftarm.setRotationPoint(3.5F, 2.5F, 0.0F);
        this.leftarm.addBox(0.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(leftarm, 0.091106186954104F, 0.0F, -0.5918411493512771F);
        this.head.addChild(this.upperjaw);
        this.Body1.addChild(this.neck);
        this.rightarm.addChild(this.rightflipper);
        this.leftarm.addChild(this.leftflipper);
        this.Body1.addChild(this.rightarm);
        this.lowerbody1.addChild(this.tail1);
        this.tail1.addChild(this.tail2);
        this.neck.addChild(this.head);
        this.tail2.addChild(this.tailendleft);
        this.tail2.addChild(this.tailendright);
        this.Body1.addChild(this.lowerbody1);
        this.head.addChild(this.lowerjaw);
        this.Body1.addChild(this.leftarm);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
       
    	 if (this.isChild)

	        {

	            float f6 = 2.0F;

	            GlStateManager.pushMatrix();

	            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);

	            GlStateManager.popMatrix();

	            GlStateManager.pushMatrix();

	            GlStateManager.scale(0.5F, 0.5F, 0.5F);

	            GlStateManager.translate(0.0F, 24.0F * f5, 0.0F);

	            this.Body1.render(f5);

	            GlStateManager.popMatrix();

	        }

	        else {

		this.Body1.render(f5);
	        }
    }
    

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,

			float headPitch, float scaleFactor, Entity entity) {

		float XAngle = headPitch / 57.29578F;

		float YAngle = netHeadYaw / 57.29578F;



		this.head.rotateAngleX = (0.2617794F + XAngle);

		this.head.rotateAngleY = YAngle;



		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;



	}
}
