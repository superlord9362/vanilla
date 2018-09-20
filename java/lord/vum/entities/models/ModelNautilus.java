package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Nautilus - West
 * Created using Tabula 5.0.0
 */
public class ModelNautilus extends ModelBase {
	public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape6;
    public ModelRenderer tentacle_horizontal_right_1;
    public ModelRenderer tentacle_horizontal_left_1;
    public ModelRenderer tentacle_vertical_down_1;
    public ModelRenderer tentacle_vertical_up_1;
    public ModelRenderer tentacle_vertical_up_2;
    public ModelRenderer tentacle_vertical_down_2;
    public ModelRenderer tentacle_horizontal_right_2;
    public ModelRenderer tentacle_horizontal_left_2;

    public ModelNautilus() {
    	float totaloffsetX =-2;
    	float totaloffsetZ=-3.5f;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape6 = new ModelRenderer(this, 40, 7);
        this.shape6.setRotationPoint(1.1F, 2.7F, 6.2F);
        this.shape6.addBox(0.0F+totaloffsetX, 0.0F, 0.0F+totaloffsetZ, 2, 4, 3, 0.0F);
        this.tentacle_horizontal_right_1 = new ModelRenderer(this, 0, 0);
        this.tentacle_horizontal_right_1.setRotationPoint(0.0F+totaloffsetX, 3.5F, 3.0F+totaloffsetZ);
        this.tentacle_horizontal_right_1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(tentacle_horizontal_right_1, 0.136659280431156F, -0.18203784098300857F, 0.0F);
        //this.tentacle_vertical_down_2 = new ModelRenderer(this, 0, 0);
        //this.tentacle_vertical_down_2.setRotationPoint(0.5F, 3.5F, 3.0F);
        //this.tentacle_vertical_down_2.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        //this.setRotateAngle(tentacle_vertical_down_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.tentacle_horizontal_left_1 = new ModelRenderer(this, 0, 0);
        this.tentacle_horizontal_left_1.setRotationPoint(2.0F+totaloffsetX, 3.5F, 3.0F+totaloffsetZ);
        this.tentacle_horizontal_left_1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(tentacle_horizontal_left_1, 0.0F, 0.18203784098300857F, 0.0F);
        this.tentacle_vertical_down_1 = new ModelRenderer(this, 0, 0);
        this.tentacle_vertical_down_1.setRotationPoint(0.5F+totaloffsetX, 4.0F, 3.0F+totaloffsetZ);
        this.tentacle_vertical_down_1.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(tentacle_vertical_down_1, -0.18203784098300857F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 16.9F, 0.0F);
        this.shape1.addBox(0.0F+totaloffsetX, 0.0F, 0.0F+totaloffsetZ, 4, 7, 7, 0.0F);
        this.tentacle_vertical_up_1 = new ModelRenderer(this, 0, 0);
        this.tentacle_vertical_up_1.setRotationPoint(0.5F+totaloffsetX, 3.0F, 3.0F+totaloffsetZ);
        this.tentacle_vertical_up_1.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(tentacle_vertical_up_1, 0.18203784098300857F, 0.0F, 0.0F);
        this.tentacle_horizontal_left_2 = new ModelRenderer(this, 0, 0);
        this.tentacle_horizontal_left_2.setRotationPoint(2.0F+totaloffsetX, 3.0F, 3.0F+totaloffsetZ);
        this.tentacle_horizontal_left_2.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(tentacle_horizontal_left_2, 0.0F, -0.091106186954104F, 0.0F);
        this.tentacle_horizontal_right_2 = new ModelRenderer(this, 0, 0);
        this.tentacle_horizontal_right_2.setRotationPoint(0.0F+totaloffsetX, 3.5F, 3.0F+totaloffsetZ);
        this.tentacle_horizontal_right_2.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(tentacle_horizontal_right_2, 0.0F, 0.091106186954104F, 0.0F);
        this.shape2 = new ModelRenderer(this, 22, 6);
        this.shape2.setRotationPoint(0.5F, 0.4F, 6.0F);
        this.shape2.addBox(0.0F+totaloffsetX, 1.8F, 0.0F-2.6f, 3, 2, 6, 0.0F);
        this.setRotateAngle(shape2, -0.5918411493512771F, 0.0F, 0.0F);
        //this.tentacle_vertical_up_2 = new ModelRenderer(this, 0, 0);
        //this.tentacle_vertical_up_2.setRotationPoint(0.5F, 3.5F, 3.0F);
        //this.tentacle_vertical_up_2.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        //this.setRotateAngle(tentacle_vertical_up_2, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape1.addChild(this.shape6);
        this.shape6.addChild(this.tentacle_horizontal_right_1);
        //this.shape6.addChild(this.tentacle_vertical_down_2);
        this.shape6.addChild(this.tentacle_horizontal_left_1);
        this.shape6.addChild(this.tentacle_vertical_down_1);
        this.shape6.addChild(this.tentacle_vertical_up_1);
        this.shape6.addChild(this.tentacle_horizontal_left_2);
        this.shape6.addChild(this.tentacle_horizontal_right_2);
        this.shape1.addChild(this.shape2);
        //this.shape6.addChild(this.tentacle_vertical_up_2);
    }
	@Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
		tentacle_horizontal_right_1.rotateAngleY=-ageInTicks+-0.18203784098300857F;
		tentacle_horizontal_right_2.rotateAngleY=-ageInTicks+0.091106186954104f;
		tentacle_horizontal_left_1.rotateAngleY=ageInTicks+0.18203784098300857F;
		tentacle_horizontal_left_2.rotateAngleY=ageInTicks-0.091106186954104F;
		tentacle_vertical_up_1.rotateAngleX=ageInTicks+0.18203784098300857F;
		//tentacle_vertical_up_2.rotateAngleX=ageInTicks+0.22759093446006054F;
		tentacle_vertical_down_1.rotateAngleX=-ageInTicks-0.18203784098300857F;
		//tentacle_vertical_down_2.rotateAngleX=-ageInTicks-0.22759093446006054F;
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
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
