package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Beaver - Anomalocaris101
 * Created using Tabula 7.0.0
 */
public class Beaver extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer tail;
    public ModelRenderer Head;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer Teeth;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Beaver() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.Body.addBox(-3.5F, -3.5F, -5.0F, 7, 7, 11, 0.0F);
        this.tail = new ModelRenderer(this, 27, 9);
        this.tail.setRotationPoint(0.0F, -1.0F, 4.5F);
        this.tail.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 9, 0.0F);
        this.setRotateAngle(tail, -0.5235987755982988F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 25, 3);
        this.Leg2.setRotationPoint(-1.9F, 3.0F, -2.8F);
        this.Leg2.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.Leg4 = new ModelRenderer(this, 37, 2);
        this.Leg4.setRotationPoint(2.2F, 2.0F, 4.0F);
        this.Leg4.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Head.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 5, 0.0F);
        this.Leg3 = new ModelRenderer(this, 37, 2);
        this.Leg3.setRotationPoint(-2.2F, 2.0F, 4.0F);
        this.Leg3.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.Teeth = new ModelRenderer(this, 0, 10);
        this.Teeth.setRotationPoint(0.0F, 3.0F, -5.0F);
        this.Teeth.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 0, 0.0F);
        this.Leg1 = new ModelRenderer(this, 25, 3);
        this.Leg1.setRotationPoint(1.9F, 3.0F, -2.8F);
        this.Leg1.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.Body.addChild(this.tail);
        this.Body.addChild(this.Leg2);
        this.Body.addChild(this.Leg4);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Leg3);
        this.Head.addChild(this.Teeth);
        this.Body.addChild(this.Leg1);
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

            this.Body.render(f5);

            GlStateManager.popMatrix();

        } else {
        this.Body.render(f5);
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
}
