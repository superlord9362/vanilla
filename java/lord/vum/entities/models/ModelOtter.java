package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelOtter - JJo
 * Created using Tabula 5.0.0
 */
public class ModelOtter extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer FrontLefttLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer Head;
    public ModelRenderer RightEar;
    public ModelRenderer LefttEar;
    public ModelRenderer Mouth;

    public ModelOtter() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.5F, -5.0F);
        this.Body.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 10, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 0);
        this.FrontRightLeg.setRotationPoint(-1.7F, 2.5F, 1.0F);
        this.FrontRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.RightEar = new ModelRenderer(this, 8, 0);
        this.RightEar.setRotationPoint(-2.0F, -0.5F, -0.25F);
        this.RightEar.addBox(-0.9F, -0.9F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, 0.091106186954104F, 0.27314402793711257F);
        this.LefttEar = new ModelRenderer(this, 8, 0);
        this.LefttEar.mirror = true;
        this.LefttEar.setRotationPoint(2.0F, -0.5F, -0.25F);
        this.LefttEar.addBox(-0.1F, -0.9F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(LefttEar, 0.0F, -0.091106186954104F, -0.27314402793711257F);
        this.Tail = new ModelRenderer(this, 0, 14);
        this.Tail.setRotationPoint(0.0F, 1.0F, 9.9F);
        this.Tail.addBox(-1.0F, -0.25F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(Tail, -0.17453292519943295F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 25);
        this.Head.setRotationPoint(0.0F, 0.15F, -0.9F);
        this.Head.addBox(-2.0F, -2.0F, -2.9F, 4, 4, 3, 0.0F);
        this.FrontLefttLeg = new ModelRenderer(this, 0, 0);
        this.FrontLefttLeg.mirror = true;
        this.FrontLefttLeg.setRotationPoint(1.7F, 2.5F, 1.0F);
        this.FrontLefttLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 0);
        this.BackLeftLeg.mirror = true;
        this.BackLeftLeg.setRotationPoint(1.7F, 2.5F, 8.9F);
        this.BackLeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.Mouth = new ModelRenderer(this, 18, 7);
        this.Mouth.setRotationPoint(0.0F, -0.2F, -3.75F);
        this.Mouth.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 0);
        this.BackRightLeg.setRotationPoint(-1.7F, 2.5F, 8.9F);
        this.BackRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.Neck = new ModelRenderer(this, 18, 0);
        this.Neck.setRotationPoint(0.0F, 1.75F, 0.3F);
        this.Neck.addBox(-1.5F, -1.5F, -0.9F, 3, 3, 1, 0.0F);
        this.Body.addChild(this.FrontRightLeg);
        this.Head.addChild(this.RightEar);
        this.Head.addChild(this.LefttEar);
        this.Body.addChild(this.Tail);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.FrontLefttLeg);
        this.Body.addChild(this.BackLeftLeg);
        this.Head.addChild(this.Mouth);
        this.Body.addChild(this.BackRightLeg);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.Head.rotateAngleX= (0.2617794F + XAngle);

    	this.Head.rotateAngleY= YAngle;

    	

    	this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.FrontLefttLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
