package lord.vum.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Chameleon - JJo
 * Created using Tabula 5.0.0
 */
public class Chameleon extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer tail1;
    public ModelRenderer frontleftleg;
    public ModelRenderer frontrightleg;
    public ModelRenderer backleftleg;
    public ModelRenderer backrightleg;
    public ModelRenderer head;
    public ModelRenderer tail2;
    public ModelRenderer tailcoil;
    public ModelRenderer Crest;
    public ModelRenderer eyebulge;
    public ModelRenderer eyes;

    public Chameleon() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.backrightleg = new ModelRenderer(this, 0, 8);
        this.backrightleg.mirror = true;
        this.backrightleg.setRotationPoint(-1.55F, 1.45F, 3.75F);
        this.backrightleg.addBox(-3.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.eyes = new ModelRenderer(this, 15, 8);
        this.eyes.setRotationPoint(-0.5F, 0.5F, 0.5F);
        this.eyes.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.5F, -2.8F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.tailcoil = new ModelRenderer(this, 51, 5);
        this.tailcoil.setRotationPoint(0.0F, 0.0F, 3.6F);
        this.tailcoil.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(tailcoil, -0.18203784098300857F, 0.0F, 0.0F);
        this.frontrightleg = new ModelRenderer(this, 0, 15);
        this.frontrightleg.mirror = true;
        this.frontrightleg.setRotationPoint(-1.55F, 1.45F, 1.25F);
        this.frontrightleg.addBox(-3.0F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.Crest = new ModelRenderer(this, 28, 0);
        this.Crest.setRotationPoint(0.0F, -1.5F, -2.55F);
        this.Crest.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(Crest, 0.5009094953223726F, 0.0F, 0.0F);
        this.eyebulge = new ModelRenderer(this, 0, 22);
        this.eyebulge.setRotationPoint(-2.0F, -1.25F, -2.5F);
        this.eyebulge.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.tail2 = new ModelRenderer(this, 50, 0);
        this.tail2.setRotationPoint(0.0F, 0.5F, 2.5F);
        this.tail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail2, -0.091106186954104F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 39, 0);
        this.tail1.setRotationPoint(0.0F, 0.5F, 4.7F);
        this.tail1.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tail1, 0.136659280431156F, 0.0F, 0.0F);
        this.frontleftleg = new ModelRenderer(this, 0, 15);
        this.frontleftleg.setRotationPoint(1.55F, 1.45F, 1.25F);
        this.frontleftleg.addBox(0.0F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.backleftleg = new ModelRenderer(this, 0, 8);
        this.backleftleg.setRotationPoint(1.55F, 1.45F, 3.75F);
        this.backleftleg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.head = new ModelRenderer(this, 16, 0);
        this.head.setRotationPoint(0.0F, 1.5F, 0.05F);
        this.head.addBox(-1.5F, -1.5F, -2.9F, 3, 3, 3, 0.0F);
        this.Body.addChild(this.backrightleg);
        this.eyebulge.addChild(this.eyes);
        this.tail2.addChild(this.tailcoil);
        this.Body.addChild(this.frontrightleg);
        this.head.addChild(this.Crest);
        this.head.addChild(this.eyebulge);
        this.tail1.addChild(this.tail2);
        this.Body.addChild(this.tail1);
        this.Body.addChild(this.frontleftleg);
        this.Body.addChild(this.backleftleg);
        this.Body.addChild(this.head);
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
