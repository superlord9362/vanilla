package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Tiger - Doctor Hyena
 * Created using Tabula 5.0.0
 */
public class Tiger extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer Tail1;
    public ModelRenderer Ear1;
    public ModelRenderer Ear2;
    public ModelRenderer TigerFloof;
    public ModelRenderer Muzzle;
    public ModelRenderer Tail2;

    public Tiger() {
        this.textureWidth = 80;
        this.textureHeight = 80;
        this.Tail1 = new ModelRenderer(this, 14, 0);
        this.Tail1.setRotationPoint(0.0F, -4.0F, 9.8F);
        this.Tail1.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.5462880558742251F, 0.0F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 0);
        this.Leg3.setRotationPoint(2.51F, 1.0F, 8.5F);
        this.Leg3.addBox(-1.5F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
        this.Muzzle = new ModelRenderer(this, 28, 32);
        this.Muzzle.setRotationPoint(0.0F, 1.51F, -4.0F);
        this.Muzzle.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.Ear2 = new ModelRenderer(this, 67, 0);
        this.Ear2.setRotationPoint(-2.0F, -2.5F, 0.01F);
        this.Ear2.addBox(-3.0F, -3.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(Ear2, 0.0F, 0.0F, -0.22759093446006054F);
        this.Leg4 = new ModelRenderer(this, 14, 32);
        this.Leg4.setRotationPoint(-2.51F, 1.0F, 8.5F);
        this.Leg4.addBox(-1.5F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
        this.Ear1 = new ModelRenderer(this, 59, 0);
        this.Ear1.setRotationPoint(2.0F, -2.5F, 0.01F);
        this.Ear1.addBox(0.0F, -3.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(Ear1, 0.0F, 0.0F, 0.22759093446006054F);
        this.TigerFloof = new ModelRenderer(this, 38, 14);
        this.TigerFloof.setRotationPoint(0.0F, 0.51F, 0.0F);
        this.TigerFloof.addBox(-4.5F, -3.0F, -1.0F, 9, 6, 2, 0.0F);
        this.Tail2 = new ModelRenderer(this, 35, 32);
        this.Tail2.setRotationPoint(0.01F, 13.21F, -0.31F);
        this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Tail2, -0.6373942428283291F, 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 62, 10);
        this.Leg1.setRotationPoint(2.51F, -3.5F, -8.0F);
        this.Leg1.addBox(-1.5F, -2.0F, -2.0F, 3, 19, 4, 0.0F);
        this.Head = new ModelRenderer(this, 38, 0);
        this.Head.setRotationPoint(0.0F, -3.0F, -13.0F);
        this.Head.addBox(-3.5F, -3.5F, -4.5F, 7, 7, 7, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 32);
        this.Leg2.setRotationPoint(-2.51F, -3.5F, -8.0F);
        this.Leg2.addBox(-1.5F, -2.0F, -2.0F, 3, 19, 4, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 10.5F, 3.0F);
        this.Body.addBox(-4.0F, -5.0F, -11.0F, 8, 10, 22, 0.0F);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.Leg3);
        this.Head.addChild(this.Muzzle);
        this.Head.addChild(this.Ear2);
        this.Body.addChild(this.Leg4);
        this.Head.addChild(this.Ear1);
        this.Head.addChild(this.TigerFloof);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Leg1);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Leg2);
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

    	

    	this.Leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.Leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.Leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    }
}
