package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Goat - West
 * Created using Tabula 5.0.0
 */
public class ModelGoat extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer leftfrontleg;
    public ModelRenderer rightfrontleg;
    public ModelRenderer leftbackleg;
    public ModelRenderer rightbackleg;
    public ModelRenderer Neck;
    public ModelRenderer neck2;
    public ModelRenderer Head;
    public ModelRenderer Righthorn;
    public ModelRenderer lefthorn;

    public ModelGoat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Righthorn = new ModelRenderer(this, 60, 0);
        this.Righthorn.setRotationPoint(0.1F, -1.8F, -0.67F);
        this.Righthorn.addBox(1.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Righthorn, -0.8651597102135892F, 0.27314402793711257F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -6.0F, 2.0F);
        this.Head.addBox(-0.9F, -1.9F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Head, -0.18203784098300857F, 0.0F, 0.0F);
        this.rightbackleg = new ModelRenderer(this, 56, 17);
        this.rightbackleg.setRotationPoint(0.3F, 6.0F, 9.7F);
        this.rightbackleg.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.neck2 = new ModelRenderer(this, 40, 21);
        this.neck2.setRotationPoint(-1.2F, 0.0F, 0.0F);
        this.neck2.addBox(0.0F, -6.0F, -2.0F, 2, 7, 4, 0.0F);
        this.Body = new ModelRenderer(this, 28, 14);
        this.Body.setRotationPoint(-3.0F, 13.0F, -7.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6, 6, 12, 0.0F);
        this.leftbackleg = new ModelRenderer(this, 56, 17);
        this.leftbackleg.setRotationPoint(3.7F, 6.0F, 9.7F);
        this.leftbackleg.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.lefthorn = new ModelRenderer(this, 60, 0);
        this.lefthorn.setRotationPoint(0.1F, -1.8F, -0.67F);
        this.lefthorn.addBox(-1.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lefthorn, -0.8651597102135892F, -0.27314402793711257F, 0.0F);
        this.rightfrontleg = new ModelRenderer(this, 56, 17);
        this.rightfrontleg.setRotationPoint(0.3F, 6.0F, 0.3F);
        this.rightfrontleg.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 40, 21);
        this.Neck.setRotationPoint(3.6F, 1.8F, 1.2F);
        this.Neck.addBox(-2.0F, -6.0F, -2.0F, 2, 7, 4, 0.0F);
        this.setRotateAngle(Neck, 0.6373942428283291F, 0.0F, 0.0F);
        this.leftfrontleg = new ModelRenderer(this, 56, 17);
        this.leftfrontleg.setRotationPoint(3.7F, 6.0F, 0.3F);
        this.leftfrontleg.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.Tail = new ModelRenderer(this, 31, 20);
        this.Tail.setRotationPoint(3.0F, 0.6F, 11.4F);
        this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(Tail, 0.27314402793711257F, 0.0F, 0.0F);
        this.Head.addChild(this.Righthorn);
        this.neck2.addChild(this.Head);
        this.Body.addChild(this.rightbackleg);
        this.Neck.addChild(this.neck2);
        this.Body.addChild(this.leftbackleg);
        this.Head.addChild(this.lefthorn);
        this.Body.addChild(this.rightfrontleg);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.leftfrontleg);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {

    	float XAngle = headPitch / 57.29578F;

    	float YAngle = netHeadYaw / 57.29578F;

    	

    	

    	this.Head.rotateAngleX= (0.2617794F + XAngle);

    	this.Head.rotateAngleY= YAngle;

    	

    	this.rightbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.leftbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

    	this.leftfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    	this.rightfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

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
