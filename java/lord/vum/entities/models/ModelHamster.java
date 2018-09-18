package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelHamster - JJo
 * Created using Tabula 5.0.0
 */
public class ModelHamster extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;
    public ModelRenderer Nose;


    protected float childYOffset = 8.0F;

    protected float childZOffset = 4.0F;

    public ModelHamster() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.FrontRightLeg = new ModelRenderer(this, 11, 3);
        this.FrontRightLeg.setRotationPoint(-0.75F, 2.9F, 0.75F);
        this.FrontRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 11, 3);
        this.BackLeftLeg.mirror = true;
        this.BackLeftLeg.setRotationPoint(0.75F, 2.9F, 4.25F);
        this.BackLeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 2);
        this.Nose.setRotationPoint(0.0F, 0.3F, -3.2F);
        this.Nose.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.LeftEar = new ModelRenderer(this, 11, 0);
        this.LeftEar.mirror = true;
        this.LeftEar.setRotationPoint(0.35F, -1.3F, -0.1F);
        this.LeftEar.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.Head = new ModelRenderer(this, 0, 8);
        this.Head.setRotationPoint(0.0F, 1.3F, 0.1F);
        this.Head.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 11, 3);
        this.FrontLeftLeg.mirror = true;
        this.FrontLeftLeg.setRotationPoint(0.75F, 2.9F, 0.75F);
        this.FrontLeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 11, 3);
        this.BackRightLeg.setRotationPoint(-0.75F, 2.9F, 4.25F);
        this.BackRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.RightEar = new ModelRenderer(this, 11, 0);
        this.RightEar.setRotationPoint(-0.35F, -1.3F, -0.1F);
        this.RightEar.addBox(-1.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.Body.addChild(this.FrontRightLeg);
        this.Body.addChild(this.BackLeftLeg);
        this.Head.addChild(this.Nose);
        this.Head.addChild(this.LeftEar);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.FrontLeftLeg);
        this.Body.addChild(this.BackRightLeg);
        this.Head.addChild(this.RightEar);
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

            GlStateManager.scale(0.2F, 0.2F, 0.2F);

            GlStateManager.translate(0.0F, 93.0F * f5, 0.0F);

            this.Body.render(f5);

            GlStateManager.popMatrix();

        } else {

        GlStateManager.pushMatrix();

        GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);

        GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);

        GlStateManager.scale(0.5D, 0.5D, 0.5D);

        GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);

        GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5, -this.Body.rotationPointZ * f5);

        this.Body.render(f5);

        GlStateManager.popMatrix();

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

    

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.Head.rotateAngleX= (0.2617794F + XAngle);

    	this.Head.rotateAngleY= YAngle;

    	

    	this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    }
}
