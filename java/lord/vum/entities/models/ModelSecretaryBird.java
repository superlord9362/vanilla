package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSecretaryBird - JJo
 * Created using Tabula 5.0.0
 */
public class ModelSecretaryBird extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer LeftUpperLeg;
    public ModelRenderer RightUpperLeg;
    public ModelRenderer Tail1;
    public ModelRenderer LeftWing;
    public ModelRenderer RightWing;
    public ModelRenderer Neck;
    public ModelRenderer Tail2;
    public ModelRenderer Head;
    public ModelRenderer UpperBeak;
    public ModelRenderer LowerBeak;
    public ModelRenderer LeftPlumage;
    public ModelRenderer RightPlumage;
    public ModelRenderer LeftLowerLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLowerLeg;
    public ModelRenderer RightFoot;

    public ModelSecretaryBird() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 3.0F, -3.5F);
        this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 8, 0.0F);
        this.setRotateAngle(Body, -0.18203784098300857F, 0.0F, 0.0F);
        this.RightWing = new ModelRenderer(this, 1, 18);
        this.RightWing.setRotationPoint(-2.9F, 0.35F, 0.5F);
        this.RightWing.addBox(-1.0F, 0.0F, 0.0F, 1, 5, 12, 0.0F);
        this.setRotateAngle(RightWing, -0.091106186954104F, 0.045553093477052F, 0.0F);
        this.Head = new ModelRenderer(this, 9, 36);
        this.Head.setRotationPoint(0.0F, -7.7F, 0.2F);
        this.Head.addBox(-1.5F, -2.75F, -3.25F, 3, 3, 4, 0.0F);
        this.setRotateAngle(Head, -0.091106186954104F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 0, 25);
        this.LeftFoot.mirror = true;
        this.LeftFoot.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.LeftFoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(LeftFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.RightLowerLeg = new ModelRenderer(this, 8, 16);
        this.RightLowerLeg.setRotationPoint(0.0F, 6.75F, 0.0F);
        this.RightLowerLeg.addBox(-0.5F, -0.25F, -0.5F, 1, 8, 1, 0.0F);
        this.setRotateAngle(RightLowerLeg, -0.136659280431156F, 0.0F, 0.0F);
        this.LeftPlumage = new ModelRenderer(this, 9, 40);
        this.LeftPlumage.setRotationPoint(1.25F, -2.75F, 0.0F);
        this.LeftPlumage.addBox(0.0F, 0.0F, 0.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(LeftPlumage, -0.5462880558742251F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 36);
        this.Neck.setRotationPoint(0.0F, 3.1F, 1.0F);
        this.Neck.addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(Neck, 0.36425021489121656F, 0.0F, 0.0F);
        this.RightUpperLeg = new ModelRenderer(this, 0, 15);
        this.RightUpperLeg.setRotationPoint(-1.75F, 9.25F, 1.0F);
        this.RightUpperLeg.addBox(-1.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(RightUpperLeg, 0.045553093477052F, 0.0F, 0.0F);
        this.LeftWing = new ModelRenderer(this, 1, 18);
        this.LeftWing.mirror = true;
        this.LeftWing.setRotationPoint(2.9F, 0.35F, 0.5F);
        this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 1, 5, 12, 0.0F);
        this.setRotateAngle(LeftWing, -0.091106186954104F, -0.045553093477052F, 0.0F);
        this.LeftLowerLeg = new ModelRenderer(this, 8, 16);
        this.LeftLowerLeg.mirror = true;
        this.LeftLowerLeg.setRotationPoint(0.0F, 6.75F, 0.0F);
        this.LeftLowerLeg.addBox(-0.5F, -0.25F, -0.5F, 1, 8, 1, 0.0F);
        this.setRotateAngle(LeftLowerLeg, -0.136659280431156F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 0, 25);
        this.RightFoot.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.RightFoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(RightFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.UpperBeak = new ModelRenderer(this, 0, 0);
        this.UpperBeak.setRotationPoint(0.0F, -1.6F, -3.0F);
        this.UpperBeak.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(UpperBeak, 0.40980330836826856F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 19, 14);
        this.Tail1.setRotationPoint(0.0F, 0.25F, 7.5F);
        this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(Tail1, -0.091106186954104F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 16, 20);
        this.Tail2.setRotationPoint(0.0F, 0.3F, 2.7F);
        this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(Tail2, -0.091106186954104F, 0.0F, 0.0F);
        this.RightPlumage = new ModelRenderer(this, 9, 40);
        this.RightPlumage.setRotationPoint(-1.25F, -2.75F, 0.0F);
        this.RightPlumage.addBox(0.0F, 0.0F, 0.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(RightPlumage, -0.5462880558742251F, 0.0F, 0.0F);
        this.LowerBeak = new ModelRenderer(this, 0, 3);
        this.LowerBeak.setRotationPoint(0.0F, -0.9F, -3.0F);
        this.LowerBeak.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.LeftUpperLeg = new ModelRenderer(this, 0, 15);
        this.LeftUpperLeg.mirror = true;
        this.LeftUpperLeg.setRotationPoint(1.75F, 9.25F, 1.0F);
        this.LeftUpperLeg.addBox(-1.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(LeftUpperLeg, 0.045553093477052F, 0.0F, 0.0F);
        this.Body.addChild(this.RightWing);
        this.Neck.addChild(this.Head);
        this.LeftLowerLeg.addChild(this.LeftFoot);
        this.RightUpperLeg.addChild(this.RightLowerLeg);
        this.Head.addChild(this.LeftPlumage);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.LeftWing);
        this.LeftUpperLeg.addChild(this.LeftLowerLeg);
        this.RightLowerLeg.addChild(this.RightFoot);
        this.Head.addChild(this.UpperBeak);
        this.Body.addChild(this.Tail1);
        this.Tail1.addChild(this.Tail2);
        this.Head.addChild(this.RightPlumage);
        this.Head.addChild(this.LowerBeak);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
        this.RightUpperLeg.render(f5);
        this.LeftUpperLeg.render(f5);
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.Head.rotateAngleX= (0.2617794F + XAngle);

    	this.Head.rotateAngleY= YAngle;

    	

    	this.RightUpperLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.LeftUpperLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;



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
