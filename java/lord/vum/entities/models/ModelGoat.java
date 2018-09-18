package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelGoat - JJo
 * Created using Tabula 5.0.0
 */
public class ModelGoat extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer Neck;
    public ModelRenderer Head;
    public ModelRenderer Jaw;
    public ModelRenderer LeftEar;
    public ModelRenderer RightEar;
    public ModelRenderer LeftHornMale;
    public ModelRenderer RightHornMale;

    public ModelGoat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.FrontLeftLeg = new ModelRenderer(this, 32, 8);
        this.FrontLeftLeg.setRotationPoint(0.9F, 3.75F, 0.9F);
        this.FrontLeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.Neck = new ModelRenderer(this, 40, 0);
        this.Neck.setRotationPoint(0.0F, 1.75F, 1.3F);
        this.Neck.addBox(-1.0F, -4.5F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Neck, 0.5462880558742251F, 0.0F, 0.0F);
        this.LeftHornMale = new ModelRenderer(this, 57, 0);
        this.LeftHornMale.setRotationPoint(-0.05F, -1.4F, 0.0F);
        this.LeftHornMale.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(LeftHornMale, 0.6373942428283291F, 0.18203784098300857F, 0.0F);
        this.Jaw = new ModelRenderer(this, 21, 7);
        this.Jaw.setRotationPoint(0.0F, -0.05F, -1.4F);
        this.Jaw.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(Jaw, -0.06911503837897544F, 0.0F, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 37, 8);
        this.BackLeftLeg.setRotationPoint(0.9F, 3.75F, 7.1F);
        this.BackLeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.RightEar = new ModelRenderer(this, 57, 3);
        this.RightEar.setRotationPoint(-1.0F, -1.25F, -0.75F);
        this.RightEar.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, 0.0F, 0.17453292519943295F);
        this.RightHornMale = new ModelRenderer(this, 57, 0);
        this.RightHornMale.setRotationPoint(0.05F, -1.4F, 0.0F);
        this.RightHornMale.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(RightHornMale, 0.6373942428283291F, -0.18203784098300857F, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 32, 8);
        this.FrontRightLeg.setRotationPoint(-0.9F, 3.75F, 0.9F);
        this.FrontRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.Tail = new ModelRenderer(this, 33, 0);
        this.Tail.setRotationPoint(0.0F, 0.5F, 7.5F);
        this.Tail.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Tail, -0.31869712141416456F, 0.0F, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 37, 8);
        this.BackRightLeg.setRotationPoint(-0.9F, 3.75F, 7.1F);
        this.BackRightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.LeftEar = new ModelRenderer(this, 61, 3);
        this.LeftEar.setRotationPoint(1.0F, -1.25F, -0.75F);
        this.LeftEar.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -0.17453292519943295F);
        this.Body = new ModelRenderer(this, 42, 0);
        this.Body.setRotationPoint(0.0F, 16.25F, -4.0F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 8, 0.0F);
        this.Head = new ModelRenderer(this, 22, 0);
        this.Head.setRotationPoint(0.0F, -4.3F, 0.7F);
        this.Head.addBox(-1.0F, -1.5F, -3.75F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Head, -0.36425021489121656F, 0.0F, 0.0F);
        this.Body.addChild(this.FrontLeftLeg);
        this.Body.addChild(this.Neck);
        this.Head.addChild(this.LeftHornMale);
        this.Head.addChild(this.Jaw);
        this.Body.addChild(this.BackLeftLeg);
        this.Head.addChild(this.RightEar);
        this.Head.addChild(this.RightHornMale);
        this.Body.addChild(this.FrontRightLeg);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.BackRightLeg);
        this.Head.addChild(this.LeftEar);
        this.Neck.addChild(this.Head);
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
}
