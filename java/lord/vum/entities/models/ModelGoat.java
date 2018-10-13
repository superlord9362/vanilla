package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Goat - Undefined
 * Created using Tabula 5.0.0
 */
public class ModelGoat extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer leg;
    public ModelRenderer leg_1;
    public ModelRenderer leg_2;
    public ModelRenderer leg_3;
    public ModelRenderer neck;
    public ModelRenderer leg_4;
    public ModelRenderer leg_5;
    public ModelRenderer leg_6;
    public ModelRenderer leg_7;
    public ModelRenderer head;
    public ModelRenderer snout;
    public ModelRenderer horn;
    public ModelRenderer horn_1;
    public ModelRenderer ear;
    public ModelRenderer ear_1;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public ModelGoat() {
        this.textureWidth = 100;
        this.textureHeight = 100;
        this.leg_6 = new ModelRenderer(this, 0, 0);
        this.leg_6.setRotationPoint(-1.0F, 4.5F, -1.0F);
        this.leg_6.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.leg_5 = new ModelRenderer(this, 0, 0);
        this.leg_5.setRotationPoint(-0.5F, 3.0F, -1.0F);
        this.leg_5.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.neck = new ModelRenderer(this, 0, 26);
        this.neck.setRotationPoint(3.5F, 2.0F, 4.0F);
        this.neck.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(neck, -2.5497515042385164F, 0.0F, 0.0F);
        this.leg_7 = new ModelRenderer(this, 0, 0);
        this.leg_7.setRotationPoint(-1.0F, 4.5F, -1.0F);
        this.leg_7.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.leg_2 = new ModelRenderer(this, 60, 0);
        this.leg_2.setRotationPoint(1.1F, 6.0F, 12.0F);
        this.leg_2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.ear_1 = new ModelRenderer(this, 0, 52);
        this.ear_1.setRotationPoint(-1.0F, 2.0F, 0.2F);
        this.ear_1.addBox(0.0F, 0.0F, 1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(ear_1, 3.141592653589793F, 0.0F, -2.321986036853256F);
        this.leg_3 = new ModelRenderer(this, 60, 0);
        this.leg_3.setRotationPoint(5.9F, 6.0F, 12.0F);
        this.leg_3.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.horn_1 = new ModelRenderer(this, 32, 0);
        this.horn_1.setRotationPoint(-1.6F, 3.1F, 1.6F);
        this.horn_1.addBox(0.0F, 0.0F, -2.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(horn_1, -0.8651597102135892F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-3.5F, 8.6F, -6.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 7, 9, 14, 0.0F);
        this.leg_4 = new ModelRenderer(this, 0, 0);
        this.leg_4.setRotationPoint(-0.5F, 3.0F, -1.0F);
        this.leg_4.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.snout = new ModelRenderer(this, 20, 39);
        this.snout.setRotationPoint(-1.5F, -0.9F, 2.0F);
        this.snout.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.head = new ModelRenderer(this, 0, 39);
        this.head.setRotationPoint(0.0F, 6.3F, 2.7F);
        this.head.addBox(-2.0F, -1.0F, -3.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(head, -0.5918411493512771F, 0.0F, 0.0F);
        this.horn = new ModelRenderer(this, 32, 0);
        this.horn.setRotationPoint(0.6F, 3.1F, 1.6F);
        this.horn.addBox(0.0F, 0.0F, -2.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(horn, -0.8651597102135892F, 0.0F, 0.0F);
        this.leg_1 = new ModelRenderer(this, 43, 0);
        this.leg_1.setRotationPoint(5.1F, 7.4F, 1.8F);
        this.leg_1.addBox(-1.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.leg = new ModelRenderer(this, 43, 0);
        this.leg.setRotationPoint(0.9F, 7.4F, 1.8F);
        this.leg.addBox(-1.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.ear = new ModelRenderer(this, 0, 52);
        this.ear.setRotationPoint(0.9F, 2.2F, 0.2F);
        this.ear.addBox(0.0F, 0.0F, -3.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(ear, 0.0F, 0.0F, -0.8651597102135892F);
        this.leg_2.addChild(this.leg_6);
        this.leg_1.addChild(this.leg_5);
        this.body.addChild(this.neck);
        this.leg_3.addChild(this.leg_7);
        this.body.addChild(this.leg_2);
        this.head.addChild(this.ear_1);
        this.body.addChild(this.leg_3);
        this.head.addChild(this.horn_1);
        this.leg.addChild(this.leg_4);
        this.head.addChild(this.snout);
        this.neck.addChild(this.head);
        this.head.addChild(this.horn);
        this.body.addChild(this.leg_1);
        this.body.addChild(this.leg);
        this.head.addChild(this.ear);
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

            this.body.render(f5);

            GlStateManager.popMatrix();

        } else {
        this.body.render(f5);
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.head.rotateAngleX= (0.2617794F + XAngle);

    	this.head.rotateAngleY= YAngle;

    	

    	this.leg_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.leg_2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.leg_3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.leg_4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

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
