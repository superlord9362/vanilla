package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Giraffe - Undefined
 * Created using Tabula 5.0.0
 */
public class Giraffe extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer Tail;
    public ModelRenderer Neck;
    public ModelRenderer Head;
    public ModelRenderer Mane;
    public ModelRenderer horn2;
    public ModelRenderer horn1;
    public ModelRenderer Muzzle;
    public ModelRenderer Ears;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Giraffe() {
        this.textureWidth = 100;
        this.textureHeight = 100;
        this.Mane = new ModelRenderer(this, 74, 24);
        this.Mane.setRotationPoint(0.0F, -3.6F, -3.5F);
        this.Mane.addBox(-0.5F, -24.0F, -0.5F, 1, 24, 1, 0.0F);
        this.setRotateAngle(Mane, 1.593485607070823F, 0.0F, 0.0F);
        this.horn1 = new ModelRenderer(this, 12, 0);
        this.horn1.setRotationPoint(0.5F, -2.4F, -3.5F);
        this.horn1.addBox(-3.0F, -3.0F, 0.0F, 2, 3, 2, 0.0F);
        this.Leg2 = new ModelRenderer(this, 74, 0);
        this.Leg2.setRotationPoint(-3.0F, 5.8F, -2.0F);
        this.Leg2.addBox(-1.5F, 0.0F, -2.0F, 3, 20, 4, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -14.7F, 0.0F);
        this.Body1.addBox(-5.0F, -6.0F, -5.0F, 10, 12, 20, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 32);
        this.Neck.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Neck.addBox(-2.0F, -3.0F, -25.0F, 4, 6, 25, 0.0F);
        this.setRotateAngle(Neck, -1.3203415791337103F, 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 60, 0);
        this.Leg1.setRotationPoint(3.0F, 5.8F, -2.0F);
        this.Leg1.addBox(-1.5F, 0.0F, -2.0F, 3, 20, 4, 0.0F);
        this.Leg3 = new ModelRenderer(this, 84, 20);
        this.Leg3.setRotationPoint(3.0F, 5.8F, 12.5F);
        this.Leg3.addBox(-1.5F, 0.0F, -2.0F, 3, 20, 4, 0.0F);
        this.Head = new ModelRenderer(this, 33, 40);
        this.Head.setRotationPoint(0.0F, -2.0F, -25.0F);
        this.Head.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 8, 0.0F);
        this.setRotateAngle(Head, 1.3658946726107624F, 0.0F, 0.0F);
        this.Muzzle = new ModelRenderer(this, 40, 0);
        this.Muzzle.setRotationPoint(0.0F, 1.01F, -6.0F);
        this.Muzzle.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Muzzle, 0.136659280431156F, 0.0F, 0.0F);
        this.Leg4 = new ModelRenderer(this, 60, 24);
        this.Leg4.setRotationPoint(-3.0F, 5.8F, 12.5F);
        this.Leg4.addBox(-1.5F, 0.0F, -2.0F, 3, 20, 4, 0.0F);
        this.Ears = new ModelRenderer(this, 0, 32);
        this.Ears.setRotationPoint(0.0F, -1.9F, -1.8F);
        this.Ears.addBox(-5.5F, -1.0F, 0.0F, 11, 3, 1, 0.0F);
        this.setRotateAngle(Ears, -0.18203784098300857F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.setRotationPoint(0.0F, -5.0F, 14.4F);
        this.Tail.addBox(-0.5F, 0.0F, -0.5F, 1, 18, 1, 0.0F);
        this.setRotateAngle(Tail, 0.091106186954104F, 0.0F, 0.0F);
        this.horn2 = new ModelRenderer(this, 4, 0);
        this.horn2.setRotationPoint(0.5F, -2.5F, -3.5F);
        this.horn2.addBox(0.0F, -3.0F, 0.0F, 2, 3, 2, 0.0F);
        this.Neck.addChild(this.Mane);
        this.Head.addChild(this.horn1);
        this.Body1.addChild(this.Leg2);
        this.Body1.addChild(this.Neck);
        this.Body1.addChild(this.Leg1);
        this.Body1.addChild(this.Leg3);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Muzzle);
        this.Body1.addChild(this.Leg4);
        this.Head.addChild(this.Ears);
        this.Body1.addChild(this.Tail);
        this.Head.addChild(this.horn2);
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
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(1.5D, 1.5D, 1.5D);
        GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        GlStateManager.translate(-this.Body1.rotationPointX * f5, -this.Body1.rotationPointY * f5, -this.Body1.rotationPointZ * f5);
        this.Body1.render(f5);
        GlStateManager.popMatrix();
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	this.Leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.Leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.Leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

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
