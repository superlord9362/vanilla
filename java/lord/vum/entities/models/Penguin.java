package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Penguin VU - Anomalocaris101
 * Created using Tabula 7.0.0
 */
public class Penguin extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer feet;
    public ModelRenderer feet_1;
    public ModelRenderer Wing;
    public ModelRenderer Wing_1;
    public ModelRenderer tail;
    public ModelRenderer Head;
    public ModelRenderer shape8;
    public ModelRenderer Eyelashes;
    public ModelRenderer Eyelashes_1;
    public ModelRenderer Eyelashes_2;
    public ModelRenderer Eyelashes_3;

    public Penguin() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.feet_1 = new ModelRenderer(this, 0, 15);
        this.feet_1.setRotationPoint(2.0F, 4.5F, -0.5F);
        this.feet_1.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(feet_1, 0.0F, -0.3490658503988659F, 0.0F);
        this.Head = new ModelRenderer(this, 22, 0);
        this.Head.setRotationPoint(0.0F, -5.0F, -0.5F);
        this.Head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F);
        this.Eyelashes_1 = new ModelRenderer(this, 0, 2);
        this.Eyelashes_1.setRotationPoint(2.0F, -2.5F, -0.7F);
        this.Eyelashes_1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Eyelashes_1, 0.3490658503988659F, 0.3490658503988659F, 0.0F);
        this.Wing = new ModelRenderer(this, 0, 19);
        this.Wing.setRotationPoint(2.8F, -4.5F, 0.0F);
        this.Wing.addBox(0.0F, 0.0F, -2.0F, 1, 7, 4, 0.0F);
        this.Eyelashes = new ModelRenderer(this, 0, 2);
        this.Eyelashes.setRotationPoint(2.0F, -2.5F, -1.0F);
        this.Eyelashes.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Eyelashes, 0.8726646259971648F, 0.3490658503988659F, 0.0F);
        this.Eyelashes_2 = new ModelRenderer(this, 0, 2);
        this.Eyelashes_2.setRotationPoint(-2.0F, -2.5F, -1.0F);
        this.Eyelashes_2.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Eyelashes_2, 0.8726646259971648F, -0.3490658503988659F, 0.0F);
        this.feet = new ModelRenderer(this, 0, 15);
        this.feet.setRotationPoint(-2.0F, 4.5F, -0.5F);
        this.feet.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(feet, 0.0F, 0.3490658503988659F, 0.0F);
        this.shape8 = new ModelRenderer(this, 22, 8);
        this.shape8.setRotationPoint(0.0F, -1.4F, -1.8F);
        this.shape8.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
        this.Eyelashes_3 = new ModelRenderer(this, 0, 2);
        this.Eyelashes_3.setRotationPoint(-2.0F, -2.5F, -0.7F);
        this.Eyelashes_3.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Eyelashes_3, 0.3490658503988659F, -0.3490658503988659F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.5F, 0.0F);
        this.Body.addBox(-3.0F, -5.0F, -2.5F, 6, 10, 5, 0.0F);
        this.tail = new ModelRenderer(this, 12, 15);
        this.tail.setRotationPoint(0.0F, 3.5F, 1.2F);
        this.tail.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.Wing_1 = new ModelRenderer(this, 0, 19);
        this.Wing_1.mirror = true;
        this.Wing_1.setRotationPoint(-2.8F, -4.5F, 0.0F);
        this.Wing_1.addBox(-1.0F, 0.0F, -2.0F, 1, 7, 4, 0.0F);
        this.Body.addChild(this.feet_1);
        this.Body.addChild(this.Head);
        this.Head.addChild(this.Eyelashes_1);
        this.Body.addChild(this.Wing);
        this.Head.addChild(this.Eyelashes);
        this.Head.addChild(this.Eyelashes_2);
        this.Body.addChild(this.feet);
        this.Head.addChild(this.shape8);
        this.Head.addChild(this.Eyelashes_3);
        this.Body.addChild(this.tail);
        this.Body.addChild(this.Wing_1);
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
    	
    	this.feet.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.feet_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }
}
