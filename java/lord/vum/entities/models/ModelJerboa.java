package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Jerboa - Undefined
 * Created using Tabula 5.0.0
 */
public class ModelJerboa extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer head;
    public ModelRenderer tail1;
    public ModelRenderer arms;
    public ModelRenderer hips;
    public ModelRenderer nose;
    public ModelRenderer rightear;
    public ModelRenderer leftear;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer tailpoof;
    public ModelRenderer rightupperleg;
    public ModelRenderer leftupperleg;
    public ModelRenderer rightlowerleg;
    public ModelRenderer rightfoot;
    public ModelRenderer leftlowerleg;
    public ModelRenderer leftfoot;


	protected float childYOffset = 8.0F;

	protected float childZOffset = 4.0F;

    public ModelJerboa() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.tail3 = new ModelRenderer(this, 39, 6);
        this.tail3.setRotationPoint(0.0F, 0.3F, 3.2F);
        this.tail3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail3, 0.8651597102135892F, 0.0F, 0.0F);
        this.rightear = new ModelRenderer(this, 39, 0);
        this.rightear.mirror = true;
        this.rightear.setRotationPoint(-0.4F, -1.5F, -2.0F);
        this.rightear.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightear, 1.0927506446736497F, 0.0F, -0.4553564018453205F);
        this.leftupperleg = new ModelRenderer(this, 6, 1);
        this.leftupperleg.setRotationPoint(2.9F, 0.9F, 1.9F);
        this.leftupperleg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.Body = new ModelRenderer(this, 12, 0);
        this.Body.setRotationPoint(-0.45F, 21.8F, -1.1F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(Body, -0.18203784098300857F, 0.0F, 0.0F);
        this.rightfoot = new ModelRenderer(this, 15, 8);
        this.rightfoot.mirror = true;
        this.rightfoot.setRotationPoint(-0.75F, 5.7F, -0.8F);
        this.rightfoot.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(rightfoot, 0.7285004297824331F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 26, 1);
        this.head.setRotationPoint(1.5F, 1.3F, 0.2F);
        this.head.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 0.22759093446006054F, 0.0F, 0.0F);
        this.tailpoof = new ModelRenderer(this, 27, 7);
        this.tailpoof.setRotationPoint(-0.5F, -0.5F, 3.7F);
        this.tailpoof.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tailpoof, 0.18203784098300857F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 24, 1);
        this.nose.setRotationPoint(-0.5F, -0.5F, -4.0F);
        this.nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.leftlowerleg = new ModelRenderer(this, 2, 1);
        this.leftlowerleg.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.leftlowerleg.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(leftlowerleg, -0.5462880558742251F, 0.0F, 0.0F);
        this.rightlowerleg = new ModelRenderer(this, 2, 1);
        this.rightlowerleg.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rightlowerleg.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rightlowerleg, -0.5462880558742251F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 39, 6);
        this.tail2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail2, -0.8196066167365371F, 0.0F, 0.0F);
        this.arms = new ModelRenderer(this, 36, 0);
        this.arms.setRotationPoint(1.0F, 3.3F, -0.9F);
        this.arms.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(arms, 0.6829473363053812F, 0.0F, 0.0F);
        this.rightupperleg = new ModelRenderer(this, 6, 1);
        this.rightupperleg.setRotationPoint(0.1F, 0.9F, 1.9F);
        this.rightupperleg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.tail1 = new ModelRenderer(this, 39, 6);
        this.tail1.setRotationPoint(1.0F, 0.5F, 3.9F);
        this.tail1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail1, 0.136659280431156F, 0.0F, 0.0F);
        this.leftfoot = new ModelRenderer(this, 15, 8);
        this.leftfoot.setRotationPoint(-0.3F, 5.7F, -0.8F);
        this.leftfoot.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(leftfoot, 0.7285004297824331F, 0.0F, 0.0F);
        this.hips = new ModelRenderer(this, 50, 2);
        this.hips.setRotationPoint(-0.5F, 0.9F, 1.9F);
        this.hips.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.leftear = new ModelRenderer(this, 39, 0);
        this.leftear.setRotationPoint(0.4F, -1.5F, -2.0F);
        this.leftear.addBox(0.0F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(leftear, 1.0927506446736497F, 0.0F, 0.4553564018453205F);
        this.tail2.addChild(this.tail3);
        this.head.addChild(this.rightear);
        this.hips.addChild(this.leftupperleg);
        this.rightlowerleg.addChild(this.rightfoot);
        this.Body.addChild(this.head);
        this.tail3.addChild(this.tailpoof);
        this.head.addChild(this.nose);
        this.leftupperleg.addChild(this.leftlowerleg);
        this.rightupperleg.addChild(this.rightlowerleg);
        this.tail1.addChild(this.tail2);
        this.Body.addChild(this.arms);
        this.hips.addChild(this.rightupperleg);
        this.Body.addChild(this.tail1);
        this.leftlowerleg.addChild(this.leftfoot);
        this.Body.addChild(this.hips);
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

            GlStateManager.scale(0.1F, 0.1F, 0.1F);

            GlStateManager.translate(0.0F, 210.0F * f5, 0.0F);

            this.Body.render(f5);

            GlStateManager.popMatrix();

        }

        else {

		GlStateManager.pushMatrix();

		GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);

		GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5,

				this.Body.rotationPointZ * f5);

		GlStateManager.scale(0.3D, 0.3D, 0.3D);

		GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);

		GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5,

				-this.Body.rotationPointZ * f5);

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
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,

			float headPitch, float scaleFactor, Entity entity) {

		float XAngle = headPitch / 57.29578F;

		float YAngle = netHeadYaw / 57.29578F;



		this.head.rotateAngleX = (0.2617794F + XAngle);

		this.head.rotateAngleY = YAngle;



		this.hips.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

	}
}
