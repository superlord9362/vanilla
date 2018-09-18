package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Penguin - JJo
 * Created using Tabula 5.1.0
 */
public class Penguin extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer rightwing;
    public ModelRenderer leftwing;
    public ModelRenderer Tail;
    public ModelRenderer Head;
    public ModelRenderer rightfoot;
    public ModelRenderer leftfoot;
    public ModelRenderer UpperBeak;
    public ModelRenderer LowerBeak;

    public Penguin(float scaleFactor) {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rightfoot = new ModelRenderer(this, 9, 14);
        this.rightfoot.setRotationPoint(0.5F, 0.5F, 1.0F);
        this.rightfoot.addBox(-1.75F, 0.0F, -3.0F, 3, 1, 3, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 0);
        this.leftleg.setRotationPoint(4.25F, 9.0F, 2.0F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rightwing = new ModelRenderer(this, 0, 14);
        this.rightwing.mirror = true;
        this.rightwing.setRotationPoint(0.0F, 0.5F, 0.5F);
        this.rightwing.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(rightwing, 0.07853981633974483F, 0.0F, 0.05235987755982988F);
        this.leftwing = new ModelRenderer(this, 0, 14);
        this.leftwing.setRotationPoint(6.0F, 0.5F, 0.5F);
        this.leftwing.addBox(0.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(leftwing, 0.07853981633974483F, 0.0F, -0.05235987755982988F);
        this.LowerBeak = new ModelRenderer(this, 32, 9);
        this.LowerBeak.mirror = true;
        this.LowerBeak.setRotationPoint(2.5F, -1.25F, -2.7F);
        this.LowerBeak.addBox(-3.5F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.leftfoot = new ModelRenderer(this, 9, 14);
        this.leftfoot.mirror = true;
        this.leftfoot.setRotationPoint(0.5F, 0.5F, 1.0F);
        this.leftfoot.addBox(-1.25F, 0.0F, -3.0F, 3, 1, 3, 0.0F);
        this.Head = new ModelRenderer(this, 22, 0);
        this.Head.setRotationPoint(3.0F, 0.0F, 2.5F);
        this.Head.addBox(-2.5F, -4.0F, -2.5F, 5, 4, 5, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-3.5F, 13.500000000000009F, -2.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6, 9, 5, 0.0F);
        this.UpperBeak = new ModelRenderer(this, 22, 9);
        this.UpperBeak.mirror = true;
        this.UpperBeak.setRotationPoint(2.5F, -1.25F, -2.75F);
        this.UpperBeak.addBox(-3.5F, -1.0F, -2.5F, 2, 1, 3, 0.0F);
        this.Tail = new ModelRenderer(this, 11, 19);
        this.Tail.setRotationPoint(3.0F, 7.6F, 4.6F);
        this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Tail, -0.4553564018453206F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 0);
        this.rightleg.setRotationPoint(0.75F, 9.0F, 2.0F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rightleg.addChild(this.rightfoot);
        this.Body.addChild(this.leftleg);
        this.Body.addChild(this.rightwing);
        this.Body.addChild(this.leftwing);
        this.Head.addChild(this.LowerBeak);
        this.leftleg.addChild(this.leftfoot);
        this.Body.addChild(this.Head);
        this.Head.addChild(this.UpperBeak);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.rightleg);
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
    	
    	this.rightfoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.leftfoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }
}
