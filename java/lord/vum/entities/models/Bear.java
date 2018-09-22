package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Bear - Jaz
 * Created using Tabula 5.0.0
 */
public class Bear extends ModelBase {
    public ModelRenderer body2;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leftlegfront;
    public ModelRenderer rightlegfront;
    public ModelRenderer rightlegback;
    public ModelRenderer leftlegback;
    public ModelRenderer tail;
    public ModelRenderer snout;
    public ModelRenderer leftear;
    public ModelRenderer rightear;

    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Bear() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.rightear = new ModelRenderer(this, 59, 0);
        this.rightear.setRotationPoint(2.5F, -3.0F, -4.0F);
        this.rightear.addBox(0.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.snout = new ModelRenderer(this, 184, 0);
        this.snout.setRotationPoint(0.0F, 2.0F, -5.0F);
        this.snout.addBox(-2.5F, -1.5F, -5.0F, 5, 3, 5, 0.0F);
        this.body = new ModelRenderer(this, 52, 0);
        this.body.setRotationPoint(0.0F, -0.5F, 12.0F);
        this.body.addBox(-7.0F, -6.0F, 0.0F, 14, 12, 14, 0.0F);
        this.head = new ModelRenderer(this, 38, 0);
        this.head.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.head.addBox(-3.5F, -3.5F, -7.0F, 7, 7, 7, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 0);
        this.body2.setRotationPoint(1.0F, 10.0F, -13.0F);
        this.body2.addBox(-6.0F, -5.5F, 0.0F, 12, 11, 14, 0.0F);
        this.rightlegfront = new ModelRenderer(this, 126, 0);
        this.rightlegfront.setRotationPoint(-4.0F, 4.0F, 4.5F);
        this.rightlegfront.addBox(-2.0F, 0.0F, -2.5F, 4, 10, 5, 0.0F);
        this.leftlegback = new ModelRenderer(this, 164, 0);
        this.leftlegback.setRotationPoint(-5.0F, 4.5F, 9.5F);
        this.leftlegback.addBox(-2.0F, 0.0F, -3.0F, 4, 10, 6, 0.0F);
        this.tail = new ModelRenderer(this, 0, 0);
        this.tail.setRotationPoint(0.0F, -2.0F, 13.0F);
        this.tail.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(tail, 0.5462880558742251F, 0.0F, 0.0F);
        this.rightlegback = new ModelRenderer(this, 144, 0);
        this.rightlegback.setRotationPoint(5.0F, 4.5F, 9.5F);
        this.rightlegback.addBox(-2.0F, 0.0F, -3.0F, 4, 10, 6, 0.0F);
        this.leftlegfront = new ModelRenderer(this, 108, 0);
        this.leftlegfront.setRotationPoint(4.0F, 4.0F, 4.5F);
        this.leftlegfront.addBox(-2.0F, 0.0F, -2.5F, 4, 10, 5, 0.0F);
        this.leftear = new ModelRenderer(this, 38, 0);
        this.leftear.setRotationPoint(-2.5F, -3.0F, -4.0F);
        this.leftear.addBox(-2.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.head.addChild(this.rightear);
        this.head.addChild(this.snout);
        this.body2.addChild(this.body);
        this.body2.addChild(this.head);
        this.body2.addChild(this.rightlegfront);
        this.body.addChild(this.leftlegback);
        this.body.addChild(this.tail);
        this.body.addChild(this.rightlegback);
        this.body2.addChild(this.leftlegfront);
        this.head.addChild(this.leftear);
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

            this.body2.render(f5);

            GlStateManager.popMatrix();

        }

        else {

	this.body2.render(f5);
        }
}
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.head.rotateAngleX= (0.2617794F + XAngle);

    	this.head.rotateAngleY= YAngle;

    	

    	this.rightlegback.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.leftlegback.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.leftlegfront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.rightlegfront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

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
