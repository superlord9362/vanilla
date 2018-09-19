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
    public ModelRenderer shape7;
    public ModelRenderer shape7_1;
    public ModelRenderer shape7_2;
    public ModelRenderer shape7_3;
    public ModelRenderer shape7_4;
    public ModelRenderer shape7_5;
    public ModelRenderer shape7_6;
    public ModelRenderer shape7_7;

    public ModelNautilus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape7_5 = new ModelRenderer(this, 0, 0);
        this.shape7_5.setRotationPoint(0.5F, 3.5F, 3.0F);
        this.shape7_5.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(shape7_5, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 22, 6);
        this.shape2.setRotationPoint(0.5F, 0.4F, 6.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(shape2, -0.5918411493512771F, 0.0F, 0.0F);
        this.shape7_1 = new ModelRenderer(this, 0, 0);
        this.shape7_1.setRotationPoint(2.0F, 3.5F, 3.0F);
        this.shape7_1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(shape7_1, 0.0F, 0.18203784098300857F, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(0.0F, 3.5F, 3.0F);
        this.shape7.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(shape7, 0.0F, -0.18203784098300857F, 0.0F);
        this.shape7_3 = new ModelRenderer(this, 0, 0);
        this.shape7_3.setRotationPoint(0.5F, 3.0F, 3.0F);
        this.shape7_3.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(shape7_3, 0.18203784098300857F, 0.0F, 0.0F);
        this.shape7_4 = new ModelRenderer(this, 0, 0);
        this.shape7_4.setRotationPoint(0.5F, 3.5F, 3.0F);
        this.shape7_4.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(shape7_4, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape6 = new ModelRenderer(this, 40, 7);
        this.shape6.setRotationPoint(1.1F, 2.7F, 6.2F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.shape7_6 = new ModelRenderer(this, 0, 0);
        this.shape7_6.setRotationPoint(0.0F, 3.5F, 3.0F);
        this.shape7_6.addBox(0.0F, -0.5F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(shape7_6, 0.0F, 0.091106186954104F, 0.0F);
        this.shape7_2 = new ModelRenderer(this, 0, 0);
        this.shape7_2.setRotationPoint(0.5F, 4.0F, 3.0F);
        this.shape7_2.addBox(0.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.setRotateAngle(shape7_2, -0.18203784098300857F, 0.0F, 0.0F);
        this.shape7_7 = new ModelRenderer(this, 0, 0);
        this.shape7_7.setRotationPoint(2.0F, 3.0F, 3.0F);
        this.shape7_7.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(shape7_7, 0.0F, -0.091106186954104F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-2.0F, 17.0F, -3.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
        this.shape6.addChild(this.shape7_5);
        this.shape1.addChild(this.shape2);
        this.shape6.addChild(this.shape7_1);
        this.shape6.addChild(this.shape7);
        this.shape6.addChild(this.shape7_3);
        this.shape6.addChild(this.shape7_4);
        this.shape1.addChild(this.shape6);
        this.shape6.addChild(this.shape7_6);
        this.shape6.addChild(this.shape7_2);
        this.shape6.addChild(this.shape7_7);
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
