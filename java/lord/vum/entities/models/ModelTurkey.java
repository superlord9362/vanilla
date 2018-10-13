package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelTurkey - JJo
 * Created using Tabula 5.0.0
 */
public class ModelTurkey extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer RightUpperLeg;
    public ModelRenderer LeftUpperLeg;
    public ModelRenderer RightWing;
    public ModelRenderer LeftWing;
    public ModelRenderer TailEnd;
    public ModelRenderer Neck;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer TailFeathers;
    public ModelRenderer Head;
    public ModelRenderer Beak;

    public ModelTurkey() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightWing = new ModelRenderer(this, 0, 19);
        this.RightWing.setRotationPoint(-3.8F, 0.7F, 0.0F);
        this.RightWing.addBox(-0.9F, 0.0F, 0.0F, 1, 7, 10, 0.0F);
        this.setRotateAngle(RightWing, 0.061086523819801536F, -0.06981317007977318F, 0.0F);
        this.TailFeathers = new ModelRenderer(this, -9, 55);
        this.TailFeathers.setRotationPoint(0.0F, 0.8F, 1.15F);
        this.TailFeathers.addBox(-6.0F, 0.0F, 0.0F, 12, 0, 9, 0.0F);
        this.setRotateAngle(TailFeathers, 0.32288591161895097F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 42);
        this.Beak.setRotationPoint(0.0F, -2.2F, -1.1F);
        this.Beak.addBox(-0.5F, 0.0F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(Beak, 0.22759093446006054F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 36);
        this.Head.setRotationPoint(0.0F, -6.25F, 0.5F);
        this.Head.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Head, -0.06981317007977318F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 50, 0);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(0.0F, 1.55F, -0.5F);
        this.LeftLeg.addBox(-1.5F, 0.0F, -3.5F, 3, 6, 4, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.95F, -5.0F);
        this.Body.addBox(-4.0F, 0.0F, -1.0F, 8, 8, 11, 0.0F);
        this.setRotateAngle(Body, 0.10471975511965977F, 0.0F, 0.0F);
        this.RightUpperLeg = new ModelRenderer(this, 13, 7);
        this.RightUpperLeg.setRotationPoint(-2.05F, 7.3F, 7.5F);
        this.RightUpperLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(RightUpperLeg, -0.10471975511965977F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 19);
        this.Neck.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.Neck.addBox(-1.0F, -6.75F, -0.5F, 2, 8, 2, 0.0F);
        this.setRotateAngle(Neck, 0.091106186954104F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 50, 0);
        this.RightLeg.setRotationPoint(0.0F, 1.55F, -0.5F);
        this.RightLeg.addBox(-1.5F, 0.0F, -3.5F, 3, 6, 4, 0.0F);
        this.LeftUpperLeg = new ModelRenderer(this, 13, 7);
        this.LeftUpperLeg.setRotationPoint(2.05F, 7.3F, 7.5F);
        this.LeftUpperLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(LeftUpperLeg, -0.10471975511965977F, 0.0F, 0.0F);
        this.TailEnd = new ModelRenderer(this, 13, 19);
        this.TailEnd.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.TailEnd.addBox(-3.0F, 0.0F, -1.0F, 6, 4, 4, 0.0F);
        this.setRotateAngle(TailEnd, 0.4553564018453205F, 0.0F, 0.0F);
        this.LeftWing = new ModelRenderer(this, 0, 19);
        this.LeftWing.mirror = true;
        this.LeftWing.setRotationPoint(3.8F, 0.7F, 0.0F);
        this.LeftWing.addBox(-0.1F, 0.0F, 0.0F, 1, 7, 10, 0.0F);
        this.setRotateAngle(LeftWing, 0.061086523819801536F, 0.06981317007977318F, 0.0F);
        this.Body.addChild(this.RightWing);
        this.TailEnd.addChild(this.TailFeathers);
        this.Head.addChild(this.Beak);
        this.Neck.addChild(this.Head);
        this.LeftUpperLeg.addChild(this.LeftLeg);
        this.Body.addChild(this.RightUpperLeg);
        this.Body.addChild(this.Neck);
        this.RightUpperLeg.addChild(this.RightLeg);
        this.Body.addChild(this.LeftUpperLeg);
        this.Body.addChild(this.TailEnd);
        this.Body.addChild(this.LeftWing);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.Head.rotateAngleX= (0.2617794F + XAngle);

    	this.Head.rotateAngleY= YAngle;

    	

    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;



    }
}
