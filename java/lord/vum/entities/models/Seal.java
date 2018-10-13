package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Seal-o - West
 * Created using Tabula 5.0.0
 */
public class Seal extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer tail1;
    public ModelRenderer body2;
    public ModelRenderer tail2;
    public ModelRenderer finjoint;
    public ModelRenderer rightfin;
    public ModelRenderer leftfin;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer Neck;
    public ModelRenderer Head;
    public ModelRenderer neck2;
    public ModelRenderer Nose;

    public Seal() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body2 = new ModelRenderer(this, 40, 20);
        this.body2.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.body2.addBox(-2.5F, -2.5F, -7.0F, 5, 5, 7, 0.0F);
        this.setRotateAngle(body2, 0.045553093477052F, 0.0F, 0.0F);
        this.leftfin = new ModelRenderer(this, 42, 26);
        this.leftfin.setRotationPoint(-0.1F, -0.2F, 1.0F);
        this.leftfin.addBox(0.0F, -0.5F, 0.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(leftfin, -0.22759093446006054F, 0.7740535232594852F, 0.0F);
        this.Nose = new ModelRenderer(this, 16, 7);
        this.Nose.setRotationPoint(0.5F, 4.0F, 1.0F);
        this.Nose.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.Body = new ModelRenderer(this, 32, 16);
        this.Body.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.Body.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 10, 0.0F);
        this.neck2 = new ModelRenderer(this, 42, 21);
        this.neck2.setRotationPoint(0.0F, -2.0F, 4.8F);
        this.neck2.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.finjoint = new ModelRenderer(this, 37, 28);
        this.finjoint.setRotationPoint(1.0F, 0.2F, 4.3F);
        this.finjoint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rightfin = new ModelRenderer(this, 32, 26);
        this.rightfin.setRotationPoint(1.2F, -0.2F, 1.0F);
        this.rightfin.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(rightfin, -0.22759093446006054F, -0.7740535232594852F, 0.0F);
        this.tail1 = new ModelRenderer(this, 42, 20);
        this.tail1.setRotationPoint(0.0F, 0.0F, 4.8F);
        this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 5, 7, 0.0F);
        this.setRotateAngle(tail1, -0.045553093477052F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 29, 7);
        this.rightarm.setRotationPoint(-2.5F, 0.0F, -5.9F);
        this.rightarm.addBox(-6.0F, 0.0F, 0.0F, 6, 1, 4, 0.0F);
        this.setRotateAngle(rightarm, -0.136659280431156F, 0.136659280431156F, -0.27314402793711257F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-2.5F, 3.2F, 4.6F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Head, 2.0032889154390916F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 44, 22);
        this.tail2.setRotationPoint(-1.5F, 0.4F, 6.8F);
        this.tail2.addBox(0.0F, -2.0F, 0.0F, 3, 4, 6, 0.0F);
        this.setRotateAngle(tail2, 0.045553093477052F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 29, 0);
        this.leftarm.setRotationPoint(2.5F, 0.0F, -5.9F);
        this.leftarm.addBox(0.0F, 0.0F, 0.0F, 6, 1, 4, 0.0F);
        this.setRotateAngle(leftarm, -0.136659280431156F, -0.136659280431156F, 0.27314402793711257F);
        this.Neck = new ModelRenderer(this, 45, 22);
        this.Neck.setRotationPoint(0.5F, 0.3F, -5.5F);
        this.Neck.addBox(-2.0F, -2.0F, 0.0F, 3, 5, 5, 0.0F);
        this.setRotateAngle(Neck, 2.6406831582674206F, 0.0F, 0.0F);
        this.Body.addChild(this.body2);
        this.finjoint.addChild(this.leftfin);
        this.Head.addChild(this.Nose);
        this.Neck.addChild(this.neck2);
        this.tail2.addChild(this.finjoint);
        this.finjoint.addChild(this.rightfin);
        this.Body.addChild(this.tail1);
        this.body2.addChild(this.rightarm);
        this.Neck.addChild(this.Head);
        this.tail1.addChild(this.tail2);
        this.body2.addChild(this.leftarm);
        this.body2.addChild(this.Neck);
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
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,

			float headPitch, float scaleFactor, Entity entity) {

		float XAngle = headPitch / 57.29578F;

		float YAngle = netHeadYaw / 57.29578F;



		this.Head.rotateAngleX = (0.2617794F + XAngle);

		this.Head.rotateAngleY = YAngle;



		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;



	}
}
